package ru.syntez.integration.artemis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
import ru.syntez.integration.artemis.entities.RoutingDocument;

import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.JMSException;
import java.util.logging.Logger;

/**
 * Main class for console running
 *
 * @author Skyhunter
 * @date 15.03.2021
 */

public class IntegrationArtemisMain {

    private final static Logger LOG = Logger.getLogger(IntegrationArtemisMain.class.getName());

    private static final String brokerConnector = "ssl://127.0.0.1:61618";
    private static final String brokerUser = "user";
    private static final String brokerPass = "user";
    private static final String queueInputOutputEndpoint = "queue://inputToOutputQueue3";
    private static final String sslClientStorePass = "user555";
    private static final String sslClientTrustedStorePath = "C:/Users/skyhunter/client_consumer_ts.p12";
    private static final String sslClientKeyStorePath = "C:/Users/skyhunter/client_consumer_ks.p12";

    public static void main(String[] args) throws Exception {

        LOG.info("Receive Setup...");
        ConnectionFactory connectionFactory = getConnectionFactory();

        Destination destination = ActiveMQDestination.createDestination(queueInputOutputEndpoint,  ActiveMQDestination.QUEUE_TYPE);

            Connection conn = connectionFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message)  {

                    LOG.info("Received Message: ");
                    ObjectMapper xmlMapper = getXmlMapper();
                    xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    final String xmlPayload;
                    if (message instanceof TextMessage) {
                        // LOG.debug("Text message with no schema");
                        try {
                            xmlPayload = ((TextMessage) message).getText();
                        } catch (JMSException jex) {
                            LOG.warning(String.format("Unsupported JMS message type %s", message.getClass()));
                            return;
                        }
                    } else {
                        LOG.warning(String.format("Unsupported JMS message type %s", message.getClass()));
                        return;
                    }

                    try {
                        RoutingDocument document = xmlMapper.readValue(xmlPayload, RoutingDocument.class);
                        LOG.info(String.format("CONSUMED MESSAGE, docId: %s docType: %s", document.getDocId(), document.getDocType()));
                    } catch (Exception e) {
                        LOG.warning(String.format("Error consume message %s", e.getMessage()));
                    }
                }
            });
            conn.start();
            Thread.sleep(100000);

    }

    private static ObjectMapper getXmlMapper() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        return new XmlMapper(xmlModule);
    }

    private static ConnectionFactory getConnectionFactory() throws Exception {
        ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(brokerConnector);
        connectionFactory.setTrustStore(sslClientTrustedStorePath);
        connectionFactory.setTrustStorePassword(sslClientStorePass);
        connectionFactory.setKeyStore(sslClientKeyStorePath);
        connectionFactory.setKeyStorePassword(sslClientStorePass);
        connectionFactory.setUserName(brokerUser);
        connectionFactory.setPassword(brokerPass);
        return connectionFactory;
    }

}