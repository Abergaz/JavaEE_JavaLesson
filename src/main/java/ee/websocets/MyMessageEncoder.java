package ee.websocets;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MyMessageEncoder implements Encoder.Text<MyMessage>{
    @Override
    public String encode(MyMessage object) throws EncodeException {
        return object.getMsg();
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
