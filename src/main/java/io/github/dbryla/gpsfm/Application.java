package io.github.dbryla.gpsfm;

import spark.Spark;

public class Application {

    public static void main(String[] args) {
        setupServer();
        new Controller(new ProductService("src/main/resources/shortOne.xml"), new View());
    }

    private static void setupServer() {
        Spark.exception(Exception.class, (e, request, response) -> e.printStackTrace());
        Spark.staticFiles.location("/public");
        Spark.port(8080);
    }

}
