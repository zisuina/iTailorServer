package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class GroupTest {
    @Test
    public void testHibernate() {
        Group group = new Group();
        AccessControl accessControl = new AccessControl(true, true);
        Account account = new Account("liker.xu@foxmail.com", "888888");
        group.getAccountList().add(account);
        group.setAccessControl(accessControl);
        new BaseDAO<Group>().create(group);
    }

}