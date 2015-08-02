package resource.user;

import hibernate.community.Feedback;
import hibernate.services.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */

@Path("messages")
public class MessagePushResource {
    @Path("feedbacks")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean post(@QueryParam("email") final String email,
                        @HeaderParam("password") final String password,
                        final Feedback feedback) {
        AccountService accountService = new AccountService();
        if (accountService.checkPassword(email, password)) {
            accountService.getAccount().getFeedbacks().add(feedback);
            return true;
        }
        return false;
    }

    @Path("feedbacks")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Feedback> get(@QueryParam("email") final String email,
                              @HeaderParam("password") final String password,
                              @QueryParam("limit") final int limit) {
        AccountService accountService = new AccountService();
        if (accountService.checkPassword(email, password)) {
            List<Feedback> feedbacks = accountService.getAccount().getFeedbacks();
            feedbacks.subList(0, limit < feedbacks.size() ? limit : feedbacks.size());
            return feedbacks;
        }
        return null;
    }
}
