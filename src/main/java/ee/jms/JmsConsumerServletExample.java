package ee.jms;

import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jmsConsumerServletExample")
public class JmsConsumerServletExample extends HttpServlet {
    @Resource(lookup ="openejb:Resource/MyJMSConnectionFactory")
    ConnectionFactory connectionFactory;
    @Resource(lookup ="openejb:Resource/FooQueue")
    Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession();
            MessageConsumer messageConsumer = session.createConsumer(queue);
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            System.out.println(textMessage.getText());
            resp.getWriter().write(textMessage.getText());
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
