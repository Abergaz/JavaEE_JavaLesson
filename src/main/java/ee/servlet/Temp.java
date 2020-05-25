package ee.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;


@WebServlet("/temp")
public class Temp extends HttpServlet {
   @Inject
    Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<Child>> constraintViolationSet = validator.validateValue(Child.class,"name",null) ;
        for(ConstraintViolation<Child> constraintViolation: constraintViolationSet){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
    }
}

class PersonT{
    @NotNull
    String name;
}
class Child extends PersonT{
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
}
