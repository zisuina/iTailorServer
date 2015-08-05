//package resource.user;
//
//import hibernate.community.Account;
//import hibernate.community.Group;
//import hibernate.services.AccountService;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//
///**
// * Created by liker on 02/08/2015 0002.
// * Group iTailor.hunters.neu.edu.cn
// */
//@Path("accounts")
//public class GroupResource {
//    //    private Group group;
//    private Account account;
//    private AccountService accountService = new AccountService();
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Group get(@QueryParam("email") final String email,
//                     @HeaderParam("password") final String password,
//                     @QueryParam("groupName") final String gname) {
//        if (accountService.checkPassword(email, password)) {
//            account = accountService.getAccount();
//            if (gname == null || gname.equals("undefine")) {
//                return null;
//            }
//            for (Group group : account.getGroups()) {
//                if (group.getGroupName().equals(gname)) {
//                    return group;
//                }
//            }
//        }
//        return null;
//    }
//
//    @PUT
//    public boolean put(@QueryParam("email") final String email,
//                       @HeaderParam("password") final String password,
//                       @QueryParam("groupName") final String gname,
//                       @QueryParam("newGroupName") final String ngname) {
//        boolean flag = false;
//        if (accountService.checkPassword(email, password)) {
//            account = accountService.getAccount();
//            if (gname == null || ngname == null) {
//                return false;
//            }
//
//            for (Group group : account.getGroups()) {
//                if (group.getGroupName().equals(gname)) {
//                    group.setGroupName(ngname);
//                    flag = true;
//                }
//            }
//        }
//        return flag == false;
//    }
//
//    @DELETE
//    public boolean delete(@QueryParam("email") final String email,
//                          @HeaderParam("password") final String password,
//                          @QueryParam("groupName") final String gname) {
//        if (gname == null) {
//            return false;
//        }
//        Boolean flag = false;
//        if (accountService.checkPassword(email, password)) {
//            account = accountService.getAccount();
//
//            Group tobe = null;
//            for (Group group : account.getGroups()) {
//                if (group.getGroupName().equals(gname)) {
//                    for (Account temp : group.getAccountList()) {
//                        account.getRootGroup().getAccountList().add(temp);
//                    }
//                    tobe = group;
//                    flag = true;
//                }
//            }
//            if (flag) {
//                account.getGroups().remove(tobe);
//            }
//        }
//        return flag;
//    }
//
//    @POST
//    public boolean post(@QueryParam("email") final String email,
//                        @HeaderParam("password") final String password,
//                        @QueryParam("groupName") final String gname) {
//        if (gname == null || password == null) {
//            return false;
//        }
//        if (accountService.checkPassword(email, password)) {
//            account = accountService.getAccount();
//            for (Group group : account.getGroups()) {
//                if (group.getGroupName().equals(gname)) {
//                    return false;
//                }
//            }
//            account.getGroups().add(new Group(gname));
//        }
//        return true;
//    }
//}
