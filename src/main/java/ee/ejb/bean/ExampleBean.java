package ee.ejb.bean;


import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup /** анатация для сингелтонов, чтобы заскадся сразу при старте контейнера*/
@DependsOn ("SecondBean") /** так сначала запуститься SecondBean потом текущий ExampleBean*/
public class ExampleBean{
    @PostConstruct
    void postConstruct(){
        System.out.println("Example bean");
    }
}
