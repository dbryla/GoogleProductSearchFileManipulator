package io.github.dbryla.gpsfm;

import io.github.dbryla.gpsfm.jaxb.Entry;
import lombok.Getter;

@Getter
public class Product {

    private String id;
    private String title;
    private String description;
    private String productType;
    private String link;
    private String imageLink;
    private String condition;
    private String availability;
    private String price;
    private String salePrice;
    private String salePriceEffectiveDate;
    private String brand;
    private String gtin;
    private String mpn;
    private String shippingWeight;
    private boolean included = true;

    static Product of(Entry entry) {
        Product product = new Product();
        product.id = entry.getId();
        product.title = entry.getTitle();
        product.description = entry.getDescription();
        product.productType = entry.getProductType();
        product.link = entry.getLink();
        product.imageLink = entry.getImageLink();
        product.condition = entry.getCondition();
        product.availability = entry.getAvailability();
        product.price = entry.getPrice();
        product.salePrice = entry.getSalePrice();
        product.salePriceEffectiveDate = entry.getSalePriceEffectiveDate();
        product.brand = entry.getBrand();
        product.gtin = entry.getGtin();
        product.mpn = entry.getMpn();
        product.shippingWeight = entry.getShippingWeight();
        return product;
    }

    void changeIncludeStatus() {
        included = !included;
    }

    Entry toEntry() {
        return Entry.builder()
                .id(id)
                .title(title)
                .description(description)
                .productType(productType)
                .link(link)
                .imageLink(imageLink)
                .condition(condition)
                .availability(availability)
                .price(price)
                .salePrice(salePrice)
                .salePriceEffectiveDate(salePriceEffectiveDate)
                .brand(brand)
                .gtin(gtin)
                .mpn(mpn)
                .shippingWeight(shippingWeight)
                .build();
    }
}
