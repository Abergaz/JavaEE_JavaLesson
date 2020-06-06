package ee.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Path("/sayHelloWorld")
@Produces(MediaType.TEXT_PLAIN)
public class HelloWorld {
    @Context
    UriInfo uriInfo; /** можно инжекстить информация о URL*/


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String sayHello(@Context HttpHeaders httpHeaders, /** можно инжектить заголовки */
                           @Context Request request, /** инжектим запрос*/
                           @Context Providers providers, /** для преобразования форматов*/
                           @Context SecurityContext securityContext
                           ){
        return uriInfo.getAbsolutePath().toString();
    }
    @POST
    @Produces("text/plain")
    public String put(){
        return "put";
    }
}
