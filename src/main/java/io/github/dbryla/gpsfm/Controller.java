package io.github.dbryla.gpsfm;

import lombok.extern.slf4j.Slf4j;
import spark.Spark;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
        Spark.put("/products/report", (request, response) -> {
            log.info("Generate report");
            /*HttpServletResponse raw = response.raw();
            raw.setContentType("application/octet-stream");
            raw.setHeader("Content-Disposition", "attachment; filename=GoogleProductSearch.zip");
            ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(raw.getOutputStream()));
            outputStream.putNextEntry(new ZipEntry("GoogleProductSearch"));
            productService.generateReport(outputStream);
            outputStream.flush();
            outputStream.close();*/
            response.type("text/xml");
            return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
        });
    }

}
