package io.github.dbryla.gpsfm;

import spark.Spark;

public class Application {

    public static void main(String[] args) {
        setupServer();
        new Controller(new ProductService("GoogleProductSearch"), new View());
    }

    private static void setupServer() {
        Spark.exception(Exception.class, (e, request, response) -> e.printStackTrace());
        Spark.staticFiles.location("/public");
        Spark.port(getHerokuAssignedPort());
    }

    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
