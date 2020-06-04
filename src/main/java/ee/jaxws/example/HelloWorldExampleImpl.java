package ee.jaxws.example;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;

/** пометили класс как web-сервис */
@WebService (endpointInterface = "ee.jaxws.example.HelloWorldExample",serviceName = "sayHelloService") /** говорим какок интефейс имлементим */
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public class HelloWorldExampleImpl implements HelloWorldExample{
    @Resource
    WebServiceContext webServiceContext; /** есть полезные методы и свойства */
    @WebMethod(exclude = true) /** исключает метод из сервиса*/
    /** @WebMethod(operationName = "newName")  меняем имя*/
    /** @WebResult(name = "resName") имя возвращаемоего параметра если возвращаестя*/
    public String seyHello(){
        return "Hello world";

    }
}

