package ru.syntez.integration.artemis;

import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.apache.activemq.artemis.core.protocol.core.Channel;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Ignore
public class IntegrationArtemisTest {

    @Value("${jms.activemq.queues.input-output-endpoint}")
    private String queueInputOutputEndpoint = "inputToOutputQueue";

    @Configuration
    public static class Config {

        @Value("${jms.activemq.brokerUrl}")
        private String brokerConnector = "tcp://localhost:61616";

        @Value("${jms.activemq.user}")
        private String brokerUser = "user";

        @Value("${jms.activemq.password}")
        private String brokerPass = "user";

        @Bean
        public CachingConnectionFactory connectionFactory() throws Exception {
            ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(brokerConnector);
            connectionFactory.setTrustStore("C:/Users/skyhunter/client-truststore.jks");
            connectionFactory.setTrustStorePassword("wso2carbon");
            connectionFactory.setKeyStore("C:/Users/skyhunter/wso2carbon.jks");
            connectionFactory.setKeyStorePassword("wso2carbon");
            connectionFactory.setUserName(brokerUser);
            connectionFactory.setPassword(brokerPass);
            CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
            cachingConnectionFactory.setCacheConsumers(false);
            cachingConnectionFactory.setSessionCacheSize(20);
            return cachingConnectionFactory;
        }
    }

    @Autowired
    ConnectionFactory connectionFactory;

    @Test
    public void sendMessageToInputQueueTest() {


        try {
            String messageXml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/router_doc_1.xml").toURI())));
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer msgProducer = session.createProducer(session.createQueue(queueInputOutputEndpoint));
            for (int i = 0; i < 100; i++) {
                TextMessage textMessage = session.createTextMessage(messageXml);
                msgProducer.send(textMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
