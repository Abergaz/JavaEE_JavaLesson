package ee.ejb.bean;

import javax.ejb.Stateless;

@Stateless
public class ExampleBean{
    public String getName(){
       return "Max ";
   }
}
