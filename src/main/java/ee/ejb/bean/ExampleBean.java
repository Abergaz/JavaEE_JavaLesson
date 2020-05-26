package ee.ejb.bean;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@Local(LocalExampleInterface.class) /** когда нет доступа к интефейсу, указываем что мы его имплементим */
@LocalBean /** для того чтобы можно было использовать non interfaace bean, без этой анатации он работать не будет.*/
public class ExampleBean implements LocalExampleInterface {
    @Override
    public String getName() {
        return "Max";
    }
    public String getSerName(){
        return "Black";
    }
}
