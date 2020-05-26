package ee.ejb;

import ee.ejb.bean.ExampleBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@WebServlet("/ejbExample")
public class ExampleServlet extends HttpServlet {
    @EJB
    ExampleBean exampleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        exampleBean.getName();
        Future<String> future =exampleBean.getMyName();/** получаем результат из асинхронного метода*/
        resp.getWriter().write("complete");
        try {
            resp.getWriter().write(future.get()); /** выведиттся когда отработает асинхронный метод*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
