package ee.ejb.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;



/** @Singleton и @Stateless одинаковый жизненый цикл */
@Stateful /**@Stateful к жизненному циклу добавляется еще 3 метода @PrePassivate и @PostActivate и @Remove*/
public class ExampleBean{
    public String getName(){
       return "Max ";
   }
   @PostConstruct
    void postConstruct(){
       System.out.println("PostConstruct");
   }
    @PreDestroy
    void preDestroy(){
        System.out.println("PreDestroy");
    }

    /** @Stateful к жизненному циклу добавляется еще 3 метода @PrePassivate и @PostActivate и @Remove*/

    @PrePassivate /** вызывается перед сохраенинием */
    void prePassivate(){
        System.out.println("PrePassivate");
    }
    @PostActivate  /** вызывается после востановления */
    void postActivate(){
        System.out.println("postActivate");
    }
    @Remove
    void remove(){
        System.out.println("remove");
    }

}
