package ee.jta;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;


@WebServlet("/jtaSerlet")
public class ExampleServlet  extends HttpServlet {
    @Inject
    StudentDB studentDB;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentDB.saveStudent();
    }
}

/** Обычный бин не EJB*/
@Transactional(rollbackOn = Exception.class) /** Помечаем класс или метод и он работает как EJB бин*/
@RequestScoped
class StudentDB{
    @PersistenceContext
    EntityManager entityManager;
    public void saveStudent(){
        entityManager.persist("Max");
    }

}