package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class FeedbackTest {
    @Test
    public void testHibernate() {
        new BaseDAO<Feedback>().create(new Feedback());
    }
}