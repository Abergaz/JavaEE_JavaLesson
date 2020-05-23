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
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/DIExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    ConversationBean conversationBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(conversationBean.i);
        conversationBean.i=1;
        conversationBean.startConversation();
        System.out.println(conversationBean.i);
        System.out.println("middle Conversation");
        conversationBean.i=3;
        conversationBean.endConversation();
    }
}
/** @ConversationScoped - можно самому определить сколько будет жить бин
 обязательно должен быть сериалайзбл */
@ConversationScoped
class ConversationBean implements Serializable{
    int i;
    @Inject
    Conversation conversation;
    public void startConversation(){
        System.out.println(i);
        System.out.println("start Conversation");
        conversation.begin();
        i=2;
    }
    public void endConversation(){
        System.out.println("end Conversation");
        conversation.end();
    }
}


