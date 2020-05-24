package ee.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/temp")
public class Temp extends HttpServlet {
    @Inject
    Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("person name = " +person.name);
    }
}
class Person{
    @NotNull
    @Pattern(regexp = "[A-Z][a-z]")
    String name;
    @Min(18)
    int age;
    @Size(min = 10, max = 200)
    String description;
    @Past /** гооворит что дада должна быть из прошлого < текущей,
     @Future - наоборот*/
    Date birthDate;

    /** эти анатации могут быть или над свойствами или над геттерами
     * или над параметрами над методами*/
}
