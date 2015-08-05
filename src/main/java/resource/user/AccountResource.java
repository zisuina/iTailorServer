package resource.user;

import hibernate.community.*;
import resource.message.AccountJson;
import resource.message.GroupJson;
import resource.message.MessageJson;
import resource.message.ShareItemJson;
import util.BaseDAO;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("accountS")
public class AccountResource {

    //    @Path("/")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
//    email thea.zhu6@foxmail.com
//    email thea.zhu14@foxmail.com
//    password helloworld
    public boolean registerAccount(@QueryParam("email") final String email,
                                   @HeaderParam("password") final String password) {
        System.out.println("FINE!POST");
        AccountNewService accountNewService = new AccountNewService();
//        accountNewService.comeBackFromDB();
        if (accountNewService.isEmailWellFormatted(email)) {
            if (accountNewService.getAccountForWellFormattedEmail(email) == null) {
                System.out.println("FINE!!!!!POST");
                accountNewService.registerAccountForWellFormattedEmail(email, password);
                System.out.println("Email:" + email);
                accountNewService.settleIntoDB();
                return true;
            }
        }
        return false;
    }


    //注销
//    @Path("/")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
//    accountID 30
//    password helloworld
    public boolean deleteAccount(@QueryParam("accountID") final int accountID,
                                 @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account ref = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (ref != null) {
            System.out.println("FINE!DELETE");
            accountNewService.getAccountArrayList().remove(ref);
            accountNewService.getAccountTobeLeave().add(ref);
            accountNewService.settleIntoDB();
            return true;
        }
        return false;
    }

    //更新
//    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
//    {"accountID":"35","password":"newpassword","sync":"true","logIn":"true"}
    public boolean updateAccount(@HeaderParam("password") final String password,
                                 final Account account) {
        AccountNewService accountNewService = new AccountNewService();
        System.out.println("deleteID:" + account.getAccountID());
        Account ref = accountNewService
                .getAccountAfterCheckPasswordByAccountID(account.getAccountID(), password);
        System.out.println("ID:" + account.getAccountID());
        System.out.println("PWD:" + password);
        if (ref != null && ref.getPassword().equals(password)) {
            System.out.println("ID:" + ref.getAccountID());
            System.out.println("PWD:" + ref.getPassword());
            accountNewService.updateOneAccountByAnother(ref, account);
            System.out.println("FINE!PUT");
            return true;
        }
        return false;
    }

    //登陆
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccountJson getAccount(@QueryParam("email") final String email,
                                  @HeaderParam("password") final String password,
                                  @Context HttpServletRequest request) {
        AccountNewService accountNewService = new AccountNewService();

        if (accountNewService.isEmailWellFormatted(email)) {
            Account account = accountNewService.getAccountForWellFormattedEmail(email);
            if (account != null) {
                LoginRecord loginRecord = new LoginRecord();
                loginRecord.setIp(request.getRemoteAddr());
                loginRecord.setUDID(request.getRemoteUser());
                account.getLoginRecords().add(loginRecord);
                accountNewService.settleIntoDB();
                System.out.println("FINE!GET");
                return account.createJson();
            }
        }
        return null;
    }

