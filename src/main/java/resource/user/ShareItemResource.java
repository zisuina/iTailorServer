package resource.user;

import hibernate.community.Account;
import hibernate.community.ShareItem;
import hibernate.services.AccountService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("shareItems")
public class ShareItemResource {
    private Account account;
    private AccountService accountService = new AccountService();


    @GET
    public List<ShareItem> get(@QueryParam("email") final String email,
                               @HeaderParam("password") final String password,
                               final int limit) {
        if (accountService.checkPassword(email, password)) {
            account = accountService.getAccount();
            return account.getShareItems().subList(
                    0, limit < account.getShareItems().size() ? limit : account.getShareItems().size());
        }
        return null;
    }

    @POST
    public boolean post(@QueryParam("email") final String email,
                        @HeaderParam("password") final String password,
                        final ShareItem shareItem) {
        if (accountService.checkPassword(email, password)) {
            account = accountService.getAccount();
            account.getShareItems().add(shareItem);

            //to do 其他人的timeline更新与权限控制
            return true;
        }
        return false;
    }

    @DELETE
    public boolean delete(@QueryParam("email") final String email,
                          @HeaderParam("password") final String password,
                          final ShareItem shareItem) {
        if (accountService.checkPassword(email, password)) {
            account = accountService.getAccount();
            account.getShareItems().remove(shareItem);

            //to do 如何做到只考虑内容删除shareitem
            //同时保证其他人的timeline同步更新
            return true;
        }
        return false;

    }

}
