package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("example")
public class Example {
//    http://localhost:8080/itailor/example
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it![By the way,it's come from JRebel!!!]";
    }
}
