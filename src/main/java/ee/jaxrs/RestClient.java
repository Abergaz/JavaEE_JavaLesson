package ee.jaxrs;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;

public class RestClient {
    public static void main(String[] args) {
        Client client =ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/rs/sayHelloWorld");
        Invocation invocation = webTarget.request().buildGet();
        //Invocation invocation = webTarget.request().buildPost(Entity.text("ha ha ha "));
        Response response = invocation.invoke();
        if (response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()){
            System.out.println(response.readEntity(String.class));
        }

        /** тоже самое что выше но в 1 строчтку*/
        System.out.println(client.target("http://localhost:8080/rs/sayHelloWorld").request().get(String.class));

    }
}
