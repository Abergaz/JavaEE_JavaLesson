import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;


@WebServlet("/temp")
public class TempServlet extends HttpServlet {
    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** Если браузер поддерживает сжатие Accept-Encoding=gzip то ответ можно отдавать сжатый а он все разожмет и отобразит нормально    */
        if(req.getHeader("Accept-Encoding").contains("gzip")){
            PrintWriter printWriter = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            printWriter.write("hello world");
        }
    }
}
