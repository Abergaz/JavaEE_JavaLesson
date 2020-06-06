package ee.jaxrs;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces("my/format") /** @Produces указывается для записаи нашего собственного форамта*/
public class CustomStudentWriter implements MessageBodyWriter<Student> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Student.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Student student, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return student.getName().length()+1+student.getAge().length();
    }

    @Override
    public void writeTo(Student student, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        entityStream.write(student.getName().getBytes());
        entityStream.write('/');
        entityStream.write(student.getAge().length());

    }
}
