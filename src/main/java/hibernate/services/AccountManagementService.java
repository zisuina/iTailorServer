package hibernate.services;

import hibernate.community.Account;
import hibernate.community.TimeLine;
import hibernate.recommendation.User;
import org.apache.log4j.Logger;
import util.BaseDAO;
import util.EmailVerification;

import java.util.List;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountManagementService {
    Logger logger = Logger.getLogger(AccountManagementService.class);
    Account account = null;

    public boolean isAccountAlreadyExisted(String email) {
        if (email == null || email.isEmpty() || !EmailVerification.isValid(email)) {
            return false;
        }
        List<Account> accountArrayList = new BaseDAO<Account>().list("select a from Account as a");
        for (Account account : accountArrayList) {
            if (account.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean registerANewAccount(String email, String password) {
        if (email == null || email.isEmpty() || !EmailVerification.isValid(email)) {
            return false;
        }
        if (password == null) {
            password = "";
        }
        if (!isAccountAlreadyExisted(email)) {
            Account account = new Account(email, password);
            new BaseDAO<Account>().create(account);
            logger.debug("Create a new account:" + email);
            return true;
        }
        return false;
    }

    public Account getAccountByEmail(String email) {
        if (email == null || email.isEmpty() || !EmailVerification.isValid(email)) {
            return null;
        }
        List<Account> accountArrayList = new BaseDAO<Account>().list("select a from Account as a");
        for (Account temp : accountArrayList) {
            if (temp.getEmail().equals(email)) {
                logger.debug("Get the reference of account:" + email);
                return temp;
            }
        }
        return null;
    }

    public boolean loginAccountByEmail(String email) {
        if (isAccountAlreadyExisted(email)) {
            Account temp = getAccountByEmail(email);
            temp.setLogIn(true);
            new BaseDAO<Account>().update(temp);
            logger.debug("Login account:" + email);
            return true;
        } else {
            if (registerANewAccount(email, email)) {
                logger.debug("Create and login account:" + email);
                Account temp = getAccountByEmail(email);
                temp.setLogIn(true);
                new BaseDAO<Account>().update(temp);
                return true;
            }
        }
        return false;
    }

    public void logoutAccountByEmail(String email) {
        Account account = getAccountByEmail(email);
        if (account != null && account.isLogIn()) {
            account.setLogIn(false);
            logger.debug("Logout account:" + email);
            new BaseDAO<Account>().update(account);
        }
    }

    public void newUserForNotNullAccount(Account account, String nickname) {
        User user = new User();
        nickname = nickname == null ? "" : nickname;
        user.setNickname(nickname);
        account.setUser(user);
        new BaseDAO<Account>().update(account);
    }

    public void newTimeLineForNotNullAccount(Account account) {
        TimeLine timeLine = new TimeLine();
        account.setTimeLine(timeLine);
        new BaseDAO<Account>().update(account);
    }
}
