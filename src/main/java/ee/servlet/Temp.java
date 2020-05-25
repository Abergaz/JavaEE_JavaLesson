package ee.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;


@WebServlet("/temp")
public class Temp extends HttpServlet {
   @Inject
    Validator validator;
   @Inject PersonT personT;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<PersonT>> constraintViolationSet = validator.validate(personT) ;
        for(ConstraintViolation<PersonT> constraintViolation: constraintViolationSet){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
    }
}

class PersonT{
   String name;
   int age;
}

