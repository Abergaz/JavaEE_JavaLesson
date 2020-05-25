package ee.servlet;

import ee.beanValidation.CheckEmail;
import ee.beanValidation.CheckSiteURL;

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
        Set<ConstraintViolation<PersonT>> constraintViolationSet = validator.validateValue(PersonT.class,"url","http://host.com:23") ;
        for(ConstraintViolation<PersonT> constraintViolation: constraintViolationSet){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
    }
}

class PersonT{
    @CheckSiteURL(port = 22)
    String url;
}

