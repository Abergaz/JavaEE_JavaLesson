package ee.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/sayHelloWorld") /** помечаем что это RESTfull-сервис и указываем точку входа*/
@Produces(MediaType.TEXT_PLAIN) /** на все методы тоже самое что и "text/plain" */
public class HelloWorld {
    @GET /** помечаем метод аннотацией @GET-получить, @PUT-создать, @POST-обновить, @DELETE, @HEAD, @OPTION */
    @Produces("text/plain") /** указываем тип возвращаемого значения - mime type */
    @Consumes("text/html")/** указываем тип принимаемого значения - mime type */
    public String sayHello(){
        return "hello world";
    }
    @POST
    @Produces("text/plain")
    public String put(){
        return "put";
    }
}
