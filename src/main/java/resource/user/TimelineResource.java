package resource.user;

import hibernate.community.Account;
import hibernate.services.AccountService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("timeline")
public class TimelineResource {
    private Account account;
    private AccountService accountService = new AccountService();
    @GET
    public void get(){

    }
}
