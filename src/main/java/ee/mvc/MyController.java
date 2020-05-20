package ee.mvc;

import ee.bean.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MyController")
public class MyController  extends HttpServlet {
    MyModel model = new MyModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**  В контроллере получаем данные их модели и отправлям их в View */
        Person person = model.getPerson();
        req.setAttribute("person1",person); // аналогично <jsp:useBean id="person" class="ee.bean.Person" scope="request"></jsp:useBean>
        req.getSession().setAttribute("person2",person); //аналогично <jsp:useBean id="person" class="ee.bean.Person" scope="session"></jsp:useBean>
        req.getServletContext().setAttribute("person3",person);// аналогчно <jsp:useBean id="person" class="ee.bean.Person" scope="application"></jsp:useBean>
        /**  делаем форфардинг */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/MyView.jsp");
        requestDispatcher.forward(req,resp);
    }
}
