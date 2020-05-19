import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/temp")
public class TempServlet extends HttpServlet {
    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** возвращаем HTTP статутус  */
        // resp.setStatus(HttpServletResponse.SC_OK);
        /** Перенаправление на другую страничку*/
        // resp.sendRedirect("/hello");
         /** Возврат ошибки */
        //resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Текст ошибки");
        /** можно задать частоту обновления страницы*/
        //resp.setHeader("Refresh","1");
        //System.out.println("hello");
        /** Можно создать задержку и перенаправить на другую страницу*/
        resp.setHeader("Refresh","5; URL=https://google.com");


    }
}