    //http://localhost:8080/itailor/accountS/messageS?accountID=3
    @Path("/messageS")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
//    {"messageID":"1","senderAccountID":"1","context":"he$llo mes@sage"}
    public boolean postMessage(@QueryParam("accountID") final int accountID,
                               final MessageJson messageJson) {
        AccountNewService accountNewService = new AccountNewService();
        Account ref = accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID);
        if (ref != null) {
            Message message = new Message();
            message.setContext(messageJson.getContext());
            message.setSenderAccount(ref);
            message.setCreatedTime(messageJson.getCreatedTime());
            ref.getMessageList().add(message);
            new BaseDAO<Account>().update(ref);
            return true;
        }
        return false;
    }

    //http://localhost:8080/itailor/accountS/messageS?accountID=3&messageID=589824
    @Path("/messageS")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteMessage(@QueryParam("accountID") final int accountID,
                                 @QueryParam("messageID") final int messageID,
                                 @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account =
                accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            for (Message message : account.getMessageList()) {
                if (message.getMessageID() == messageID) {
                    account.getMessageList().remove(message);
                    new BaseDAO<Account>().update(account);
                    message.setSenderAccount(null);
                    new BaseDAO<Message>().delete(message);
                    return true;
                }
            }
        }
        return false;
    }


    @Path("/messageS")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageJson> getMessage(@QueryParam("accountID") final int accountID,
                                        @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);

        List<Message> messages = new ArrayList<>();
        if (account != null) {
            Timestamp timestamp = account.getLatestSyncTime();
            System.out.println("SIZE:::" + account.getMessageList().size());
            messages.addAll(account.getMessageList()
                    .stream().filter(message -> message.getCreatedTime().compareTo(timestamp) > 0)
                    .collect(Collectors.toList()));
        }
        accountNewService.settleIntoDB();
        List<MessageJson> messageJsons = messages.stream().map(Message::becomeToJson).collect(Collectors.toList());
        System.out.println("JSON SIZE:" + messageJsons.size());
        account.setLatestSyncTime(new Timestamp(System.currentTimeMillis()));
        new BaseDAO<Account>().update(account);
        return messageJsons;
    }

    //
    @Path("/groupS")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
//    http://localhost:8080/itailor/accountS/groupS?accountID=4
//    {"groupID":"0","receive":"true","send":"true","groupName":"hello"}
    public boolean postGroup(@QueryParam("accountID") final int accountID,
                             @HeaderParam("password") final String password,
                             final GroupJson groupJson) {
        Group group = new Group();
        AccountNewService accountNewService = new AccountNewService();

        group.setAccessControl(new AccessControl(groupJson.isReceive(), groupJson.isSend()));
        group.setGroupName(groupJson.getGroupName());

        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            for (Group ref : account.getGroups()) {
                if (ref.getGroupName().equals(group.getGroupName())) {
                    return false;
                }
            }
            account.getGroups().add(group);
            new BaseDAO<Account>().update(account);
            return true;
        }
        return false;
    }

    @Path("/groupS")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteGroup(@QueryParam("accountID") final int accountID,
                               @QueryParam("groupID") final int groupID,
                               @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            for (Group group : account.getGroups()) {
                if (group.getGroupID() == groupID) {
                    account.getGroups().remove(group);
                    new BaseDAO<Account>().update(account);
                    group.setAccountList(null);
                    group.setAccessControl(null);
                    new BaseDAO<Group>().delete(group);
                    return true;
                }
            }
        }
        return false;
    }

    @Path("/groupS")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GroupJson putGroup(@QueryParam("accountID") final int accountID,
                              @QueryParam("groupID") final int groupID,
                              @HeaderParam("password") final String password,
                              final GroupJson groupJson) {


        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            for (Group ref : account.getGroups()) {
                if (ref.getGroupID() == groupID) {
//                    accountNewService.updateOneGroupByAnother(ref, group);
                    ref.getAccessControl().setReceive(groupJson.isReceive());
                    ref.getAccessControl().setSend(groupJson.isSend());
                    ref.setGroupName(groupJson.getGroupName());
                    new BaseDAO<Group>().update(ref);
                    return ref.becomeToGroupJson();
                }
            }
        }
        return null;
    }

    @Path("/groupS")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GroupJson getGroup(@QueryParam("accountID") final int accountID,
                              @QueryParam("groupID") final int groupID,
                              @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            for (Group ref : account.getGroups()) {
                if (ref.getGroupID() == groupID) {
                    return ref.becomeToGroupJson();
                }
            }
        }
        return null;
    }


    @Path("/groupS/accountS")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    //待测试
    public boolean postGroupAccount(@QueryParam("accountID") final int accountID,
                                    @QueryParam("groupID") final int groupID,
                                    @QueryParam("email") final String email,
                                    @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            if (accountNewService.isEmailWellFormatted(email)) {
                Account ref = accountNewService.getAccountForWellFormattedEmail(email);
                if (!account.isAFriendOf(ref)) {
//                    if (account.getPursuers().contains(ref)) {
//                        account.getRootGroup().getAccountList().add(ref);
//                        accountNewService.getGroupByAccountIDAndGroupID(accountID, groupID)
//                                .getAccountList().add(ref);
//                        ref.getRootGroup().getAccountList().add(account);
//                        account.getPursuers().remove(ref);
////                        new BaseDAO<Account>().update(account);
//                        //可能存在问题
//                    } else if (ref.getPursuers().contains(account)) {
//                        return false;
//                    }
//                    ref.getPursuers().add(account);
                    account.getRootGroup().getAccountList().add(ref);
                    ref.getRootGroup().getAccountList().add(account);
                    new BaseDAO<Account>().update(account);
                    new BaseDAO<Account>().update(ref);
                    return true;
                }
            }
        }
        return false;
    }


    @Path("/groupS/accountS")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteGroupAccount(@QueryParam("accountID") final int accountID,
                                      @QueryParam("accountID2") final int accountID2,
                                      @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            Group one = accountNewService.getGroupByAccountIDAndAnotherAccountID(accountID, accountID2);
            Group two = accountNewService.getGroupByAccountIDAndAnotherAccountID(accountID2, accountID);
            if (one != null && two != null) {
                one.getAccountList().remove(accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID2));
                one.getAccountList().remove(accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID));
                new BaseDAO<Account>().update(account);
                return true;
            }
            new BaseDAO<Account>().update(account);
        }
        return false;
    }


    @Path("/groupS/accountS")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccountJson getGroupAccount(@QueryParam("accountID") final int accountID,
                                       @QueryParam("accountID2") final int accountID2,
                                       @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            Group one = accountNewService.getGroupByAccountIDAndAnotherAccountID(accountID, accountID2);
            for (Account ref : one.getAccountList()) {
                if (ref.getAccountID() == accountID2) {
                    //TO DO 要过滤掉不该被看到的内容以及嵌套调用的内容
                    return ref.createJson();
                }
            }
        }
        return null;
    }

    //
    @Path("/groupS/accessControl")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
