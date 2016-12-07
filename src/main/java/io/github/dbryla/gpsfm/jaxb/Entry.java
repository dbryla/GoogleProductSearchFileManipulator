package io.github.dbryla.gpsfm.jaxb;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.net.URL;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "entry")
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Entry {

    @XmlElement
    private String title;

    @XmlElement
    private String link;

    @XmlElement
    private String description;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String id;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String condition;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String price;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String availability;

    @XmlElement(name = "image_link", namespace = Namespaces.GOOGLE)
    private String imageLink;

    @XmlElement(name = "product_type", namespace = Namespaces.GOOGLE)
    private String productType;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String brand;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String gtin;

    @XmlElement(namespace = Namespaces.GOOGLE)
    private String mpn;

    @XmlElement(name = "shipping_weight", namespace = Namespaces.GOOGLE)
    private String shippingWeight;

    @XmlElement(name = "sale_price", namespace = Namespaces.GOOGLE)
    private String salePrice;

    @XmlElement(name = "sale_price_effective_date", namespace = Namespaces.GOOGLE)
    private String salePriceEffectiveDate;

}
