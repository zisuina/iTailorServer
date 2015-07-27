package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccessControlTest {
    @Test
    public void testHibernate() {
        BaseDAO<AccessControl> dao = new BaseDAO<>();
        dao.create(new AccessControl());
        dao.create(new AccessControl(true, false));
        dao.create(new AccessControl(false, false));
        dao.create(new AccessControl(true, true));
        dao.create(new AccessControl(false, false));
        List<AccessControl> accessControlList = dao.list("select t from AccessControl as t");
        assertEquals(5,accessControlList.size());
    }

}