//    {"receive":"true","send":"false"}
    public AccessControl putAccessControl(@QueryParam("accountID") final int accountID,
                                          @QueryParam("groupID") final int groupID,
                                          final AccessControl accessControl) {
        AccountNewService accountNewService = new AccountNewService();
        Group group = accountNewService.getGroupByAccountIDAndGroupID(accountID, groupID);
        AccessControl access = new AccessControl(accessControl.isReceive(), accessControl.isSend());
//        AccessControlService accessControlService = new AccessControlService();
//        group.setAccessControl(accessControlService
//                .getSpecificAccessControl(accessControl.isReceive(), accessControl.isSend()));
        group.setAccessControl(access);
        new BaseDAO<Group>().update(group);
        return group.getAccessControl();
    }

    @Path("/groupS/accessControl")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccessControl getAccessControl(@QueryParam("accountID") final int accountID,
                                          @QueryParam("groupID") final int groupID) {
        AccountNewService accountNewService = new AccountNewService();
        Group group = accountNewService.getGroupByAccountIDAndGroupID(accountID, groupID);
        return group.getAccessControl();
    }

    @Path("timeline")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShareItemJson> getTimeLine(@QueryParam("accountID") final int accountID,
                                           @QueryParam("limit") final int limit,
                                           @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            if (account.getTimeLine() == null) {
                account.setTimeLine(new TimeLine());
                new BaseDAO<Account>().update(account);
            }
            List<ShareItem> shareItems = account.getTimeLine().getSortedShareItems();
            shareItems = shareItems.subList(0, limit > shareItems.size() ? shareItems.size() : limit);
            List<ShareItemJson> shareItemJsons = shareItems.stream()
                    .map(ShareItem::becomeToJson).collect(Collectors.toList());
        }
        return null;
    }

    @Path("timeline/shareItems")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteTimelineShareItem(@QueryParam("accountID") final int accountID,
                                           @QueryParam("shareItemID") final int shareItemID,
                                           @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getShareItemID() == shareItemID) {
                    if (account.getUser().equals(shareItem.getResource().getUser())) {
                        account.getShareItems().remove(shareItem);
                    }
                    account.getTimeLine().getShareItems().remove(shareItem);
                    new BaseDAO<Account>().update(account);
                    return true;
                }
            }
        }
        return false;
    }

    @Path("timeline/shareItems")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ShareItem> getTimeLineShareItems(@QueryParam("accountID") final int accountID,
                                                 @QueryParam("timestamp") final Timestamp timestamp,
                                                 @HeaderParam("password") final String password) {
        AccountNewService accountNewService = new AccountNewService();
        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
        List<ShareItem> shareItems = new ArrayList<>();
        if (account != null) {
            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
                if (shareItem.getCreatedTime().compareTo(timestamp) == 1) {
                    shareItems.add(shareItem);
                }
            }
        }
        return shareItems;
    }


