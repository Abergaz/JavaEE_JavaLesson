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
        jmsContext.createProducer().send(queue, "message was send at: " + new Date());

        /** создаем асинхронного слушателя событий*/
        jmsContext.createConsumer(queue).setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    System.out.println(message.getBody(String.class));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
