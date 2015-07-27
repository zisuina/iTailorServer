package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class CommentTest {
    @Test
    public void testHibernate() {
        Account account = new Account("liker.xu@foxmail.com","12134");
        new BaseDAO<Message>().create(new Comment("hello",account));
    }

}