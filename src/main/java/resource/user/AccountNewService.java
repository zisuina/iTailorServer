package resource.user;

import hibernate.community.Account;
import hibernate.community.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import util.BaseDAO;
import util.EmailVerification;
import util.hibernate.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 04/08/2015 0004.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountNewService {
    private static Logger logger = Logger.getLogger(AccountNewService.class);
    private static List<Account> accountArrayList = new ArrayList<>();
    private static List<Account> accountTobeLeave = new ArrayList<>();


    public List<String> getAllEmailsInDB() {
        System.out.println("GET All Emails from DB!");
        return new BaseDAO<String>().list("select a.email from Account as a");
    }

    public void comeBackFromDB() {
        accountArrayList = new BaseDAO<Account>().list("select a from Account as a");
    }

    public void settleIntoDB() {
        System.out.println("SETTLE INTO DB!");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            if (!accountArrayList.isEmpty()) {
                accountArrayList.forEach(session::saveOrUpdate);
            }
            if (!accountTobeLeave.isEmpty()) {
                accountTobeLeave.forEach(session::delete);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void reportStatus() {
        System.out.println("STAY@Account SIZE:" + accountArrayList.size());
        System.out.println("LEAVE@Account SIZE:" + accountTobeLeave.size());
    }

    public AccountNewService() {

    }

    public boolean isEmailWellFormatted(String email) {
        logger.debug("Email-check:" + email);
        return EmailVerification.isValid(email);
    }

    public Account getAccountForWellFormattedEmail(String email) {
        comeBackFromDB();
        for (Account ref : accountArrayList) {
            if (ref.getEmail().equals(email)) {
                return ref;
            }
        }
        return null;
    }

    public Account registerAccountForWellFormattedEmail(String email, String password) {
        comeBackFromDB();
        Account account = new Account(email, password == null ? "" : password);
        if (!getAllEmailsInDB().contains(email)) {
            accountArrayList.add(account);
        }
        settleIntoDB();
        logger.debug("Create a new account:" + email);
        return account;
    }

    public Account getAccountAfterCheckPasswordByAccountID(int accountID, String password) {
        comeBackFromDB();
        for (Account account : accountArrayList) {
            System.out.println("ACCOUNT-ID:" + account.getAccountID());
            if (accountID == account.getAccountID() && account.getPassword().equals(password)) {
                System.out.println("RETURN");
                return account;
            }
        }
        return null;
    }

    public Account getAccountWithoutCheckPasswordByAccountID(int accountID) {
        comeBackFromDB();
        for (Account account : accountArrayList) {
            if (accountID == account.getAccountID()) {
                return account;
            }
        }
        return null;
    }

    public void updateOneAccountByAnother(Account one, Account another) {
        one.setPassword(another.getPassword() == null ? "" : another.getPassword());
        System.out.println("NEW PASSWORD:" + one.getPassword());
        one.setSync(another.isSync());
        one.setLogIn(another.isLogIn());
        System.out.println("NEW LOGIN:" + one.isLogIn());
        settleIntoDB();
//        new BaseDAO<Account>().update(one);
        //能被修改的字段，安全策略
    }

    public void updateOneGroupByAnother(Group one, Group another) {
        one.setGroupName(another.getGroupName() == null ? "undefine" : another.getGroupName());
        new BaseDAO<Group>().update(one);
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

    public List<Account> getAccountTobeLeave() {
        return accountTobeLeave;
    }

    public void setAccountTobeLeave(List<Account> accountTobeLeave) {
        this.accountTobeLeave = accountTobeLeave;
    }
}
