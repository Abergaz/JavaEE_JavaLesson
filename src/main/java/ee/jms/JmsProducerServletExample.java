package ee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@WebServlet("/jmsProducerServletExample")
public class JmsProducerServletExample extends HttpServlet {
    @Inject
    @JMSConnectionFactory("MyJMSConnectionFactory")/** можно указть если нужна специальная фабрика из настроек */
            JMSContext jmsContext;
    @Resource(name = "someQueue")
    Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jmsContext.createProducer().send(queue, "Message was sent at: " + new Date());
    }
}
