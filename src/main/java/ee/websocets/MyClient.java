package ee.websocets;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint /** создаем клиент websocket*/
public class MyClient {
    @OnMessage /** получаем сообщение от websocket*/
    public void onMessage(Session session, String message){
        System.out.println("client get message: " + message);
    }

    public static void main(String[] args) throws IOException, DeploymentException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(MyClient.class, URI.create("ws://localhost:8080/myEndpoint"));
        session.getBasicRemote().sendText("hello world websocket (endpoint)"); /** отправляем сообщение на websocket*/
    }
}
