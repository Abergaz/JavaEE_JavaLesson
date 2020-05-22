package ee.servlet;

import javax.ejb.EJB;
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
    /** можно инжектить интерфейс, если реализация 1 то возьмется именнно она
     * если реализаций много надо использоваться создать аннотация с  @Quantifier
     *  и пометить ей соответствующий класс  и переменную с интервейсом куда инжектить*/
    @Inject
    @StudentAnnotation
    Person person;

    @Inject
    @WorkerAnnotation
    Person person2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(person.getName());
        System.out.println(person2.getName());
    }
}
/** Создаем аннотацию с @Qualifier, для того чтобы пометить ей класс
 * чтобы контейнер при встрече этой анатации знал обьект какого класса в положить в переменную*/
@Qualifier
@Retention(RetentionPolicy.RUNTIME) /** используется в режиме выполненения*/
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD })/** указываем что можно пометить*/
@interface  StudentAnnotation{}

@Qualifier
@Retention(RetentionPolicy.RUNTIME) /** используется в режиме выполненения*/
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD })/** указываем что можно пометить*/
@interface  WorkerAnnotation{}


interface Person {
    String getName();
}

@StudentAnnotation
class Student implements Person{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return "student";
    }

    public void setName(String name) {
        this.name = name;
    }
}
@WorkerAnnotation
class Worker implements Person{
    @Override
    public String getName() {
        return "worker";
    }
}