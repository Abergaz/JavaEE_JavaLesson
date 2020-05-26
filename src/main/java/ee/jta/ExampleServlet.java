package ee.jta;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/jtaSerlet")
public class ExampleServlet  extends HttpServlet {
    @EJB
    ExamplePersistBean examplePersistBean;
    @EJB
    ExampleBean exampleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        exampleBean.saveStudent();
    }
}
