package io.github.dbryla.gpsfm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

class View {

    private final VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

    String renderList(Request request, List<Product> products) {
        Map<String, Object> model = new HashMap<>();
        model.put("products", products);
        if ("true".equals(request.queryParams("ic-request"))) {
            return renderTemplate("velocity/list.vm", model);
        }
        return renderTemplate("velocity/index.vm", model);
    }

    private String renderTemplate(String template, Map model) {
        return velocityTemplateEngine.render(new ModelAndView(model, template));
    }
}
