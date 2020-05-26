package ee.ejb;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateless
//@Stateful
//@Singleton
public class HelloWorldEjb {
    public String sayHello(){
        return "Hello world";
    }
}
