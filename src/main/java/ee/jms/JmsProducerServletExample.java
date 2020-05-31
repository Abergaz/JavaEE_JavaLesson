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

@WebServlet("/jmsProducerServletExample")
public class JmsProducerServletExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext initialContext = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("openejb:Resource/MyJMSConnectionFactory");
            Queue queue = (Queue) initialContext.lookup("openejb:Resource/FooQueue");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession();
            MessageProducer messageProducer = session.createProducer(queue);
            Message message = session.createTextMessage("message was sent at: " + new Date());
            connection.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
