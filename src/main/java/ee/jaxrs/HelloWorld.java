package ee.jaxrs;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Path("/sayHelloWorld")
@Produces(MediaType.TEXT_PLAIN)
public class HelloWorld {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String sayHello(){
        /** так делать нельзя, т.к. будет выкинут стектрей, это не красиво
         надо или использовать мапперы*/
        throw new RuntimeException("RuntimeException");
        /** или  выкидывать специальные статусы а ошибку логировать */
        throw new BadRequestException("сообщение"); /** вернет 400 ошибку и сообщение*/


    }
    @POST
    @Produces("text/plain")
    public String put() throws IOException {
        throw new IOException("IOException");
    }
}
/** Маппер ошибок на статус ответа*/
@Provider
class RunTimeExceptionMapper implements ExceptionMapper<RuntimeException>{
    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.status(404).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
}