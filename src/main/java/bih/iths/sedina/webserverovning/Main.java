package bih.iths.sedina.webserverovning;

public class Main {

    public static void main(String[] args) throws Exception {

        // starta webbservern
        var server = new org.eclipse.jetty.server.Server(8080);

        // i denna context kan man registrera servlets
        var context = new org.eclipse.jetty.servlet.ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(RootServlet.class, "/");
        //context.addServlet(HelloServlet.class, "/hello");

        // när man vill skicka data via s.k. path parametrar
        context.addServlet(HelloServlet.class, "/hello/*");

        // starta servern
        server.start();
        server.join();
        
        //    http://localhost:8080/hello/Anna

    }
}
