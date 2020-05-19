import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/** Для поддержки асинхронности необходимо установить параметр asyncSupported в анотации @WebServlet */
@WebServlet(value = "/synchServlet",asyncSupported = true)
public class SynchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** создаем асинхронный контекст*/
        AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                //выполняем какуюто работу
            }
        });
        /** завершаем выполнение контекста */
        asyncContext.complete();
    }
}
