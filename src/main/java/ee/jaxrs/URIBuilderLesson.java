package ee.jaxrs;

import javax.ws.rs.core.UriBuilder;

public class URIBuilderLesson {
    public static void main(String[] args) {
        System.out.println(
                UriBuilder.fromUri("http://localhost:8080/")
                .path("somePath")
                .path("somePath")
                .matrixParam("paramName","value")
                .queryParam("paramName","value")
                .toTemplate()
        );
    }
}

