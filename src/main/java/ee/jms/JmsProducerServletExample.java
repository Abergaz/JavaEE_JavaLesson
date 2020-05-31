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
        jmsContext.createProducer().setPriority(2).send(queue, new Student("Two")); /** можно ставиить приоритеты*/
        jmsContext.createProducer().setPriority(1).setTimeToLive(1000).send(queue, new Student("One")); /** время хранения сообщения в очереди */
        jmsContext.createProducer().setPriority(3).setProperty("SomeProperty",1).send(queue, new Student("Three"));/** можно добавлять свои проперти и фильтровать по ним*/

        JMSConsumer jmsConsumer=jmsContext.createConsumer(queue,"JMSPriority>1 or SomeProperty<>!");/** фильтрация сообщений*/
        System.out.println(jmsConsumer.receiveBody(Student.class));
        System.out.println(jmsConsumer.receiveBody(Student.class));
        System.out.println(jmsConsumer.receiveBody(Student.class));

    }
}
class Student implements Serializable {
    String name;

    public Student(String name) {
        this.name = name;
    }
}
