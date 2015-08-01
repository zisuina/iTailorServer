package resource.user;

import hibernate.community.AccessControl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("accessController")
public class GroupAccessControlResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccessControl get(@QueryParam("email") final String email,
                             @QueryParam("groupname") final String gname,
                             @HeaderParam("authenticate") final String authenticate) {


//        AccountService accountService = new AccountService();
//        Account account = accountService.getAccountByEmail(email);
//        if (account != null && gname != null) {
//            if(account.getAuthenticate().equals(authenticate)){
//                for (Group group : account.getGroups()) {
//                    if (group.getGroupName().equals(email)) {
//                        return group.getAccessControl();
//                    }
//                }
//            }
//        }
        return null;
    }
}
