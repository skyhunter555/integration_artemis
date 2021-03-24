package ru.syntez.integration.artemis.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.syntez.integration.artemis.entities.CITREQUESTINPUT;
import ru.syntez.integration.artemis.entities.CITREQUESTOUT;
import ru.syntez.integration.artemis.services.api.MessageSender;
import ru.syntez.integration.artemis.services.api.ModelParser;
import ru.syntez.integration.artemis.services.api.ModelTransformer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;


@Service
public final class MessageSenderImpl implements MessageSender {

    private static final Logger LOGGER  = LoggerFactory.getLogger(MessageSenderImpl.class);

    private final ModelTransformer modelTransformer = ModelTransformer.MAPPER;
    private final ModelParser modelParser;
    private final Session jmsSession;
    private final Queue jmsQueue;

    @Autowired
    public MessageSenderImpl(
            ModelParser modelParser,
            Session jmsSession,
            Queue jmsQueue
    ) {
        this.modelParser = modelParser;
        this.jmsSession = jmsSession;
        this.jmsQueue = jmsQueue;
    }

    @Override
    public void transformAndSendToOutputQueue(CITREQUESTINPUT request)  {

       try {
           final CITREQUESTOUT outputRequest = modelTransformer.makeOutputFrom(request);
           final String message = modelParser.writeToXml(outputRequest);

           final TextMessage textMessage = jmsSession.createTextMessage();
           textMessage.setText(message);
           final MessageProducer producer = jmsSession.createProducer(jmsQueue);
           producer.send(textMessage);

           //LOGGER.info("The request {} was transformed to {} and send as {}",request,message,textMessage);

       } catch (Exception e) {
           LOGGER.error("Sender error: cause ->",e);
           throw new IllegalStateException("The input message cannot be sent correctly: ",e);
       }

    }

}
