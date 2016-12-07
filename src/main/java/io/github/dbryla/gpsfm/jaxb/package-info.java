@XmlSchema(
        namespace = Namespaces.ATOM,
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(namespaceURI = Namespaces.ATOM, prefix = ""),
                @XmlNs(namespaceURI = Namespaces.GOOGLE, prefix = "g")
        }
)
package io.github.dbryla.gpsfm.jaxb;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
