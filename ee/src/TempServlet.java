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
        /** Получение параметров из адресной строки по имени*/
        String one = req.getParameter("one");
        String two = req.getParameter("two");
        System.out.println(one);
        /**  Если передали несколько параметров с одним именем */
        String[] ones = req.getParameterValues("one");
        for (String x : ones) {
            System.out.println(x);
        }
        /** Список имен параметров */
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + "=" + Arrays.asList(req.getParameterValues(paramName)).toString());
        }
        /** получение карты имя параметра - значение */
        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=");
            for (String x : entry.getValue()) {
                System.out.print(x + "; ");
            }
            System.out.println();
        }
        /** куча параметров сервлета */
        System.out.println(req.getRequestURL());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestedSessionId());
        System.out.println(req.getServletPath());
        System.out.println(req.getServerName());
        System.out.println(req.getServerPort());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getRemotePort());
        System.out.println(req.getRemoteUser());

        /** получение строки запроса */
        System.out.println(req.getQueryString());


        /**  Используем для отправки формы метод  get*/
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "<form action='temp' method=get>"+
                "<input type='text' name='one'/>"+
                "<input type='text' name='two'/>"+
                "<input type='submit' name='submit'/>"+
                "</form>"+
                "</body>"+
                "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**  Используем для отправки формы метод  POST */
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "<form action='temp' method=post>"+
                "<input type='text' name='one'/>"+
                "<input type='text' name='two'/>"+
                "<input type='submit' name='submit'/>"+
                "</form>"+
                "</body>"+
                "</html>"
        );
        /** параметры для пост запросов получаются также как и для get */
        /** Список имен параметров */
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + "=" + Arrays.asList(req.getParameterValues(paramName)).toString());
        }
    }
}
