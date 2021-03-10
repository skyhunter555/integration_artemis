package ru.syntez.integration.artemis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.transaction.TransactionInterceptorBuilder;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.util.ErrorHandler;
import javax.jms.ConnectionFactory;
import javax.jms.Session;

/**
 * Configuration for spring integration jms
 * 1. Create ConnectionFactory
 * 2. Create queue
 * 4. Create IntegrationFlow to routing documents
 * 5. TransactionManager
 *
 * @author Skyhunter
 * @date 04.02.2021
 */
@Configuration
public class JmsConfig {

    private static Logger LOG = LogManager.getLogger(JmsConfig.class);

    @Value("${jms.activemq.brokerUrl}")
    private String brokerConnector = "tcp://localhost:61616";

    @Value("${jms.activemq.user}")
    private String brokerUser = "user";

    @Value("${jms.activemq.password}")
    private String brokerPass = "user";

    @Value("${jms.activemq.queues.input-output-endpoint}")
    private String queueInputOutputEndpoint = "inputToOutputQueue";

    @Value("${jms.activemq.queues.output-endpoint}")
    private String queueOutputEndpoint = "outputQueue";

    @Value("${jms.activemq.redeliveryCount}")
    private Integer redeliveryCount;

    @Value("${jms.activemq.redeliveryDelayMs}")
    private Integer redeliveryDelayMs;

    @Bean
    public CachingConnectionFactory connectionFactory() throws Exception {
        ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(brokerConnector);
        connectionFactory.setTrustStore("C:/Users/skyhunter/client_consumer_ts.p12");
        connectionFactory.setTrustStorePassword("user555");
        connectionFactory.setKeyStore("C:/Users/skyhunter/client_consumer_ks.p12");
        connectionFactory.setKeyStorePassword("user555");
        connectionFactory.setUserName(brokerUser);
        connectionFactory.setPassword(brokerPass);
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
        cachingConnectionFactory.setCacheConsumers(false);
        cachingConnectionFactory.setSessionCacheSize(20);
        return cachingConnectionFactory;
    }

    @Bean
    public ObjectMapper xmlMapper() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        return new XmlMapper(xmlModule);
    }

    @Bean
    public PlatformTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
        return new JmsTransactionManager(connectionFactory);
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller(final PlatformTransactionManager jmsTransactionManager) {
        return Pollers.fixedDelay(10)
                .advice(new TransactionInterceptorBuilder()
                        .transactionManager(jmsTransactionManager)
                        .propagation(Propagation.REQUIRED)
                        .build())
                .get();
    }

    @Bean
    public MessageChannel outputMessageChannel() {
        return MessageChannels.queue(queueOutputEndpoint).get();
    }

    @Service
    public class ExampleErrorHandler implements ErrorHandler {
        @Override
        public void handleError(Throwable t) {
            //handle exception here
            LOG.info("Error {}", t.getMessage());
        }
    }

    @Bean
    MessageChannel errorChannel() {
        return MessageChannels.direct("errorChannel").get();
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory, ExampleErrorHandler errorHandler) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        factory.setClientId(queueInputOutputEndpoint);
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("500-500");
        factory.setRecoveryInterval(10000L);
        factory.setSessionTransacted(true);
        factory.setTransactionManager(jmsTransactionManager(connectionFactory));
        factory.setErrorHandler(errorHandler);
        return factory;
    }

}

