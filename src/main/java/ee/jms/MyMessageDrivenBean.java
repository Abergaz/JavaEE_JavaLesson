package ee.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "someQueue")
public class MyMessageDrivenBean implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Async Message received: "+ message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
