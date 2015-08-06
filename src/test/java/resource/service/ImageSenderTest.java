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
public class ImageSenderTest extends JerseyTest {

    private static final String BASEURI = "/";

    @Override
    protected Application configure() {
        return new ApplicationConfig();
//        return new ResourceConfig(Example.class);
    }

    @Test
    public void testFile() throws IOException {

//        final WebTarget queryTarget = target(BASEURI + "example");
//        System.out.println(queryTarget.toString());
////                .queryParam("imageId","123.jpg");
//        final Invocation.Builder invocationBuilder
//                = queryTarget.request(MediaType.TEXT_PLAIN);
//        final Response response = invocationBuilder.get();
//        System.out.println(response.getStatus());
//        System.out.println(response.getLength());
//        String res = response.readEntity(String.class);
//        System.out.println(res);


        final URL resource = getClass().getClassLoader().getResource("gua.txt");
        System.out.println(resource.toString());
        final String file = resource.getFile();
        final File f = new File(file);
        final Invocation.Builder request = target(BASEURI).path("imagesServer").request();
        Entity<File> e = Entity.entity(f, MediaType.TEXT_PLAIN_TYPE);
        final Response response = request.post(e, Response.class);

        String result = response.readEntity(String.class);
        System.out.println(result);
//        File res = response.readEntity(File.class);
//        try (BufferedReader br = new BufferedReader(new FileReader(res))) {
//            String s;
//            do {
//                s = br.readLine();
//                System.out.println(s);
//                System.out.println("HEllO....");
//            } while (s != null);
//        }
    }

}