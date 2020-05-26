package ee.ejb;

import ee.ejb.bean.ExampleBean;
import ee.ejb.bean.LocalExampleInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ejbExample")
public class ExampleServlet extends HttpServlet {
    @EJB
    LocalExampleInterface localExampleInterface; /** interface bean*/

    @EJB
    ExampleBean exampleBean; /** no interface bean*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(localExampleInterface.getName()); /** интерфейс бин */
        resp.getWriter().write(exampleBean.getName());/** non interface бин, не будет работать если у бина нет аннотации @LocalBean */
        resp.getWriter().write(exampleBean.getSerName());
    }
}
