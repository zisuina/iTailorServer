package resource.user;

import entity.Account;
import util.BaseDAO;
import util.EmailVerification;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("accounts")
public class AccountResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account get(@QueryParam("email") final String name) {
        if (name == null || !EmailVerification.isValid(name) || name.isEmpty()) {
            return null;
        }
        BaseDAO<Account> accountDAO = new BaseDAO<>();
        List<Account> accountList = accountDAO.list("select t from Account as t");
        for (Account one : accountList) {
            if (one.getName().equals(name)) {
                return new Account(one.getName(), "no-way");
            }
        }
        return null;
    }

    //注册
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public boolean post(@QueryParam("email") final String name,
                        @HeaderParam("password") final String pwd) {

        if (name == null || !EmailVerification.isValid(name) || name.isEmpty()) {
            return false;
        }
        BaseDAO<Account> accountDAO = new BaseDAO<>();
        List<Account> accountList = accountDAO.list("select t from Account as t");
        for (Account one : accountList) {
            if (one.getName().equals(name)) {
                return false;
            }
        }
        accountDAO.create(new Account(name, pwd == null ? "" : pwd));
        return true;
    }

    //注销
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean delete(@QueryParam("email") final String name,
                          @HeaderParam("password") final String pwd) {
        if (name == null || !EmailVerification.isValid(name) || name.isEmpty()) {
            return false;
        }
        BaseDAO<Account> accountDAO = new BaseDAO<>();
        List<Account> accountList = accountDAO.list("select t from Account as t");
        for (Account one : accountList) {
            if (one.getName().equals(name)) {
                if (one.getPwd().isEmpty() || one.getPwd().equals(pwd)) {
                    accountDAO.delete(one);
                    return true;
                }
            }
        }
        return false;
    }

    //修改
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public boolean put(@QueryParam("email") final String name,
                       @HeaderParam("password") final String pwd,
                       @HeaderParam("newword") final String newpwd) {
        if (name == null || !EmailVerification.isValid(name) || name.isEmpty()) {
            return false;
        }
        System.out.println(name + ":" + pwd + ":" + newpwd);
        BaseDAO<Account> accountDAO = new BaseDAO<>();
        List<Account> accountList = accountDAO.list("select t from Account as t");
        for (Account one : accountList) {
            if (one.getName().equals(name)) {
                if (one.getPwd().isEmpty() || one.getPwd().equals(pwd)) {
                    one.setPwd(newpwd == null ? "" : newpwd);
                    accountDAO.update(one);
                    return true;
                }
            }
        }
        return false;
    }
}
