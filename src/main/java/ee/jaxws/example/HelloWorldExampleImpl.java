package ee.jaxws.example;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
/** пометили класс как web-сервис */
@WebService (endpointInterface = "ee.jaxws.example.HelloWorldExample",serviceName = "sayHelloService") /** говорим какок интефейс имлементим */
public class HelloWorldExampleImpl implements HelloWorldExample{
    public String seyHello(){
        return "Hello world";
    }
}

