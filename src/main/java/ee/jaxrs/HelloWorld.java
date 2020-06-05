package ee.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/sayHelloWorld") /** помечаем что это RESTfull-сервис и указываем точку входа*/
public class HelloWorld {
    @GET /** помечаем метод аннотацией @GET-получить, @PUT-создать, @POST-обновить, @DELETE, @HEAD, @OPTION */
    @Produces("text/plain") /** указываем тип возвращаемого значения - mime type */
    @Consumes("text/html")/** указываем тип принимаемого значения - mime type */
    public String sayHello(){
        return "hello world";
    }
}
