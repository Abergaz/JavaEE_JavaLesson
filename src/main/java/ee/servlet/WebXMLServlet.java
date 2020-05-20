package ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/** вместо @WebServlet используем описание сервлета в web.xml */

public class WebXMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /** получаем параметры описанные в web.xml*/
        resp.getWriter().write(getServletConfig().getInitParameter("name"));
       /** или вывести все */
        Enumeration<String> initParameterNames =  getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            System.out.println(name+": "+ getServletConfig().getInitParameter(name));
        }
        /** получем context-param обшие для всех сервлетов */
        System.out.println(getServletContext().getInitParameter("email"));

    }
}
