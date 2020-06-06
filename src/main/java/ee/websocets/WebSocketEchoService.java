package ee.websocets;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

/** создаем websocet чере наследование Endpoint */
public class WebSocketEchoService extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler(new MessageHandler.Whole<String>(){
            @Override
            public void onMessage(String message) {
                System.out.println(message);
                try {
                    session.getBasicRemote().sendText("You've send: "+ message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
