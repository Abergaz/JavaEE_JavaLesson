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
import javax.validation.groups.Default;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;


@WebServlet("/temp")
public class Temp extends HttpServlet {
   @Inject
    Validator validator;
   @Inject PersonT personT;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<PersonT>> constraintViolationSet = validator.validate(personT,MyGroup1.class) ;/** завалидируются только параметры помеченыне MyGroup1*/
        for(ConstraintViolation<PersonT> constraintViolation: constraintViolationSet){
            System.out.println(constraintViolation.getMessage());
            System.out.println(constraintViolation.getInvalidValue());
        }
    }
}
interface MyGroup1{}
interface MyGroup2{}
interface MyGroup3{}
interface MyGroup4{}

class PersonT{
    @NotNull(groups = MyGroup1.class)
    String s;
    @NotNull(groups = {MyGroup1.class,MyGroup2.class})
    String s2;
    @NotNull(groups = MyGroup3.class)
    String s3;
    @NotNull(groups = Default.class)/** дефалтовая группа */
    String s4;
}

