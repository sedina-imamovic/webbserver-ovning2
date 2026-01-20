package bih.iths.sedina.webserverovning;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafConfig {

    private static TemplateEngine templateEngine;

    public static TemplateEngine getTemplateEngine() {

        if (templateEngine == null) {
            var resolver = new ClassLoaderTemplateResolver();
            resolver.setPrefix("templates/");
            resolver.setSuffix(".html");
            resolver.setTemplateMode("HTML");
            resolver.setCharacterEncoding("UTF-8");
            templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);
        }
        return templateEngine;
    }

}
