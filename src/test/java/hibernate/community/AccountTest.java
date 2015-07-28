package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountTest {
    @Test
    public void testHibernate() {
        Account account = new Account("liker.xu@foxmail.com", "liker12134");
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setIp("192.168.0.108");
        loginRecord.setUDID("4567654345677654456");
        account.getLoginRecords().add(loginRecord);
        new BaseDAO<Account>().create(account);
    }
    @Test
    public void testHibernateBasic() {
        Account account = new Account("liker.xu@foxmail.com", "liker12134");
        new BaseDAO<Account>().create(account);
    }
    @Test
    public void testHibernateFinal() {
        AccessControl accessControl = new AccessControl(false,false);

        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setIp("192.168.0.108");
        loginRecord.setUDID("4567654345677654456");

        Account account = new Account("liker.xu@foxmail.com","66666");
        Account account2 = new Account("thea.zhu@foxmail.com","88888");

        account.getLoginRecords().add(loginRecord);

        Group group = new Group();
        group.setAccessControl(accessControl);
        group.getAccountList().add(account2);
        account.getGroups().add(group);

        TimeLine timeLine = new TimeLine();
        account.setTimeLine(timeLine);

        ShareItem shareItem = new ShareItem();
        account.getShareItems().add(shareItem);

        timeLine.getShareItems().add(shareItem);

        Message message = new Message("message",account2);
        account.getMessageList().add(message);

        Comment comment = new Comment("comment",account);
        shareItem.getComments().add(comment);

        Feedback feedback = new Feedback("feedback",account2);
        account.getFeedbacks().add(feedback);

        new BaseDAO<Account>().create(account);

    }

}