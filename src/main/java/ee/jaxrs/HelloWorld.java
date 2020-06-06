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
        return "Hello world";
    }
    @POST
    @Produces("text/plain")
    public String put() throws IOException {
        throw new IOException("IOException");
    }
}
