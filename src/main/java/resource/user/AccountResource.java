package resource.user;

import hibernate.community.*;
import hibernate.services.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("account")
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

    @Path("message")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean postMessage(@QueryParam("email") final String email,
                               @HeaderParam("password") final String password,
                               final Message message) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            if (message != null) {
                account.getMessageList().add(message);
                return true;
            }
        }
        return false;
    }

    @Path("message")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteMessage(@QueryParam("email") final String email,
                                 @HeaderParam("password") final String password,
                                 final Message message) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            if (message != null) {
                if (account.getMessageList().contains(message)) {
                    account.getMessageList().remove(message);
                    return true;
                }
            }
        }
        return false;
    }


    @Path("message")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Message> getMessage(@QueryParam("email") final String email,
                                    @HeaderParam("password") final String password,
                                    final int limit) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null && limit > 0) {
            return account.getMessageList().subList(0,
                    limit < account.getMessageList().size() ?
                            limit : account.getMessageList().size());
        }
        return null;
    }

    @Path("timeline")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TimeLine getTimeLine(@QueryParam("email") final String email,
                                @HeaderParam("password") final String password) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            return account.getTimeLine();
        }
        return null;
    }

    @Path("timeline/shareItem")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<ShareItem> getShareItem(@QueryParam("email") final String email,
                                        @HeaderParam("password") final String password,
                                        final int limit) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null && limit > 0) {
            return account.getTimeLine().getShareItems().
                    subList(0, limit < account.getTimeLine().getShareItems().size() ?
                            limit : account.getTimeLine().getShareItems().size());
        }
        return null;
    }

    @Path("timeline/shareItem")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteShareItem(@QueryParam("email") final String email,
                                   @HeaderParam("password") final String password,
                                   final int shareItemID) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    account.getTimeLine().getShareItems().remove(shareItem);
                    return true;
                }
            }
        }
        return false;
    }

    @Path("shareItem")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public ShareItem getAShareItem(@QueryParam("email") final String email,
                                   @HeaderParam("password") final String password,
                                   final int shareItemID) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    return shareItem;
                }
            }
        }
        return null;
    }

    @Path("shareItem")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteAShareItem(@QueryParam("email") final String email,
                                    @HeaderParam("password") final String password,
                                    final int shareItemID) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    account.getTimeLine().getShareItems().remove(shareItem);
                    return true;
                }
            }
        }
        return false;
    }

    @Path("shareItem")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean postAShareItem(@QueryParam("email") final String email,
                                  @HeaderParam("password") final String password,
                                  final ShareItem shareItem) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            account.getShareItems().add(shareItem);
            return true;
        }
        return false;
    }

    @Path("shareItem/comment")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean postComment(@QueryParam("email") final String email,
                               @HeaderParam("password") final String password,
                               final int shareItemID,
                               final Comment comment) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    shareItem.getComments().add(comment);
                    return true;
                }
            }
        }
        return false;
    }


    @Path("shareItem/comment")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteComment(@QueryParam("email") final String email,
                                 @HeaderParam("password") final String password,
                                 final int shareItemID,
                                 final int commentID) {

        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    for (Comment comment : shareItem.getComments()) {
                        if (comment.getMessageID() == commentID) {
                            shareItem.getComments().remove(comment);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Path("shareItem/comment")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Comment getComment(@QueryParam("email") final String email,
                              @HeaderParam("password") final String password,
                              final int shareItemID,
                              final int commentID) {
        accountService.checkPassword(email, password);
        Account account = accountService.getAccount();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    for (Comment comment : shareItem.getComments()) {
                        if (comment.getMessageID() == commentID) {
                            return comment;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Path("account")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Group getGroup() {
        // TO DO
        return null;
    }

    @Path("account")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public boolean putGroup() {
        // TO DO
        return false;
    }

    @Path("account")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteGroup() {
        // TO DO
        return false;
    }

    @Path("account")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean postGroup() {
        // TO DO
        return false;
    }

    @Path("account/accessControl")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public boolean putAccessControl() {
        return false;
    }

    @Path("account/accessControl")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public AccessControl getAccessControl() {
        return null;
    }

    @Path("account/group/accounts")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Account getaAccount() {
        return null;
    }

    @Path("account/group/accounts")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteaAccount() {
        return false;
    }

    @Path("account/group/accounts")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean postaAccount() {
        return false;
    }


}
