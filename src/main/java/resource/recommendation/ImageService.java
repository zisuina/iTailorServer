package resource.recommendation;

import util.file.SaveImage;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("imageServer")
public class ImageService {
    @GET
    @Produces("image/*")
    public Response getImage(@QueryParam("imageId") final String imageName,
                             @Context ServletContext application) {
        String realPath = application.getRealPath("/images");
        File file = new File(realPath, imageName);
        if (!file.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(file);
        return Response.ok(file, mt).header("ContentType", "image/*").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public boolean postImage(@QueryParam("accountId") final int accountID,
                             @QueryParam("imageName") final String imageName,
                             @HeaderParam("password") final String password,
                             final File f) {
        SaveImage.settleIntoDISK(f, imageName);
        return true;
    }


}
