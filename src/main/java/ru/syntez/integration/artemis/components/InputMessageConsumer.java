package ru.syntez.integration.artemis.components;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.syntez.integration.artemis.entities.RoutingDocument;
import ru.syntez.integration.artemis.exceptions.RouterException;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Date;

/**
 * Configuration custom InputMessageConsumer
 *
 * @author Skyhunter
 * @date 05.02.2021
 */
@Component
public class InputMessageConsumer {

    private static Logger LOG = LogManager.getLogger(InputMessageConsumer.class);

    @Value("${consumer.work-time}")
    private Integer delayMillis;

    @Autowired
    private JmsTemplate outputJmsTemplate;

    private final ObjectMapper xmlMapper;
    public InputMessageConsumer(ObjectMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private Integer consumedDocumentCount = 0;
    private Date startTime = new Date();

    @JmsListener(destination = "${jms.activemq.queues.input-output-endpoint}", containerFactory = "jmsListenerContainerFactory")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RouterException.class)
    public void receive(Message message) throws JMSException {

      //  LOG.info("Received message: " + message);
        final String xmlPayload = message.getBody(String.class);
        try {
            RoutingDocument document = xmlMapper.readValue(xmlPayload, RoutingDocument.class);
            Date totalTime = new Date();
            long seconds =  (totalTime.getTime() - startTime.getTime()) / 1000;
            consumedDocumentCount++;
          //  outputJmsTemplate.convertAndSend("outputQueue", message);
            LOG.info("CONSUMED MESSAGE, docId: {} docType: {}. Total consumed: {} seconds {}", document.getDocId(), document.getDocType(), consumedDocumentCount, seconds);
        } catch (Exception e) {
            LOG.error(String.format("Error send files %s", e.getMessage()));
        }
        /*
        if (consumedDocumentCount >= 10) {
            //Сброс счетчика, для повторной отправки
            consumedDocumentCount = 0;
            message.setJMSRedelivered(true);
            throw new RouterException("ConsumedDocumentCount > 10. Send to redelivery");
        }
        try {
            Thread.sleep(delayMillis);
            consumedDocumentCount++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       // LOG.info("CONSUMED MESSAGE. Total consumed: {}", consumedDocumentCount);

    }
}
