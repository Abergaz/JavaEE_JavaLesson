package ee.ejb;

import ee.ejb.bean.ExampleBean;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(exampleBean.getName());
    }

    public static void main(String[] args) {
        try(EJBContainer ejbContainer = new EJBContainer.createEJBContainer()){
            ExampleBean exampleBean = (ExampleBean) ejbContainer.getContext().lookup("java:app/ExampleBean");
            System.out.println(exampleBean.getName());
        }catch (NamingException e){
            e.printStackTrace();
        }
    }
}
