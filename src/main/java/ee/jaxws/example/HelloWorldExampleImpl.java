package ee.jaxws.example;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
/** пометили класс как web-сервис */
@WebService (endpointInterface = "ee.jaxws.example.HelloWorldExample") /** говорим какок интефейс имлементим */
public class HelloWorldExampleImpl implements HelloWorldExample{
    public String seyHello(){
        return "Hello world";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/sayHelloWorld", new HelloWorldExampleImpl());
    }
}

