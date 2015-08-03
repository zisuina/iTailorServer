package hibernate.services;

import hibernate.community.Account;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import util.BaseDAO;
import util.EmailVerification;
import util.hibernate.HibernateSessionFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountService {
    private static Logger logger = Logger.getLogger(AccountService.class);
    private static List<Account> accountArrayList = new BaseDAO<Account>().list("select a from Account as a");
    private Account account = null;
    private boolean accountLoadSkip = false;
    private boolean passwordCheckSkip = false;

    public AccountService() {
    }

    public static boolean isEmailWellFormatted(String email) {
        logger.debug("Email-check:" + email);
        return EmailVerification.isValid(email);
    }

    public void getAccountIfExisted(String email) {
        if (!accountLoadSkip) {
            if (isEmailWellFormatted(email)) {
                accountArrayList.stream()
                        .filter(temp -> temp.getEmail().equals(email))
                        .forEach(temp -> {
                            logger.debug("Get the reference of account:" + email);
                            account = temp;
                        });
                this.accountLoadSkip = true;
                logger.debug("FLAG:accountLoadSkip is changed.");
            }
        }
    }

    public boolean registerANewAccount(String email, String password) {
        if (isEmailWellFormatted(email)) {
            getAccountIfExisted(email);
            if (account == null) {
                accountArrayList.add(new Account(email, password == null ? "" : password));
                logger.debug("Create a new account:" + email);
                doHibernateSaveOrUpdate();
                return true;
            }
        }
        logger.debug("REGISTER FAIL:" + email + " # " + password);
        return false;
    }

    public boolean loginAccountByEmail(String email) {
        getAccountIfExisted(email);
        if (!isNull(account) && passwordCheckSkip) {
            passwordCheckSkip = true;
            account.setLogIn(true);
            account.updateAuthenticate();
            logger.debug("Login account:" + email);
            doHibernateSaveOrUpdate();
            return true;
        }
        logger.debug("LOGIN FAIL Account:" + email);
        return false;
    }

    public void logoutAccountByEmail(String email) {
        getAccountIfExisted(email);
        if (!isNull(account)) {
            account.setLogIn(false);
            logger.debug("Logout account:" + email);
            doHibernateSaveOrUpdate();
        }
    }

    public boolean deleteAccountByEmail(String email) {
        getAccountIfExisted(email);
        System.out.println(isNull(account));
        System.out.println(isNull(passwordCheckSkip));
        if (!isNull(account) && passwordCheckSkip) {

            accountArrayList.remove(account);
            new BaseDAO<Account>().delete(account);
//            doHibernateSaveOrUpdate();
            logger.debug("Account deleted" + email);
            return true;
        }
        logger.debug("Account deleted fail:" + email);
        return false;
    }

    public boolean checkPassword(String email, String password) {
        getAccountIfExisted(email);
        if (!isNull(account) && password != null) {
            if (account.getPassword().equals(password)) {
                passwordCheckSkip = true;
                doHibernateSaveOrUpdate();
                return true;
            }
        }
        return false;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader(" x-forwarded-for ");
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" WL-Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static List<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public static void setAccountArrayList(List<Account> accountArrayList) {
        AccountService.accountArrayList = accountArrayList;
    }

    public void doHibernateSaveOrUpdate() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        accountArrayList.forEach(session::saveOrUpdate);
        session.getTransaction().commit();
        logger.debug("Hibernate Once!");
        session.close();
    }

    public boolean isAccountLoadSkip() {
        return accountLoadSkip;
    }

    public void setAccountLoadSkip(boolean accountLoadSkip) {
        this.accountLoadSkip = accountLoadSkip;
    }

    public boolean isPasswordCheckSkip() {
        return passwordCheckSkip;
    }

    public void setPasswordCheckSkip(boolean passwordCheckSkip) {
        this.passwordCheckSkip = passwordCheckSkip;
    }



}
