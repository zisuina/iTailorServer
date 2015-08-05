//package resource.user;
//
//import resource.json.JImage;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
///**
// * Created by liker on 24/07/2015 0024.
// * Group iTailor.hunters.neu.edu.cn
// */
//@Path("images")
//public class OnLineImageResource {
//    //注册
//    @POST
//    @Produces(MediaType.TEXT_PLAIN)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public boolean post(JImage jImage) {
//        System.out.println(jImage.getUserID());
//        System.out.println(jImage.getName());
//        System.out.println(jImage.getFormat());
//        System.out.println(jImage.getSize());
//        System.out.println(jImage.getDescription());
//        return true;
//    }
//}
