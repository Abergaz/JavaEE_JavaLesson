package ee.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/jmsConsumerServletExample")
public class JmsConsumerServletExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext initialContext = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("openejb:Resource/MyJMSConnectionFactory");
            Queue queue = (Queue) initialContext.lookup("openejb:Resource/FooQueue");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession();
            MessageConsumer messageConsumer = session.createConsumer(queue);
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            System.out.println(textMessage.getText());
            resp.getWriter().write(textMessage.getText());
            connection.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
