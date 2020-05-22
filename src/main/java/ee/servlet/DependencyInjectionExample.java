package ee.servlet;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DIExample")
public class DependencyInjectionExample  extends HttpServlet {
    /** говорим контейнеру поместить в переменную студент объект класса Student*/
    @Inject
    Student student;
    /** @Inject можно указывать над свойствами, консутруктором и сеттером */
    @Inject
    public DependencyInjectionExample(Student student) {
        this.student=student;
    }
    @Inject
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(student.getName());
    }
}
class Student{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
