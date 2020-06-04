package ee.jaxws.example;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class CallHelloWorld {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/sayHelloWorld");

        QName qName= new QName("http://example.jaxws.ee/","HelloWorldExampleImplService");

        Service service = Service.create(url,qName);

        HelloWorldExample helloWorldExample = service.getPort(HelloWorldExample.class);
        System.out.println(helloWorldExample.seyHello());
    }
}
