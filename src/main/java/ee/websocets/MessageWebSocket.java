package ee.websocets;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

@ServerEndpoint(value = "/messageWebSocket/{param}", encoders = MyMessageEncoder.class, decoders = MyMessageDecoder.class)
public class MessageWebSocket {

    @OnOpen
    public void OnOpen(Session session){
        System.out.println("Connection open on server");
    }

//    @OnMessage
//    public void OnMessage(Session session, MyMessage message, @PathParam("param") String param) throws IOException, EncodeException {
//        session.getBasicRemote().sendObject(message);
//    }

    @OnMessage
    public void OnMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText("you have send: "+message);
    }

    @OnMessage
    public void OnMessageBinary(Session session, ByteBuffer byteBuffer) throws IOException {
        session.getBasicRemote().sendBinary(byteBuffer);
    }

    @OnMessage
    public void OnMessagePing(Session session, PongMessage pongMessage) throws IOException {
    }

    @OnError
    public void OnError(Session session, Throwable throwable){
        throwable.printStackTrace();
    }

    @OnClose
    public void OnError(){
        System.out.println("Server connection is closed");
    }
}

