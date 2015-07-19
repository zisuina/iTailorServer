package resource;

import entity.Dog;
import entity.JsonDog;
import util.BaseDAO;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * Created by liker on 08/07/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("dogresource")
public class DogResource {
    private BaseDAO<Dog> baseDAO = new BaseDAO<Dog>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonDog getIt() {
        return new JsonDog();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
//    @Consumes(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String saveDog(final String dog) {
        return dog;
    }


    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonDog getWt() {
        return new JsonDog();
    }


    @Path("/onemore")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void addOneDog() {
        baseDAO.create(new Dog("hello"));
//        int motherId = Integer.parseInt(request.getParameter("motherId"));
//        Session session = HibernateSessionFactory.getSession();
//        Query query = session.createQuery(" select d from Dog as d ");
//        List<Dog> dogList = query.list();
//        for (Dog d : dogList) {
//            System.out.println(d.show());
//        }
    }

    @Path("/file")
    @GET
    @Produces("image/*")
    public Response getImage(@QueryParam("imageId") final String imageID,
                             @Context ServletContext application) {
        String realPath = application.getRealPath("/images");
        System.out.println("realPath:" + realPath + "\\" + imageID);
        File file = new File(realPath, imageID);
        if (!file.exists()) {
            throw new WebApplicationException(404);
        }

        String mt = new MimetypesFileTypeMap().getContentType(file);
        System.out.println("mt:" + mt);
        return Response.ok(file, mt).header("ContentType", "image/*").build();
    }
}
