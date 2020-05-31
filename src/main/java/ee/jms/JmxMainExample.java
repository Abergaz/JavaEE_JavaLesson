package ee.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import javax.jms.*;
import java.util.Date;

public class JmxMainExample {
    public static void main(String[] args) throws Exception {
        /** создаем message provider*/
        BrokerService brokerService = BrokerFactory.createBroker("broker:(tcp://localhost:61616");
        /** стартуем message provider */
        brokerService.start();
        /** создаем подклбчение к нашему провайдеру */
        Connection connection = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            /** создаем очереди в провайдере*/
            Queue queue = session.createQueue("customerQueue"); /** обычная очередь все сообщения для всех consumer*/
            Topic topic = session.createTopic("customerTopic"); /** индеведуальные сообщения каждому consumer*/
            /** cоздаем producer и указываем ему очередь куда класть сообщение*/
            MessageProducer messageProducer = session.createProducer(queue);
            /** создаем сообщение */
            Message message = session.createTextMessage("message was sent at" + new Date());
            /** отправляем сообщенние от producer в provider в указаную выше очередь*/
            messageProducer.send(message);

            /** создаем consumer для конкретной очереди*/
            MessageConsumer messageConsumer = session.createConsumer(queue);
            /** стартуем соеденнени*/
            connection.start();
            /** получаем текстовое сообщение */
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            System.out.println(textMessage.getText());
            Thread.sleep(1000);/** чтобы успеть прочитать сообщение перед закрытием сессии*/
            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
            brokerService.stop();
        }

    }
}
