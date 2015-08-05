//package resource.user;
//
//import hibernate.elements.Color;
//import util.BaseDAO;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import java.net.URISyntaxException;
//import java.util.List;
//
//
///**
// * Created by liker on 27/07/2015 0027.
// * Group iTailor.hunters.neu.edu.cn
// */
//@Path("colors")
//public class ColorResource {
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Color get(@QueryParam("color_ch") final String color_ch) throws URISyntaxException {
//        if (color_ch == null || color_ch.isEmpty()) {
//            return null;
//        }
//        BaseDAO<Color> colorDAO = new BaseDAO<>();
//        List<Color> colorList = colorDAO.list("select t from Color as t");
//        System.out.println("COLOR SIZE:" + colorList.size());
//        for (Color one : colorList) {
//            if (one.getName_ch().equals(color_ch)) {
//                return one;
//            }
//        }
//        return null;
//    }
//}
