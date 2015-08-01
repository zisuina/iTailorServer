package resource.user;

import hibernate.community.Account;
import hibernate.community.LoginRecord;
import hibernate.services.AccountService;
import util.BaseDAO;

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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("email") final String email,
                      @HeaderParam("password") final String password,
                      @Context HttpServletRequest request) {
        Account account = AccountService.isAccountExisted(email);
        if (account != null && account.getPassword().equals(password)) {
            account.getLoginRecords().add(
                    new LoginRecord(request.getRemoteUser(), AccountService.getIpAddress(request))
            );
            account.login();
            new BaseDAO<Account>().update(account);
            return account.getAuthenticate();
        }
        return "NOT_BE_ACCEPTED";
    }

    //注册
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean post(@QueryParam("email") final String email,
                        @HeaderParam("password") final String password) {
        Account account = AccountService.isAccountExisted(email);
        if (account == null && password != null) {
            account = new Account(email, password);
            new BaseDAO<Account>().create(account);
            return true;
        }
        return false;
    }

    //注销
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean delete(@QueryParam("email") final String email,
                          @HeaderParam("password") final String password) {
        Account account = AccountService.isAccountExisted(email);
        if (account != null && password != null && account.getPassword().equals(password)) {
            new BaseDAO<Account>().delete(account);
            return true;
        }
        return false;
    }

    //更新
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public boolean put(@QueryParam("email") final String email,
                       @HeaderParam("password") final String password,
                       @HeaderParam("newPassword") final String newPassword) {
        Account account = AccountService.isAccountExisted(email);
        if (account != null && password != null && account.getPassword().equals(password)) {
            account.setPassword(newPassword);
            new BaseDAO<Account>().update(account);
            return true;
        }
        return false;

    }


}
