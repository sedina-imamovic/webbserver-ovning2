package bih.iths.sedina.webserverovning;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello/*")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //resp.getWriter().println("Hej från /hello");

        // request parametrar - ett sätt att skicka in dynamisk data till en servlet
//        String name = req.getParameter("name");
//        resp.getWriter().println("Hej " + name);


        // Kod som kan läsa path-parametern i den existerande metoden
        String path = req.getPathInfo();
        String name = (path != null && path.length() > 1)
                ? path.substring(1)
                //   : "";
                : "världen";

        //resp.getWriter().println("Hej " + name);

        var engine = ThymeleafConfig.getTemplateEngine();
        var context = new org.thymeleaf.context.Context();

        context.setVariable("name", name);

        resp.setContentType("text/html;charset=UTF-8");
        engine.process("hello", context, resp.getWriter());


    }
}
