package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ShareItemTest {
    @Test
    public void testHibernate() {
        ShareItem shareItem = new ShareItem();
        Account account = new Account("liker.xu@foxmail.com","88888888888888");
        Account account2 = new Account("liker.xu@foxmail.com","666666666666");
        Comment comment = new Comment("Hello",account);
        Comment comment2 = new Comment("World",account2);
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setIp("192.168.0.108");
        loginRecord.setUDID("4567654345677654456");
        account.getLoginRecords().add(loginRecord);
        shareItem.getComments().add(comment);
        shareItem.getComments().add(comment2);
        new BaseDAO<ShareItem>().create(shareItem);
    }

}