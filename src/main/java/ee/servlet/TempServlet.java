package ee.servlet;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@WebServlet("/tempServlet")
public class TempServlet extends HttpServlet {
    /** получаем доступ к различным управляемым котейнером пулам потоков*/
    @Resource
    ManagedExecutorService managedExecutorService;
    @Resource
    ManagedScheduledExecutorService managedScheduledExecutorService;
    @Resource
    ManagedThreadFactory managedThreadFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        managedExecutorService.submit(new MyRunnuble());
        try {
            System.out.println(managedExecutorService.submit(new MyCallble<>()).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyRunnuble implements Runnable{
        @Override
        public void run() {
            System.out.println("1");
        }
    }
    static class MyCallble<T> implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
