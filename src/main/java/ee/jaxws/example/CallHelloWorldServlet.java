package ee.jaxws.example;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;

@WebServlet("/callHelloWorldServlet")
public class CallHelloWorldServlet extends HttpServlet {
    @WebServiceRef
    HelloWorldExample helloWorldExample;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(helloWorldExample.seyHello());
    }
}
