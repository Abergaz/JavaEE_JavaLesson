package ee.jta;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class ExampleBean {
    @EJB
    ExamplePersistBean examplePersistBean;
    public void saveStudent(){
        examplePersistBean.saveStudent();
    }
}
