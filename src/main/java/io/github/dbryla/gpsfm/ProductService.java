package io.github.dbryla.gpsfm;

import io.github.dbryla.gpsfm.jaxb.Feed;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
class ProductService {

    private final List<Product> products = new LinkedList<>();
    private JAXBContext jc;
    private Feed feed;

    ProductService(String resourcePath) {
        try {
            jc = JAXBContext.newInstance(Feed.class);
        } catch (JAXBException e) {
            log.error("Problem while creating jaxb context.", e);
            return;
        }
        loadProducts(resourcePath);
    }

    private void loadProducts(String resourcePath) {
        try {
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            feed = (Feed) unmarshaller.unmarshal(new FileInputStream(resourcePath));
        } catch (JAXBException | FileNotFoundException e) {
            log.error("Problem while loading products from storage.", e);
            return;
        }
        feed.getEntries().forEach(entry -> products.add(Product.of(entry)));
    }

    List<Product> getAll() {
        return products;
    }

    void changeStatus(String id) {
        products.stream()
                .filter(product -> product.getId().equals(id))
                .findAny().ifPresent(Product::changeIncludeStatus);
    }

    void generateReport(OutputStream outputStream) {
        try {
            Marshaller marshaller = jc.createMarshaller();
            feed.setEntries(products.stream()
                    .filter(Product::isIncluded)
                    .map(Product::toEntry)
                    .collect(Collectors.toList()));
            marshaller.marshal(feed, outputStream);
        } catch (JAXBException e) {
            log.error("Problem while generating report.", e);
        }
    }
}
