package resource.user;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import resource.ApplicationConfig;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountResourceTest extends JerseyTest{
    private static final String BASEURI = "itailor/";
    @Override
    protected Application configure(){
        return new ApplicationConfig();
    }

    @Test
    public void testGet() throws Exception {
        final WebTarget queryTarget = target(BASEURI+"account")
                .queryParam("email","liker.xu@foxmail.com");
        final Invocation.Builder invocationBuilder =
                queryTarget.request(MediaType.APPLICATION_JSON_TYPE);
        final Response response = invocationBuilder.get();
        System.out.println(response.toString());
        System.out.println(response.getLength());
        System.out.println(response.getHeaders().toString());
        System.out.println(response.getStatus());
    }
}