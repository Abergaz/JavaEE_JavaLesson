package ee.servlet;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
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
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    Car car;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(car.name);
    }
}

class Producer {
    @Produces
    Car getCar() {
        return (new Car("lada"));
    }

    /** метод помеченный @Disposes вызовется в самом конце при очистке ресурсов*/
    public void clean(@Disposes Car car){
        car.clean();
    }

}

class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }
    public void clean(){
        System.out.println("car clean");
    }
}


