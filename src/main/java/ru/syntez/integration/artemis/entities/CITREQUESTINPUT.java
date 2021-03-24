package ru.syntez.integration.artemis.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "system",
        "data"
})
@XmlRootElement(name = "CIT_REQUEST_INPUT")
public class CITREQUESTINPUT {

    @XmlElement(name = "SYSTEM", required = true)
    @JacksonXmlProperty(localName = "SYSTEM")
    protected CITREQUESTINPUT.SYSTEM system;
    @XmlElement(name = "DATA", required = true)
    @JacksonXmlProperty(localName = "DATA")
    protected CITREQUESTINPUT.DATA data;

    public CITREQUESTINPUT.SYSTEM getSYSTEM() {
        return system;
    }

    public void setSYSTEM(CITREQUESTINPUT.SYSTEM value) {
        this.system = value;
    }

    public CITREQUESTINPUT.DATA getDATA() {
        return data;
    }

    public void setDATA(CITREQUESTINPUT.DATA value) {
        this.data = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "dogNum",
            "dogNewStatus",
            "dogNewDate",
            "channel",
            "depart"
    })
    public static class DATA {

        @XmlElement(name = "DogNum", required = true)
        @JacksonXmlProperty(localName = "DogNum")
        protected CITREQUESTINPUT.DATA.DogNum dogNum;
        @XmlElement(name = "DogNewStatus", required = true)
        @JacksonXmlProperty(localName = "DogNewStatus")
        protected CITREQUESTINPUT.DATA.DogNewStatus dogNewStatus;
        @XmlElement(name = "DogNewDate", required = true)
        @JacksonXmlProperty(localName = "DogNewDate")
        protected CITREQUESTINPUT.DATA.DogNewDate dogNewDate;
        @XmlElement(name = "Channel", required = true)
        @JacksonXmlProperty(localName = "Channel")
        protected CITREQUESTINPUT.DATA.Channel channel;
        @XmlElement(name = "Depart", required = true)
        @JacksonXmlProperty(localName = "Depart")
        protected CITREQUESTINPUT.DATA.Depart depart;

        public CITREQUESTINPUT.DATA.DogNum getDogNum() {
            return dogNum;
        }

        public void setDogNum(CITREQUESTINPUT.DATA.DogNum value) {
            this.dogNum = value;
        }

        public CITREQUESTINPUT.DATA.DogNewStatus getDogNewStatus() {
            return dogNewStatus;
        }

        public void setDogNewStatus(CITREQUESTINPUT.DATA.DogNewStatus value) {
            this.dogNewStatus = value;
        }

        public CITREQUESTINPUT.DATA.DogNewDate getDogNewDate() {
            return dogNewDate;
        }

        public void setDogNewDate(CITREQUESTINPUT.DATA.DogNewDate value) {
            this.dogNewDate = value;
        }

        public CITREQUESTINPUT.DATA.Channel getChannel() {
            return channel;
        }

        public void setChannel(CITREQUESTINPUT.DATA.Channel value) {
            this.channel = value;
        }

        public CITREQUESTINPUT.DATA.Depart getDepart() {
            return depart;
        }

        public void setDepart(CITREQUESTINPUT.DATA.Depart value) {
            this.depart = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Channel {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Depart {

            @XmlAttribute(name = "Value")
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;
            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DogNewDate {
            @XmlAttribute(name = "Value")
            @XmlSchemaType(name = "date")
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected XMLGregorianCalendar value;
            public XMLGregorianCalendar getValue() {
                return value;
            }
            public void setValue(XMLGregorianCalendar value) {
                this.value = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DogNewStatus {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DogNum {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "bpid",
            "citVersion",
            "err",
            "format",
            "msgid",
            "sync",
            "sysid",
            "tarid",
            "version"
    })
    public static class SYSTEM {

        @XmlElement(name = "BP_ID", required = true)
        @JacksonXmlProperty(localName = "BP_ID")
        protected CITREQUESTINPUT.SYSTEM.BPID bpid;
        @XmlElement(name = "CIT_Version", required = true)
        @JacksonXmlProperty(localName = "CIT_Version")
        protected CITREQUESTINPUT.SYSTEM.CITVersion citVersion;
        @XmlElement(name = "ERR")
        @JacksonXmlProperty(localName = "ERR")
        protected CITREQUESTINPUT.SYSTEM.ERR err;
        @XmlElement(name = "FORMAT", required = true)
        @JacksonXmlProperty(localName = "FORMAT")
        protected CITREQUESTINPUT.SYSTEM.FORMAT format;
        @XmlElement(name = "MSG_ID", required = true)
        @JacksonXmlProperty(localName = "MSG_ID")
        protected CITREQUESTINPUT.SYSTEM.MSGID msgid;
        @XmlElement(name = "SYNC", required = true)
        @JacksonXmlProperty(localName = "SYNC")
        protected CITREQUESTINPUT.SYSTEM.SYNC sync;
        @XmlElement(name = "SYS_ID", required = true)
        @JacksonXmlProperty(localName = "SYS_ID")
        protected CITREQUESTINPUT.SYSTEM.SYSID sysid;
        @XmlElement(name = "TAR_ID", required = true)
        @JacksonXmlProperty(localName = "TAR_ID")
        protected CITREQUESTINPUT.SYSTEM.TARID tarid;
        @XmlElement(name = "Version", required = true)
        @JacksonXmlProperty(localName = "Version")
        protected CITREQUESTINPUT.SYSTEM.Version version;

        public CITREQUESTINPUT.SYSTEM.BPID getBPID() {
            return bpid;
        }

        public void setBPID(CITREQUESTINPUT.SYSTEM.BPID value) {
            this.bpid = value;
        }

        public CITREQUESTINPUT.SYSTEM.CITVersion getCITVersion() {
            return citVersion;
        }

        public void setCITVersion(CITREQUESTINPUT.SYSTEM.CITVersion value) {
            this.citVersion = value;
        }

        public CITREQUESTINPUT.SYSTEM.ERR getERR() {
            return err;
        }

        public void setERR(CITREQUESTINPUT.SYSTEM.ERR value) {
            this.err = value;
        }

        public CITREQUESTINPUT.SYSTEM.FORMAT getFORMAT() {
            return format;
        }

        public void setFORMAT(CITREQUESTINPUT.SYSTEM.FORMAT value) {
            this.format = value;
        }

        public CITREQUESTINPUT.SYSTEM.MSGID getMSGID() {
            return msgid;
        }

        public void setMSGID(CITREQUESTINPUT.SYSTEM.MSGID value) {
            this.msgid = value;
        }

        public CITREQUESTINPUT.SYSTEM.SYNC getSYNC() {
            return sync;
        }

        public void setSYNC(CITREQUESTINPUT.SYSTEM.SYNC value) {
            this.sync = value;
        }

        public CITREQUESTINPUT.SYSTEM.SYSID getSYSID() {
            return sysid;
        }

        public void setSYSID(CITREQUESTINPUT.SYSTEM.SYSID value) {
            this.sysid = value;
        }

        public CITREQUESTINPUT.SYSTEM.TARID getTARID() {
            return tarid;
        }

        public void setTARID(CITREQUESTINPUT.SYSTEM.TARID value) {
            this.tarid = value;
        }

        public CITREQUESTINPUT.SYSTEM.Version getVersion() {
            return version;
        }

        public void setVersion(CITREQUESTINPUT.SYSTEM.Version value) {
            this.version = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class BPID {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;
            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class CITVersion {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;
            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ERR {

            @XmlAttribute(name = "Value")
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;
            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class FORMAT {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                if (value == null) {
                    return "XML";
                } else {
                    return value;
                }
            }
            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MSGID {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SYNC {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SYSID {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TARID {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Version {

            @XmlAttribute(name = "Value", required = true)
            @JacksonXmlProperty(localName = "Value", isAttribute = true)
            protected String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
