package io.github.dbryla.gpsfm.jaxb;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "link")
@Getter
@Setter
@ToString
public class Link {

    @XmlAttribute
    private String rel;

    @XmlAttribute
    private String href;

}
