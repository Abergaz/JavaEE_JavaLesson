package ee.jms;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jmsConsumerServletExample")
public class JmsConsumerServletExample extends HttpServlet {
    @Resource
    ConnectionFactory connectionFactory;
    @Resource(name = "someQueue")
    Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(JMSContext jmsContext = connectionFactory.createContext()) {
            String textMessage = jmsContext.createConsumer(queue).receiveBody(String.class);
            System.out.println(textMessage);
        }
    }
}
