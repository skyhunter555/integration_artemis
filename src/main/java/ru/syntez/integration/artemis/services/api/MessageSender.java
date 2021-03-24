package ru.syntez.integration.artemis.services.api;

import ru.syntez.integration.artemis.entities.CITREQUESTINPUT;

public interface MessageSender {

    void transformAndSendToOutputQueue(CITREQUESTINPUT request);

}
