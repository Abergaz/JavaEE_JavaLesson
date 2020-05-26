package ee.ejb;

import ee.ejb.bean.ExampleBean;
import ee.ejb.bean.SecondBean;

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
    ExampleBean exampleBean;
    @EJB
    SecondBean secondBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
