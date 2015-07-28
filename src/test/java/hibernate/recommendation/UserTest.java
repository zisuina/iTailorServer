package hibernate.recommendation;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 28/07/2015 0028.
 * Group iTailor.hunters.neu.edu.cn
 */
public class UserTest {
    @Test
    public void testUserHibernateBasic() {
        new BaseDAO<User>().create(new User());
        new BaseDAO<User>().create(new User("liker"));
    }
}