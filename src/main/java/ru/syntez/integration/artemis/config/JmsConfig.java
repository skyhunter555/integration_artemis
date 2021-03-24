package ru.syntez.integration.artemis.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;

import static org.apache.activemq.artemis.jms.client.ActiveMQDestination.TYPE.QUEUE;
import static org.apache.activemq.artemis.jms.client.ActiveMQDestination.createDestination;

/**
 * Configuration for spring integration jms
 * 1. Create ConnectionFactory
 * 2. Create queue
 *
 * @author Skyhunter
 * @date 22.03.2021
 */
@Configuration
public class JmsConfig {

    @Value("${jms.activemq.brokerUrl}")
    private String brokerConnector = "tcp://localhost:61616";

    @Value("${jms.activemq.user}")
    private String brokerUser = "user";

    @Value("${jms.activemq.password}")
    private String brokerPass = "user";

    @Value("${jms.activemq.queues.output-endpoint}")
    private String queueOutputEndpoint = "outputQueue";

    @Bean
    public ObjectMapper xmlMapper() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        ObjectMapper xmlMapper = new XmlMapper(xmlModule);
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return new XmlMapper(xmlModule);
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerConnector);
        connectionFactory.setUser(brokerUser);
        connectionFactory.setPassword(brokerPass);
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
        cachingConnectionFactory.setCacheConsumers(false);
        cachingConnectionFactory.setSessionCacheSize(20);
        return cachingConnectionFactory;
    }

    @Bean
    public Queue destinationQueue() {
        return (Queue) createDestination(queueOutputEndpoint, QUEUE);
    }

    @Bean
    public Session jmsSession(ConnectionFactory connectionFactory) throws JMSException {
        return connectionFactory.createConnection().createSession();
    }

}

