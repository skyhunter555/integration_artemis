package ru.syntez.integration.artemis.services.api;

import ru.syntez.integration.artemis.entities.CITREQUESTINPUT;
import ru.syntez.integration.artemis.entities.CITREQUESTOUT;

public interface ModelParser {

    CITREQUESTINPUT parseFromXml(String inputServiceRequestXml);

    String writeToXml(CITREQUESTOUT outputServiceRequest);

}
