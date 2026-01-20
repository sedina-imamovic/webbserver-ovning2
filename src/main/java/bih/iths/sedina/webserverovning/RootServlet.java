package bih.iths.sedina.webserverovning;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //resp.getWriter().println("Välkommen till startsidan!");

        var engine = ThymeleafConfig.getTemplateEngine();
        var context = new org.thymeleaf.context.Context();

        context.setVariable("title", "Välkommen till startsidan!");

        resp.setContentType("text/html;charset=UTF-8");
        engine.process("index", context, resp.getWriter());

    }
}
