package ee.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/entityProvider")
public class EntityProviderLesson {

    @GET
    @Produces("my/format")
    public Student getCustomStudent(){
        return new Student("Max","22");
    }

    @POST
    @Consumes("my/format") /** принимаем наш собственый формат*/
    @Path("/getName/") /** вызываем по этому пути*/
    @Produces(MediaType.TEXT_PLAIN) /** возвращаем текст */
    public String getCustomStudent(Student student){
        return student.getName();
    }
}
