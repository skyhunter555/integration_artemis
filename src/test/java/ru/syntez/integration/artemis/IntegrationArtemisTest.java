package ru.syntez.integration.artemis;

import org.apache.activemq.ActiveMQSslConnectionFactory;
import java.util.logging.Logger;
import org.junit.Test;

import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.MessageProducer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 *  @author Skyhunter
 *  @date 15.03.2021
 */
public class IntegrationArtemisTest {

    private final static Logger LOG = Logger.getLogger(IntegrationArtemisTest.class.getName());

    private final String brokerConnector = "ssl://127.0.0.1:61618";
    private final String sslClientStorePass = "user555";
    private final String sslClientTrustedStorePath = "C:/Users/skyhunter/client_sender_ts.p12";
    private final String sslClientKeyStorePath = "C:/Users/skyhunter/client_sender_ks.p12";
    private final String brokerUser = "user";
    private final String brokerPass = "user";
    private String queueInputOutputEndpoint = "inputToOutputQueue3";

    private ConnectionFactory getConnectionFactory() throws Exception {
        ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(brokerConnector);
        connectionFactory.setTrustStore(sslClientTrustedStorePath);
        connectionFactory.setTrustStorePassword(sslClientStorePass);
        connectionFactory.setKeyStore(sslClientKeyStorePath);
        connectionFactory.setKeyStorePassword(sslClientStorePass);
        connectionFactory.setUserName(brokerUser);
        connectionFactory.setPassword(brokerPass);
        return connectionFactory;
    }

    @Test
    public void sendMessageToInputQueueTest() {

        try {
            String messageXml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/router_doc_1.xml").toURI())));
            Connection connection = getConnectionFactory().createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer msgProducer = session.createProducer(session.createQueue(queueInputOutputEndpoint));
            for (int i = 0; i < 10; i++) {
                TextMessage textMessage = session.createTextMessage(messageXml);
                msgProducer.send(textMessage);
                LOG.info("JMS text message sended to queue");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
