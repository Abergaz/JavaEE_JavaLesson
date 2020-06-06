package ee.websocets;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MyMessageDecoder implements Decoder.Text<MyMessage> {
    @Override
    public MyMessage decode(String s) throws DecodeException {
        return new MyMessage(s);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
