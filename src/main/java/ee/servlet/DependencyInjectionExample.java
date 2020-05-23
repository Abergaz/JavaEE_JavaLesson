package ee.servlet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DIExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    MyBean myBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** передаем управление на JSP*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/BeanExample.jsp");
        requestDispatcher.forward(req,resp);
    }
}
/** @Named - нужна для того чтобы можно было бин использовать на JSP стрнице и @RequestScoped */
@RequestScoped
@Named
class MyBean{
    private String s ="hello world";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}


