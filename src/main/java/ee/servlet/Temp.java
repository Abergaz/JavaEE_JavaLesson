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
import java.time.LocalDate;
import java.util.Set;


@WebServlet("/temp")
public class Temp extends HttpServlet {
    @Inject
    Person person;

    @Inject
    Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.setBithDate(LocalDate.of(2020,01,01));
        person.setDeathDate(LocalDate.of(2120,01,01));
        Set<ConstraintViolation<Person>> constraintViolationSet = validator.validate(person) ;
        for(ConstraintViolation<Person> constraintViolation: constraintViolationSet){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
    }
}
