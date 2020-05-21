package ee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.SocketHandler;


public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**  Можно проверить в какую группу role-name
         *  из <security-role-ref> в web.xml для данного
         *  сервлета входит пользователь
         * */
        if (req.isUserInRole("Administrators")){
            resp.getWriter().write("User logger in as admin");
            /** выводим логин name пользователя */
            System.out.println(req.getRemoteUser());
            Principal userPrincipal = req.getUserPrincipal();
            System.out.println(userPrincipal.getName());
        }
    }
}
