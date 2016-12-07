package io.github.dbryla.gpsfm.jaxb;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "feed")
@Getter
@Setter
@ToString
public class Feed {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "link")
    private Link link;

    @XmlElement(name = "updated")
    private Date updated;

    @XmlElement(name = "entry")
    private List<Entry> entries;

}
