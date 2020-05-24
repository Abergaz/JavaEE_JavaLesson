package ee.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Set;

@WebServlet("/temp")
public class Temp extends HttpServlet {
    @Inject
    Person person;
//    @Inject
//    Validation validation;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { resp.getWriter().write("person name = " +person.name);
        person.name="Max";
        person.age=15;
        ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        /** проверяем все условия*/
        Set<ConstraintViolation<Person>> validate =validator.validate(person);
        if (validate.size()>0){
            System.out.println("some error ocured");
        }
        for (ConstraintViolation<Person> violation :validate){
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        /** проверяем услоия для свойства name*/
        Set<ConstraintViolation<Person>> name =validator.validateProperty(person,"name");
        if (name.size()>0){
            System.out.println("name is wrong");
        }
        /** проверяем значение anton на правильность для свойства name класс Person*/
        Set<ConstraintViolation<Person>> constraintViolations = validator.validateValue(Person.class, "name","anton");
        if (name.size()>0){
            System.out.println("anton is wrong");
        }
        /** Можно также проверять параметы методов помеченные валидаторами*/

    }
}
class Person{
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]")
    String name;
    @Min(18)
    int age;
}
