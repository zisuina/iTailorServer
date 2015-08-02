package resource.user;

import hibernate.services.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("accounts")
public class AccountResource {
    private AccountService accountService = new AccountService();

    //登陆
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("email") final String email,
                      @HeaderParam("password") final String password,
                      @Context HttpServletRequest request) {
        accountService.checkPassword(email, password);
        if (accountService.loginAccountByEmail(email)) {
            return accountService.getAccount().getAuthenticate();
        }
        return "NOT_BE_ACCEPTED";
    }

    //注册
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean post(@QueryParam("email") final String email,
                        @HeaderParam("password") final String password) {
        accountService.checkPassword(email, password);
        if (accountService.getAccount() == null) {
            accountService.registerANewAccount(email, password);
            return true;
        }
        return false;
    }

    //注销
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean delete(@QueryParam("email") final String email,
                          @HeaderParam("password") final String password) {
        accountService.checkPassword(email, password);
        return accountService.deleteAccountByEmail(email);
    }

    //更新
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public boolean put(@QueryParam("email") final String email,
                       @HeaderParam("password") final String password,
                       @HeaderParam("newPassword") final String newPassword) {
        if (accountService.checkPassword(email, password)) {
            accountService.getAccount().setPassword(newPassword);
            accountService.doHibernateSaveOrUpdate();
            return true;
        }
        return false;
    }
}
