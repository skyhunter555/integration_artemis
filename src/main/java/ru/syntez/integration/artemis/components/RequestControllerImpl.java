package ru.syntez.integration.artemis.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.syntez.integration.artemis.entities.CITREQUESTINPUT;
import ru.syntez.integration.artemis.services.api.MessageSender;
import ru.syntez.integration.artemis.services.api.ModelParser;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Date;


@Component
public class RequestControllerImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestControllerImpl.class);

    private Integer consumedDocumentCount = 0;
    private Date startTime = new Date();

    private final MessageSender messageSender;
    private final ModelParser modelParser;

    public RequestControllerImpl(
            MessageSender messageSender,
            ModelParser modelParser
    ) {
        this.messageSender = messageSender;
        this.modelParser = modelParser;
    }

    @JmsListener(destination = "${jms.activemq.queues.input-output-endpoint}")
    public void processMessage (Message message) throws JMSException {

        final String xmlPayload = message.getBody(String.class);

        try {
            //LOGGER.info ("Received message {}",xmlPayload);
            final CITREQUESTINPUT inputServiceRequest = modelParser.parseFromXml(xmlPayload);
            messageSender.transformAndSendToOutputQueue(inputServiceRequest);

            if (consumedDocumentCount == 0) {
                startTime = new Date();
            }
            Date totalTime = new Date();
            long seconds =  (totalTime.getTime() - startTime.getTime()) / 1000;
            consumedDocumentCount++;
            LOGGER.info("transformAndSendToOutputQueue. Total consumed: {} seconds {}", consumedDocumentCount, seconds);
        } catch (Exception e) {
            LOGGER.error("Error: cause ->",e);
        }

    }

}
