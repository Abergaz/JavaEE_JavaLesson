package ee.servlet;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@WebServlet("/DIExample")
public class DependencyInjectionExample  extends HttpServlet {
    /** Если есть несколько реализаций интерфейся и не используем Quantifier
     * то надо пометить один класс реализацию @Alternative и указать этот класс в
     * WEB-INF/beans.xml в тег alternatives */
    @Inject
    Person person;

    @Inject
    Person person2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(person.getName());
        System.out.println(person2.getName());
    }
}



interface Person {
    String getName();
}

@Alternative
class Student implements Person{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return "student";
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Worker implements Person{
    @Override
    public String getName() {
        return "worker";
    }
}