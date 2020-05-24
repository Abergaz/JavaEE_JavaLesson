package ee.servlet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.*;
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
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    InterceptorsService interceptorsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        interceptorsService.doJob();
        interceptorsService.doJob2();
    }
}

@InterceptorBinding
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface One {
}

@Interceptor
@One
class InterceptorOne {
    @AroundInvoke
    /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("one");
        return context.proceed();
    }
}

@InterceptorBinding
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Two {
}


@Two
@Interceptor
class InterceptorTwo {
    @AroundInvoke
    /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("two");
        return context.proceed();
    }
}

@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Free {
}


@Free
@Interceptor
class InterceptorFree {
    @AroundInvoke
    /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("free");
        return context.proceed();
    }
}

@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Four {
}


@Four
@Interceptor
class InterceptorFour {
    @AroundInvoke
    /** вызовается перед каждым методом*/
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("four");
        return context.proceed();
    }
}

@One
@Two
@RequestScoped
class InterceptorsService {
    @Free
    @Four
    public void doJob() {
        System.out.println(" do job");
    }

    public void doJob2() {
        System.out.println("do job2");
    }

}
