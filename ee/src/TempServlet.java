import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/temp")
public class TempServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /** Сессия хранится на сервере и получаем только из запроса */
        HttpSession httpSession = req.getSession();
       /** Пишем атрибут в сессию */
       httpSession.setAttribute("nameAttribute","valueAttribute");
       /** Получаем все атрибуты из сессии */
        Enumeration<String> attributes = httpSession.getAttributeNames();
        while (attributes.hasMoreElements()){
            String name = attributes.nextElement();
            System.out.println(name +": "+httpSession.getAttribute(name));
        }
        /** Время жизни сессии задается на сервере по умолчанию или в коде */
        System.out.println(httpSession.getMaxInactiveInterval());

    }
}
