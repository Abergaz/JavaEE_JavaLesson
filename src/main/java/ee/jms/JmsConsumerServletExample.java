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

@JMSConnectionFactoryDefinition(name = "MyNewFactory")
@JMSDestinationDefinition(interfaceName = "javax.jms.Queue", name = "MyNewQueue")
@WebServlet("/jmsConsumerServletExample")
public class JmsConsumerServletExample extends HttpServlet {
    @Resource(name = "MyNewQueue")
    Queue queue;
    @Inject
    @JMSConnectionFactory("MyNewFactory")
    JMSContext jmsContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textMessage = jmsContext.createConsumer(queue).receiveBody(String.class);
        System.out.println(textMessage);
    }
}
