package ee.jaxrs;

import javax.ws.rs.*;

@Path("/extract")
@Produces("text/plain")
public class ExtractingParamsLesson {
    /** означает что после /extract/ ижет параметр например: http://localhost:8080/rs/extract/123 */
    @GET
    @Path("/{id}") /** в {} указываем имя параметра, который участваут в разметке параметров @PathParam */
    public String returnId(@PathParam("id") String id){
        return id;
    }

    /** тоже самое что и выше но вызывается по другому пути /extract/id/+параметры например: http://localhost:8080/rs/extract/id/param */
    @GET
    @Path("/id/{id}")
    public String returnById(@PathParam("id") String id){
        return "id="+id;
    }

    /** ограничиваем параметр регулярынм выражением например: http://localhost:8080/rs/extract/userName/Serg */
    @GET
    @Path("userName/{name: [a-zA-Z]*}")
    public String getName(@PathParam("name") String name){
        return "name is "+name;
    }

    /** это параметр передается по имени после ? например  http://localhost:8080/rs/extract/age/?userAge=35 */
    @GET
    @Path("/age/")
    public String getAge(@QueryParam("userAge") int userAge){
        return "user age "+ userAge;
    }

    /** это параметр передается по имени после ; если нечего не передать то используеться деволтное значение например http://localhost:8080/rs/extract/city/;userCity=Kiev */
    @GET
    @Path("/city/")
    public String getCity(@DefaultValue("Moscow") @MatrixParam("userCity") String city){
        return "City is "+ city;
    }

    /** @CookieParam  - параметр который берется из cookies, если его нет то дефолтное значение */
    @GET
    @Path("/sessionId/")
    public String extractSessionID(@DefaultValue("null") @CookieParam("sessionID") String sessionID){
        return sessionID;
    }

    /** @HeaderParam параметры которые достаются из header'а */
    @GET
    @Path("/userAgent")
    public String extractUserAgent(@HeaderParam("User-Agent") String userAgent){
        return userAgent;
    }

    /**@FormParam - параметры которые достаются из html форм */
    @POST
    @Path("/form")
    public String extractForm(@FormParam("test") String test){
        return "test value is: "+test;
    }


}
