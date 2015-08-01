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
    static Logger logger = Logger.getLogger(AccountService.class);
    static List<Account> accountArrayList = new BaseDAO<Account>().list("select a from Account as a");
    Account account = null;
    String email = "";

    public AccountService(String email) {
        this.email = email;
        this.account = getAccountByEmail(email);
    }

    public AccountService() {
    }

    public static boolean isEmailWellFormatted(String email) {
        return EmailVerification.isValid(email);
    }

    public static Account isAccountExisted(String email) {
        if (isEmailWellFormatted(email)) {
            for (Account account : accountArrayList) {
                if (account.getEmail().equals(email)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean registerANewAccount(String email, String password) {
        if (isEmailWellFormatted(email)) {
            if (isAccountExisted(email) == null) {
                accountArrayList.add(new Account(email, password == null ? "" : password));
                logger.debug("Create a new account:" + email);
                return true;
            }
        }
        return false;
    }

    public static Account getAccountByEmail(String email) {
        if (isEmailWellFormatted(email)) {
            for (Account temp : accountArrayList) {
                if (temp.getEmail().equals(email)) {
                    logger.debug("Get the reference of account:" + email);
                    return temp;
                }
            }
        }
        return null;
    }

    public boolean loginAccountByEmail(String email) {
        account = isAccountExisted(email);
        if (!isNull(account)) {
            account.setLogIn(true);
            new BaseDAO<Account>().update(account);
            logger.debug("Login account:" + email);
            return true;
        }
        return false;
    }

    public void logoutAccountByEmail(String email) {
        account = isAccountExisted(email);
        if (account != null) {
            account.setLogIn(false);
            logger.debug("Logout account:" + email);
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void doHibernate() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        accountArrayList.forEach(session::saveOrUpdate);
        session.getTransaction().commit();
        session.close();
    }


}
