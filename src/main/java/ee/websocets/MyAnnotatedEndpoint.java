package ee.websocets;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/myEndpoint") /** создаем сокет через аннотацию*/
public class MyAnnotatedEndpoint {
    @OnMessage
    public void onMessage(Session session,String message) throws IOException {
        session.getBasicRemote().sendText("You've send: "+ message);
    }
}
