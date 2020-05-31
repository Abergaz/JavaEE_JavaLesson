package ee.jms;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/jmsProducerServletExample")
public class JmsProducerServletExample extends HttpServlet {
    @Resource
    ConnectionFactory connectionFactory;
    @Resource(name = "someQueue")
    Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(JMSContext jmsContext =connectionFactory.createContext()){
            jmsContext.createProducer().send(queue,"message was send at: "+new Date());
        }
    }
}
