package resource.recommendation;

import hibernate.community.Account;
import resource.json.ResourceJson;
import resource.service.AccountNewService;
import resource.service.ShareItemNewService;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("shareItems/Resource")
public class ShareItemResource {
    @GET
    public ResourceJson getResource(@QueryParam("accountID") final int accountID,
                                    @QueryParam("shareItemID") final int shareItemID,
                                    @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        ShareItemNewService shareItemNewService = new ShareItemNewService();
        if (account != null) {
            return shareItemNewService.getShareItemByID(shareItemID).getResource().becomeToJson();
        }
        return null;
    }

}
