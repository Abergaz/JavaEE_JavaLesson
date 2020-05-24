package ee.servlet;

import ee.beanValidation.CheckEmail;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<Person>> constraintViolationSet1 = validator.validateValue(Person.class,"email","mymail@gmail.com") ;
        for(ConstraintViolation<Person> constraintViolation: constraintViolationSet1){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }

        Set<ConstraintViolation<Person>> constraintViolationSet2 = validator.validateValue(Person.class,"email","mymail@gmail.ru") ;
        for(ConstraintViolation<Person> constraintViolation: constraintViolationSet2){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }


    }
}

class Person {
    @CheckEmail
    String email;
}
