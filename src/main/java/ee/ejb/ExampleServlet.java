package ee.ejb;

import ee.ejb.bean.ExampleBean;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ejbExample")
public class ExampleServlet extends HttpServlet {
    @Resource(lookup = "java:app/ExampleBean") /** Можно получить EJB бин через resource указав JNDI имяы*/
    ExampleBean exampleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /** или вместо @EJB или @Resource EJB бины можно поолучить из InitialContext использую JNDI имя формата:
        java:<scope>[/app-name]/[module-name]/bean-name[!<fully-qualified-interface-name] */
        InitialContext initialContext = null;
        ExampleBean exampleBean2 = null;
        try {
            initialContext = new InitialContext();
            exampleBean2 = (ExampleBean) initialContext.lookup("java:app/ExampleBean");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        resp.getWriter().write(exampleBean.getName());
        resp.getWriter().write(exampleBean2.getName());
    }
}
