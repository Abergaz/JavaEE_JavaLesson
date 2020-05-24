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
    LiveCycleBean liveCycleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        liveCycleBean.doJob();
        liveCycleBean.doJob2();
    }
}

class Interceptor{
    @AroundConstruct/** вызывается перед созданием бина, перед конструктором */
    private void aroundConstruct(InvocationContext context) throws Exception{
        System.out.println("before construct");
        context.proceed();
    }

    @PostConstruct /** анотация говорящая что надо вызвать метод сразу после создания обьекта бина */
    private  void postConstruct(InvocationContext context) throws Exception{
        System.out.println("post construct");
        context.proceed();
    }
    @AroundInvoke /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("before method");
        return context.proceed();
    }
    @PreDestroy /** вызовется перед уничтожением бина*/
    private void preDestroy(InvocationContext context) throws Exception{
        System.out.println("pre destroy");
        context.proceed();
    }
}

@Interceptors(Interceptor.class) /** помечаем бин что  к нему пименяются интерсептор */
@RequestScoped
class LiveCycleBean{
    public LiveCycleBean() {
        System.out.println("construct");
    }
    public void doJob(){
        System.out.println(" do job");
    }
    @ExcludeClassInterceptors /** значит перед этим методом не будут применяться интерсепторы */
    public void doJob2(){
        System.out.println("do job2");
    }

    @Interceptors(Interceptor.class)/** можно помечать отдельные методы  а не класс целиком*/
    public void doJob3(){
        System.out.println("do job3");
    }
}
