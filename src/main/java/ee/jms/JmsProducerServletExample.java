package ee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
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
            MessageProducer messageProducer = session.createProducer(queue);
            Message message = session.createTextMessage("message was sent at: " + new Date());
            messageProducer.send(message);
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
