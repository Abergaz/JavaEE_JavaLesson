package ee.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/MyServletContext")
public class MyContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** это контекст уровня scope=application
            можно обмениваться данными между сервлетами */
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("one","value");

        /** можно даже передавать данные между приложениями но не бесзопасно*/
        servletContext.getContext("/url");

        Enumeration<String> attributeNames= servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            System.out.println(name +": "+servletContext.getAttribute(name));
        }
    }
}
