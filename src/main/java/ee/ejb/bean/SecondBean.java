package ee.ejb.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SecondBean {
    @PostConstruct
    void postConstruct(){
        System.out.println("Second bean");
    }
}
