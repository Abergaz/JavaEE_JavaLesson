package ee.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rs") /** указавает корневую точку входа для всех RESTfull сервисов приложения */
public class ApplicationPathLesson  extends Application {
    /** просто абстрактный класс чтобы указать точку входа*/
}
