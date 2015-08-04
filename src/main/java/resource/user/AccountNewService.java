package resource.user;

import hibernate.community.Account;
import hibernate.community.Group;
import org.apache.log4j.Logger;
import util.BaseDAO;
import util.EmailVerification;

import java.util.List;

/**
 * Created by liker on 04/08/2015 0004.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountNewService {
    private static Logger logger = Logger.getLogger(AccountNewService.class);
    private List<Account> accountArrayList = new BaseDAO<Account>().list("select a from Account as a");

    public AccountNewService() {
    }

    public boolean isEmailWellFormatted(String email) {
        logger.debug("Email-check:" + email);
        return EmailVerification.isValid(email);
    }

    public Account getAccountForWellFormattedEmail(String email) {
        for (Account ref : accountArrayList) {
            if (ref.getEmail().equals(email)) {
                return ref;
            }
        }
        return null;
    }

    public Account registerAccountForWellFormattedEmail(String email, String password) {
        Account account = new Account(email, password == null ? "" : password);
        accountArrayList.add(account);
        logger.debug("Create a new account:" + email);
        return account;
    }

    public Account getAccountAfterCheckPasswordByAccountID(int accountID, String password) {
        for (Account account : accountArrayList) {
            if (accountID == account.getAccountID() && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public Account getAccountWithoutCheckPasswordByAccountID(int accountID) {
        for (Account account : accountArrayList) {
            if (accountID == account.getAccountID()) {
                return account;
            }
        }
        return null;
    }

    public void updateOneAccountByAnother(Account one, Account another) {
        one.setPassword(another.getPassword() == null ? "" : another.getPassword());
        one.setSync(another.isSync());
        one.setLogIn(another.isLogIn());
        //能被修改的字段，安全策略
    }

    public void updateOneGroupByAnother(Group one, Group another) {
        one.setGroupName(another.getGroupName() == null ? "undefine" : another.getGroupName());
    }

    public Group getGroupByAccountIDAndGroupID(int accountID, int groupID) {
        Account account = getAccountWithoutCheckPasswordByAccountID(accountID);
        if (account != null) {
            if (account.getRootGroup().getGroupID() == groupID) {
                return account.getRootGroup();
            }
            for (Group group : account.getGroups()) {
                if (group.getGroupID() == groupID) {
                    return group;
                }
            }
        }
        return null;
    }

    public Group getGroupByAccountIDAndAnotherAccountID(int accountID, int anotherAccountID) {
        Account account = getAccountWithoutCheckPasswordByAccountID(accountID);
        for (Account ref : account.getRootGroup().getAccountList()) {
            if (ref.getAccountID() == anotherAccountID) {
                return account.getRootGroup();
            }
        }
        for (Group group : account.getGroups()) {
            for (Account ref : group.getAccountList()) {
                if (ref.getAccountID() == anotherAccountID) {
                    return group;
                }
            }
        }
        return null;
    }

//    public boolean canBeSave(ShareItem shareItem,Comment comment){
//
//    }

    public List<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(List<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }
}
