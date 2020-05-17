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
        /** вывод всех заголовков Header'ов */
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s + " " + req.getHeader(s));
        }
        /** вывод дополнительных параметров из запроса*/
        System.out.println(req.getAuthType());
        System.out.println(req.getContentLength());
        System.out.println(req.getContentType());
        System.out.println(req.getMethod());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());
        System.out.println(req.getProtocol());

        /** Можно свои параметры писать в заголовки */
        resp.setHeader("Content-Length","100");
    }
}
