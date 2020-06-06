package ee.websocets;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;

@ClientEndpoint /** создаем клиент websocket*/
public class MyClient {
    @OnOpen
    public void OnOpen(Session session){
        System.out.println("Connection open on client");
    }

    @OnMessage
    public void OnMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText("you have send to client: "+message);
    }

    @OnMessage
    public void OnMessageBinary(Session session, ByteBuffer byteBuffer) throws IOException {
        session.getBasicRemote().sendBinary(byteBuffer);
    }


    @OnError
    public void OnError(Session session, Throwable throwable){
        throwable.printStackTrace();
    }

    @OnClose
    public void OnError(){
        System.out.println("Server connection is closed");
    }

    public static void main(String[] args) throws IOException, DeploymentException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(MyClient.class, URI.create("ws://localhost:8080/myEndpoint"));
        session.getBasicRemote().sendText("hello world websocket (endpoint)"); /** отправляем сообщение на websocket*/
        session.getBasicRemote().sendBinary(ByteBuffer.wrap("hello".getBytes()));
        session.getBasicRemote().sendPing(ByteBuffer.wrap("hello".getBytes()));
    }
}
