package resource.service;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.*;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("imagesServer")
public class ImageSender {
    @GET
    @Produces("image/*")
    public Response getImage(@QueryParam("imageId") final String imageName,
                             @Context ServletContext application) {
        //权限控制，能否访问
        String realPath = application.getRealPath("/images");
        System.out.println("Path:" + realPath + "\\" + imageName);
        File file = new File(realPath, imageName);
        if (!file.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(file);
        return Response.ok(file, mt).header("ContentType", "image/*").build();
    }

    @POST
    @Consumes("image/*")
    public boolean postImage(final File f) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(f))){
            String s;
            do{
                s = bufferedReader.readLine();
                System.out.println(s);
            }while(s!=null);
            return true;
//            return f;
        }
    }

}
