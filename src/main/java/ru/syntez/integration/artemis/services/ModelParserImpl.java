package ru.syntez.integration.artemis.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.syntez.integration.artemis.entities.CITREQUESTINPUT;
import ru.syntez.integration.artemis.entities.CITREQUESTOUT;
import ru.syntez.integration.artemis.services.api.ModelParser;

@Service
public final class ModelParserImpl implements ModelParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelParserImpl.class);

    private final ObjectMapper xmlMapper;
    public ModelParserImpl(ObjectMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    @Override
    public CITREQUESTINPUT parseFromXml(String inputServiceRequestXml) {
        try {
            final CITREQUESTINPUT request = xmlMapper.readValue(inputServiceRequestXml, CITREQUESTINPUT.class);
            //LOGGER.info("Parsing object {} from XML {}",request,inputServiceRequestXml);
            return request;
        } catch (Exception e) {
            throw new IllegalStateException("JaxBContext cannot be created: cause ->",e);
        }
    }

    @Override
    public String writeToXml(CITREQUESTOUT outputServiceRequest) {
        try {
            final String xmlBody = xmlMapper.writeValueAsString(outputServiceRequest);
            //LOGGER.info("Writing to the output {} from {}",xmlBody,outputServiceRequest);
            return xmlBody;
        } catch (Exception e) {
            throw new IllegalArgumentException("Request cannot be converted "+outputServiceRequest,e);
        }
    }

}
