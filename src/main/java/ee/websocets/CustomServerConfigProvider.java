package ee.websocets;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomServerConfigProvider  implements ServerApplicationConfig {
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
        Set<ServerEndpointConfig> result = new HashSet<>();
        for(Class epClass: endpointClasses){
            if (epClass.equals(WebSocketEchoService.class)){
                ServerEndpointConfig serverEndpointConfig = ServerEndpointConfig.Builder.create(epClass,"/echoMessage").build();
                result.add(serverEndpointConfig);
            }
        }
        return result;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        return Collections.emptySet();
    }
}
