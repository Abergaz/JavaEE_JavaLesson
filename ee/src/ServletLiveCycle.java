import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LiveCycle")
public class ServletLiveCycle extends HttpServlet {
    /**
     * Выполняется один раз при запуске сервлета
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("Initialization");
        super.init();
    }

    /**
     * Выполняет все обработку запросов и ответов
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }

    /** в зависимости от типа запроса неоходимо переопределить
     * нужный метод, можно сдедать один метод, который будет обрабатывать
     * все типы запросов и вызывать его в переопреденных методах.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
       String s ="<html>"+
               "<header><title>This is Title</title></header>"+
               "<body>"+
               "Hello world"+
               "</body>"+
               "</html>";
       resp.getWriter().write(s);
    }

    /**Вызывается перед остановкой сервлета, не стоит на него пологаться */
    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }
}
