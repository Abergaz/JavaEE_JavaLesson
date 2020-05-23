package ee.servlet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
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
class LiveCycleBean{
    public LiveCycleBean() {
        System.out.println("construct");
    }
    @PostConstruct /** анотация говорящая что надо вызвать метод сразу после создания обьекта бина */
    private  void postConstruct(){
        System.out.println("post construct");
    }
    @AroundInvoke /** вызовктся перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("before method");
        return context.proceed();
    }
    @PreDestroy /** вызовется перед уничтожением бина*/
    private void preDestroy(){
        System.out.println("pre destroy");
    }


    public void doJob(){
        System.out.println(" do job");
    }
    public void doJob2(){
        System.out.println("do job2");
    }
}
