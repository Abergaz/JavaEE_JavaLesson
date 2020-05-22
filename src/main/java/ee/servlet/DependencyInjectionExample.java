package ee.servlet;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
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
    @Inject
    String s;

    @Inject @S2
    String s2;


    @Inject
    int i;

    @Inject
    double d;

    @Inject
    Car car;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("s="+s+"; ");
        resp.getWriter().write("i"+i+"; ");
        resp.getWriter().write("d="+d+"; ");
        resp.getWriter().write("car.name="+car.name+"; ");
        resp.getWriter().write("s2="+s2+"; ");
    }
}
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@interface S2{};

class Producer{
    @Produces
    String s = "hello world";

    @Produces @S2
    String s2 = "second string";

    @Produces
    int i=5;

    @Produces
    double getDouble(){
        return 1+3.3+5.8;
    }

    @Produces
    Car getCar(){
        return (new Car("lada"));
    }
}
class Car{
    String name;


    public Car(String name) {
        this.name = name;
    }
}


