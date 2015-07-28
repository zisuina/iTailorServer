package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountTest {
//    @Test
//    public void testHibernate() {
//        Account account = new Account("liker.xu@foxmail.com", "liker12134");
//        LoginRecord loginRecord = new LoginRecord();
//        loginRecord.setIp("192.168.0.108");
//        loginRecord.setUDID("4567654345677654456");
//        account.getLoginRecords().add(loginRecord);
//        new BaseDAO<Account>().create(account);
//    }
//    @Test
//    public void testHibernateBasic() {
//        Account account = new Account("liker.xu@foxmail.com", "liker12134");
//        new BaseDAO<Account>().create(account);
//    }
    @Test
    public void testHibernateSuper() {
        Account account = new Account("liker.xu@foxmail.com", "liker12134");
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setIp("192.168.0.108");
        loginRecord.setUDID("4567654345677654456");
        account.getLoginRecords().add(loginRecord);
        Message message = new Message();
        message.setContext("this is just a message");
        account.getMessageList().add(message);
        ShareItem shareItem = new ShareItem();
        Comment comment = new Comment();
        comment.setContext("this is a comment message.");
        comment.setThumbNum(10);
        shareItem.getComments().add(comment);
        account.getShareItems().add(shareItem);
        AccessControl accessControl = new AccessControl(true,false);
        Group group = new Group();
        group.setAccessControl(accessControl);
        Account account2 = new Account("thea.zhu@foxmail.com", "thea12134");
        group.getAccountList().add(account2);
        account.getGroups().add(group);
        Feedback feedback = new Feedback();
        feedback.setContext("this is a feedback message.");
        feedback.setAccepted(true);
        account.getFeedbacks().add(feedback);
        Feedback feedback2 = new Feedback();
        feedback2.setContext("this is an unaccepted feedback message.");
        feedback2.setAccepted(false);
        account.getFeedbacks().add(feedback2);
        new BaseDAO<Account>().create(account);
    }

}