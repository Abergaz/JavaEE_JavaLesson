import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/temp")
public class TempServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** Создаем куки */
        Cookie cookie = new Cookie("name","value");
        /** сроки хранения куки -1 бесконечность по умолчанию */
        cookie.setMaxAge(5);
        /** доступ к куки можно ограничить только конкретной страницей setPath */
        cookie.setPath("/temp");
        /** ограничть доступ к куки только по SSL setSecure */
        cookie.setSecure(true);
        /** куки обязательно записываем в ответ */
        resp.addCookie(cookie);

        /** Читаем все куки */
        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            for (Cookie c:cookies){
                System.out.println(c.getName() + ": "+c.getValue());
            }
        }

    }
}
