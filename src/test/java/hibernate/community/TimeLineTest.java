package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 28/07/2015 0028.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TimeLineTest {
    @Test
    public void testTimeLineHibernate() {
        TimeLine timeLine = new TimeLine();
        ShareItem shareItem = new ShareItem();
        Comment comment = new Comment();
        Account account = new Account("liker.xu@foxmail.com","88888");
        account.getShareItems().add(shareItem);
        comment.setSenderAccount(account);
        comment.setThumbNum(10);
        comment.setContext("hello world");
        shareItem.getComments().add(comment);
        timeLine.getShareItems().add(shareItem);
        new BaseDAO<TimeLine>().create(timeLine);
    }

}