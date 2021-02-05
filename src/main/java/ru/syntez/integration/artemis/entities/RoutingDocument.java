package ru.syntez.integration.artemis.entities;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * RoutingDocument model
 *
 * @author Skyhunter
 * @date 18.01.2021
 */
@XmlRootElement(name = "routingDocument")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class RoutingDocument implements Serializable {

    private DocumentTypeEnum docType;
    private int docId;

}
