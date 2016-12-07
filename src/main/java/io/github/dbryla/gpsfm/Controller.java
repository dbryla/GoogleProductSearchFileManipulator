package io.github.dbryla.gpsfm;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import lombok.extern.slf4j.Slf4j;
import spark.Spark;

@Slf4j
class Controller {

    Controller(ProductService productService, View view) {
        Spark.get("/", (request, response) -> view.renderList(request, productService.getAll()));
        Spark.put("/products/:id/toggle", (request, response) -> {
            String id = request.params("id");
            log.info("Toggle {}", id);
            productService.changeStatus(id);
            return view.renderList(request, productService.getAll());
        });
        Spark.get("/products/report", (request, response) -> {
            log.info("Generate report");
            HttpServletResponse raw = response.raw();
            raw.setContentType("application/octet-stream");
            raw.setHeader("Content-Disposition", "attachment; filename=GoogleProductSearch.zip");
            ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(raw.getOutputStream()));
            outputStream.putNextEntry(new ZipEntry("public/GoogleProductSearch"));
            productService.generateReport(outputStream);
            outputStream.flush();
            outputStream.close();
            return raw;
        });
    }

}
