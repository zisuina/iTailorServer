package resource.service;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AirLogFilterTest extends JerseyTest{
    private static final String BASEURI = "/accountS";
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

}