package resource.recommendation;

import hibernate.community.Account;
import hibernate.recommendation.User;
import resource.json.ResourceJson;
import resource.service.AccountNewService;
import resource.service.UserService;

import javax.ws.rs.*;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("tobe")
public class UserResource {
    @Path("Resource")
    @POST
    public boolean postResource(@QueryParam("accountID") final int accountID,
                                @HeaderParam("password") final String password,
                                final ResourceJson resourceJson) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        UserService userService = new UserService();
        User user = userService.getUserByAccountID(accountID);
        if (account != null && user != null) {
            //TODO
        }
        return false;
    }

    @Path("Resource")
    @DELETE
    public boolean deleteResource(@QueryParam("accountID") final int accountID,
                                  @QueryParam("resourceID") final int resourceID,
                                  @HeaderParam("password") final String password) {
        return false;
    }

    @Path("Resource")
    @PUT
    public boolean putResource(@QueryParam("accountID") final int accountID,
                               @QueryParam("resourceID") final int resourceID,
                               @HeaderParam("password") final String password) {
        return false;
    }

    @Path("Resource")
    @GET
    public boolean getResource(@QueryParam("accountID") final int accountID,
                               @QueryParam("resourceID") final int resourceID,
                               @HeaderParam("password") final String password) {
        return false;
    }

    @Path("/SearchWords")
    @POST
    public boolean postSearchWords() {
        return false;
    }

    @Path("/SearchWords")
    @GET
    public boolean getSearchWords() {
        return false;
    }

    @Path("/Body")
    @GET
    public boolean getBody() {
        return false;
    }

    @Path("/Body/BodyStatusES")
    @POST
    public boolean postBodyStatus() {
        return false;
    }

    @Path("/Body/BodyStatusES")
    @DELETE
    public boolean deleteBodyStatus() {
        return false;
    }

    @Path("/Body/BodyStatusES")
    @PUT
    public boolean putBodyStatus() {
        return false;
    }

    @Path("/Body/BodyStatusES")
    @GET
    public boolean getBodyStatus() {
        return false;
    }

    @Path("/Wardrobe")
    @PUT
    public boolean putRootWardrobe(){
        return false;
    }

    @Path("/Wardrobe")
    @GET
    public boolean getRootWardrobe(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS")
    @POST
    public boolean postWardrobes(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS")
    @DELETE
    public boolean deleteWardrobes(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS")
    @PUT
    public boolean putWardrobes(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS")
    @GET
    public boolean getWardrobes(){
        return false;
    }


    @Path("/Wardrobe/WardrobeS/ResourceS")
    @POST
    public boolean postWardrobeResource(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS/ResourceS")
    @DELETE
    public boolean deleteWardrobeResource(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS/ResourceS")
    @PUT
    public boolean putWardrobeResource(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS/ResourceS")
    @GET
    public boolean getWardrobeResource(){
        return false;
    }


    @Path("/Wardrobe/WardrobeS/ResourceS/3DResourceS")
    @POST
    public boolean postWardrobe3DResource(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS/ResourceS/3DResourceS")
    @DELETE
    public boolean deleteWardrobe3DResource(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS/ResourceS/3DResourceS")
    @PUT
    public boolean putWardrobe3DResource(){
        return false;
    }

    @Path("/Wardrobe/WardrobeS/ResourceS/3DResourceS")
    @GET
    public boolean getWardrobe3DResource(){
        return false;
    }


    @Path("/Wardrobe/WardrobeS/ResourceS/RecommendedResourceS")
    @GET
    public boolean getRecommendedResourceS(){
        return false;
    }









}
