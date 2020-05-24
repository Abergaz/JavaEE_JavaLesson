package ee.servlet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DIExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    InterceptorsService interceptorsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        interceptorsService.doJob();
        interceptorsService.doJob2();
    }
}

class InterceptorOne{
    @AroundInvoke /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("one");
        return context.proceed();
    }
}
class InterceptorTwo{
    @AroundInvoke /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("two");
        return context.proceed();
    }
}
class InterceptorFree{
    @AroundInvoke /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("free");
        return context.proceed();
    }
}
class InterceptorFour{
    @AroundInvoke /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("four");
        return context.proceed();
    }
}

@Interceptors({InterceptorOne.class, InterceptorTwo.class}) /** помечаем бин что  к нему пименяются интерсептор */
@RequestScoped
class InterceptorsService{
    @Interceptors({InterceptorFree.class, InterceptorFour.class})
    public void doJob(){
        System.out.println(" do job");
    }
    @ExcludeClassInterceptors /** значит перед этим методом не будут применяться интерсепторы */
    public void doJob2(){
        System.out.println("do job2");
    }

}