//    @Path("timeline/shareItems/commentS")
//    @POST
//    @Produces(MediaType.TEXT_PLAIN)
//    public void postTimeLineShareItemsComment(@QueryParam("shareItemID") final int shareItemID,
//                                              @HeaderParam("password") final String password,
//                                              final Comment comment) {
//        Account account = comment.getSenderAccount();
//        if (account != null && account.getPassword().equals(password)) {
//            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
//                if (shareItem.getShareItemID() == shareItemID) {
//                    shareItem.getComments().add(comment);
//                }
//            }
//        }
//    }
//
//    @Path("timeline/shareItems/commentS")
//    @DELETE
//    @Produces(MediaType.TEXT_PLAIN)
//    public boolean deleteTimeLineShareItemsComment(@QueryParam("accountID") final int accountID,
//                                                   @QueryParam("shareItemID") final int shareItemID,
//                                                   @QueryParam("commentID") final int commentID) {
//        //只有发布者与子与分享单件可以删除评论
//        Account account = accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID);
//        if (account != null) {
//            for (ShareItem shareItem : account.getTimeLine().getShareItems()) {
//                if (shareItem.getShareItemID() == shareItemID) {
//                    for (Comment comment : shareItem.getComments()) {
//                        if (comment.getMessageID() == commentID) {
//                            if (account.getUser().equals(shareItem.getResource().getUser())
//                                    || comment.getSenderAccount().equals(account)) {
//                                shareItem.getComments().remove(comment);
//                            }
//                        }
//                    }
//                }
//            }
////            for (ShareItem shareItem : account.getShareItems()) {
////                if (shareItem.getShareItemID() == shareItemID) {
////                    for (Comment comment : shareItem.getComments()) {
////                        if (comment.getMessageID() == commentID) {
////                            if (account.getUser().equals(shareItem.getResource().getUser())
////                                    || comment.getSenderAccount().equals(account)) {
////                                shareItem.getComments().remove(comment);
////                            }
////                        }
////                    }
////                }
////            }
//            //评论删除有没有同步我很期待Java对象管理给予我肯定回复
//            return true;
//        }
//        return false;
//    }
//
//    @Path("timeline/shareItems/commentS")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Comment> getTimeLineShareItemsComment(@QueryParam("accountID") final int accountID,
//                                                      @QueryParam("shareItemID") final int shareItemID,
//                                                      @QueryParam("limit") final int limit) {
//
//        List<Comment> comments2 = new ArrayList<>();
//        //权限控制在哪？
//        Account account = accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID);
//        if (account != null) {
//            ShareItemNewService shareItemNewService = new ShareItemNewService();
//            List<Comment> comments = shareItemNewService.getShareItemByID(shareItemID).getComments();
//            comments = comments.subList(0, limit > comments.size() ? comments.size() : limit);
//            for (Comment comment : comments) {
//                TimeLineService timeLineService = new TimeLineService(comment.getSenderAccount());
//                if (timeLineService.getSendAccountList().contains(account)) {
//                    comments.add(comment);
//                }
//            }
//        }
//        return comments2;
//    }
//
//    @Path("loginRecords")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void postLoginRecords(@QueryParam("email") final String email,
//                                 @HeaderParam("password") final String password,
//                                 final LoginRecord loginRecord) {
//        if (accountNewService.isEmailWellFormatted(email)) {
//            Account account = accountNewService.getAccountForWellFormattedEmail(email);
//            if (account.getPassword().equals(password)) {
//                account.getLoginRecords().add(loginRecord);
//                account.setLogIn(true);
//            }
//        }
//    }
//
//    @Path("loginRecords")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deleteLoginRecords(@QueryParam("email") final String email,
//                                   @HeaderParam("password") final String password,
//                                   final LoginRecord loginRecord) {
//        if (accountNewService.isEmailWellFormatted(email)) {
//            Account account = accountNewService.getAccountForWellFormattedEmail(email);
//            if (account.getPassword().equals(password)) {
//                account.getLoginRecords().add(loginRecord);
//                account.setLogIn(false);
//            }
//        }
//    }
//
//    @Path("loginRecords")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<LoginRecord> getLoginRecords(@QueryParam("accountID") final int accountID,
//                                             @QueryParam("limit") final int limit,
//                                             @HeaderParam("password") final String password) {
//        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
//        if (account != null) {
//            List<LoginRecord> loginRecords = account.getLoginRecords();
//            return loginRecords.subList(0, limit > loginRecords.size() ? loginRecords.size() : limit);
//        }
//        return null;
//    }
//
//
//    @Path("accounts")
//    @POST
//    public boolean postAccounts(@QueryParam("accountID") final int accountID,
//                                @QueryParam("email") final String email) {
//        Account account = accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID);
//        if (accountNewService.isEmailWellFormatted(email)) {
//            Account account2 = accountNewService.getAccountForWellFormattedEmail(email);
//            if (!account.isAFriendOf(account2)) {
//                if (account.getPursuers().contains(account2)) {
//                    account.getRootGroup().getAccountList().add(account2);
//                    account2.getRootGroup().getAccountList().add(account);
//                    account.getPursuers().remove(account2);
//                }
//                account2.getPursuers().add(account);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Path("accounts")
//    @DELETE
//    public void deleteAccounts(@QueryParam("accountID") final int accountID,
//                               @QueryParam("accountID") final int accountID2) {
//        Account account = accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID);
//        Account account2 = accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID2);
//        if (account != null && account2 != null) {
//            if (account.getPursuers().contains(account2)) {
//                account.getPursuers().remove(account2);
//            }
//            if (account2.getPursuers().contains(account)) {
//                account2.getPursuers().remove(account);
//            }
//        }
//    }
//
//    @Path("accounts")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Account> getAccounts(@QueryParam("accountID") final int accountID) {
//        return accountNewService.getAccountWithoutCheckPasswordByAccountID(accountID).getPursuers();
//    }
//
//    @Path("shareItems")
//    @POST
//    public void postShareItems(@QueryParam("accountID") final int accountID,
//                               @HeaderParam("password") final String password,
//                               final ShareItem shareItem) {
//        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
//        if (account != null) {
//            ShareItemService shareItemService = new ShareItemService();
//            shareItemService.pushShareItem(account, shareItem);
//        }
//    }
//
//    @Path("shareItems")
//    @DELETE
//    public boolean deleteShareItems(@QueryParam("accountID") final int accountID,
//                                    @HeaderParam("shareItemID") final int shareItemID,
//                                    @HeaderParam("password") final String password) {
//        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
//        if (account != null) {
//            for (ShareItem shareItem : account.getShareItems()) {
//                if (shareItem.getShareItemID() == shareItemID) {
//                    account.getShareItems().remove(shareItem);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//
//    @Path("shareItems")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ShareItem> getShareItems(@QueryParam("accountID") final int accountID,
//                                         @QueryParam("limit") final int limit,
//                                         @HeaderParam("password") final String password) {
//        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
//        if (account != null) {
//            List<ShareItem> result = account.getShareItems();
//            return result.subList(0, limit > result.size() ? result.size() : limit);
//        }
//        return null;
//    }
//
//    @Path("rootGroup")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Group putRootGroup(@QueryParam("accountID") final int accountID,
//                              @HeaderParam("password") final String password,
//                              final Group group) {
//        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
//        if (account != null) {
//            accountNewService.updateOneGroupByAnother(account.getRootGroup(), group);
//        }
//        return account.getRootGroup();
//    }
//
//    @Path("rootGroup")
//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Group putRootGroup(@QueryParam("accountID") final int accountID,
//                              @HeaderParam("password") final String password) {
//        Account account = accountNewService.getAccountAfterCheckPasswordByAccountID(accountID, password);
//        if (account != null) {
//            return account.getRootGroup();
//        }
//        return null;
//    }


}
