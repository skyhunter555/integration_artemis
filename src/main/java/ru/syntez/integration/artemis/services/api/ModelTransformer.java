package ru.syntez.integration.artemis.services.api;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.syntez.integration.artemis.entities.CITREQUESTINPUT;
import ru.syntez.integration.artemis.entities.CITREQUESTOUT;

@Mapper
public interface ModelTransformer {

    ModelTransformer MAPPER = Mappers.getMapper(ModelTransformer.class);

    CITREQUESTOUT makeOutputFrom(CITREQUESTINPUT request);

    @Mappings({
            @Mapping(source="BPID.value",target = "BPID"),
            @Mapping(source="CITVersion.value",target = "CITVersion"),
            @Mapping(source="ERR.value",target = "ERROR"),
            @Mapping(source="FORMAT.value",target = "FORMAT"),
            @Mapping(source="MSGID.value",target = "MSGID"),
            @Mapping(source="SYNC.value",target = "SYNC"),
            @Mapping(source="SYSID.value",target = "SYSID"),
            @Mapping(source="TARID.value",target = "TARID"),
            @Mapping(source="version.value",target = "version"),
    })
    CITREQUESTOUT.SYSTEM makeFrom(CITREQUESTINPUT.SYSTEM system);

    @Mappings({
            @Mapping(source="dogNum.value",target = "dogNum"),
            @Mapping(source="dogNewStatus.value",target = "dogNewStatus"),
            @Mapping(source="dogNewDate.value",target = "dogNewDate"),
            @Mapping(source="channel.value",target = "channel"),
            @Mapping(source="depart.value",target = "depart"),
    })
    CITREQUESTOUT.DATA makeFrom(CITREQUESTINPUT.DATA data);

}
