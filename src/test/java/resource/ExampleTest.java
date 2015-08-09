package resource;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import resource.service.AirLogFilter;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ExampleTest extends JerseyTest{

    private static final String BASEURI = "/example";
    WebTarget queryTarget = null;
    @Override
    protected Application configure(){
        ResourceConfig config = new ResourceConfig(resource.Example.class);
        return config.register(resource.service.AirLogFilter.class);
    }

    @Override
    protected void configureClient(ClientConfig config){
        config.register(new AirLogFilter());
    }

    @Test
    public void testGetIt() throws Exception {
        queryTarget = target(BASEURI);
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN);
        final Response response = invocationBuilder.get();
        assertEquals(200, response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}