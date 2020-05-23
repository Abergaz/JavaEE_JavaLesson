package ee.servlet;

import javax.enterprise.context.*;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/DIExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    MyBean bean;
    @Inject
    ChangeMyBean changeMyBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bean.i=5;
        changeMyBean.changeI();
        resp.getWriter().write(bean.i+"");
    }
}
/**
@ApplicationScoped - на все приложение
@SessionScoped - хранится в сессии
@RequestScoped - только в запросе
@Dependent - по умолчанию
@ConversationScoped
*/
@RequestScoped
class MyBean{
    int i;
}

/** отличия RequestScoped от Dependent в том, что RequestScoped один на весь запрос
 * даже если он заинжектен в разных местах. (аля сингелтон)
 * А Dependent - он везде где инжектится создается свой экзепляр (аля прототайп)
 */
@Dependent
class ChangeMyBean{
    @Inject
    MyBean myBean;
    public void changeI(){
        myBean.i=2;
    }

}

