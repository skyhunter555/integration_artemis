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
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.jms.ConnectionFactory;

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

    @Value("${jms.ssl.client-store-password}")
    private String sslClientStorePass = "user555";

    @Value("${jms.ssl.client-consumer-trusted-store-path}")
    private String sslClientTrustedStorePath = "C:/Users/skyhunter/client_consumer_ts.p12";

    @Value("${jms.ssl.client-consumer-key-store-path}")
    private String sslClientKeyStorePath = "C:/Users/skyhunter/client_consumer_ks.p12";

    @Bean
    public CachingConnectionFactory connectionFactory() throws Exception {
        ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(brokerConnector);
        connectionFactory.setTrustStore(sslClientTrustedStorePath);
        connectionFactory.setTrustStorePassword(sslClientStorePass);
        connectionFactory.setKeyStore(sslClientKeyStorePath);
        connectionFactory.setKeyStorePassword(sslClientStorePass);
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

}

