package ee.ejb.bean;

import javax.ejb.Singleton;

@Singleton
public class ExampleBean {
    public String getName() {
        return "Max ";
    }
}
