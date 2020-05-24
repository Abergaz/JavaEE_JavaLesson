package ee.servlet;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;

public class DependencyInjectionExample  {
    private static ContainerLifecycle lifecycle = null;
    public static void main(String[] args) {
        lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);

        BeanManager beanManager = lifecycle.getBeanManager();
        Bean<?> bean = beanManager.getBeans("mainContainer").iterator().next();

        MainContainer mainContainer = (MainContainer) lifecycle.getBeanManager().getReference(bean,MainContainer.class,beanManager.createCreationalContext(bean));
        mainContainer.runBean();

        lifecycle.stopApplication(null);
    }
}
@Named
class MainContainer{
    @Inject
    MyBean myBean;
    public void runBean(){
        myBean.print();
    }
}
class MyBean{
    public void print(){
        System.out.println("Hello world");
    }
}