package resource.service;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import resource.ApplicationConfig;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by liker on 06/08/2015 0006.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ImageServiceTest extends JerseyTest {

    private static final String BASEURI = "/";

    @Override
    protected Application configure() {
        return new ApplicationConfig();
    }

    @Test
    public void testFile() throws IOException {
        final URL resource = getClass().getClassLoader().getResource("gua.txt");
        System.out.println(resource.toString());
        final String file = resource.getFile();
        final File f = new File(file);
        final Invocation.Builder request = target(BASEURI).path("imagesServer").request();
        Entity<File> e = Entity.entity(f, MediaType.TEXT_PLAIN_TYPE);
        final Response response = request.post(e, Response.class);

        String result = response.readEntity(String.class);
        System.out.println(result);
    }

    @Test
    public void testGetImage() throws Exception {

    }

    @Test
    public void testPostImage() throws Exception {
        final File f = new File("C:\\Users\\liker\\Videos\\Pictures\\b1.jpg");
        final Invocation.Builder request = target(BASEURI).path("imageServer")
                .queryParam("accountID", "1")
                .queryParam("imageName", "test")
                .request();
        Entity<File> e = Entity.entity(f, MediaType.APPLICATION_OCTET_STREAM);
        final Response response = request.post(e, Response.class);
        String result = response.readEntity(String.class);
        System.out.println(response.getStatus());
    }
}