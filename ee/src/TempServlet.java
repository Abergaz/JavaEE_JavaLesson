import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/temp")
public class TempServlet extends HttpServlet {
    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = req.getParameter("one");
        /** Для того чтобы злоумышленик не мог вставить javascript или тругой код
         * необходимо экранировать разные символы на HTML символы &
         * просто replace или использовать специальные библиотеки*/
        one = one == null ? "" : one.replaceAll("<", "&lt;").replaceAll(">","&gt;");
        /**  Используем для отправки формы метод  get*/
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "one=" + one +
                "<form action='temp' method=post>"+
                "<textarea name='one'/></textarea>"+
                "<input type='submit' name='submit'/>"+
                "</form>"+
                "</body>"+
                "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
