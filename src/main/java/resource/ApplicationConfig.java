package resource;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@ApplicationPath("itailor/*")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages("resource.user");
        register(JacksonJsonProvider.class);

    }
}
