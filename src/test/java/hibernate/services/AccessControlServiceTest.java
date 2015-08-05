package hibernate.services;

import hibernate.community.AccessControl;
import org.junit.Before;
import org.junit.Test;
import util.BaseDAO;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccessControlServiceTest {
    AccessControlService accessControlService = null;

    @Before
    public void setUp() throws Exception {
        accessControlService = new AccessControlService();
    }

    @Test
    public void testSettleIntoDB() throws Exception {
        accessControlService.settleIntoDB();
        assertEquals(4, new BaseDAO<AccessControl>().list("select ac from AccessControl as ac").size());
    }

    @Test
    public void testGetSpecificAccessControl() throws Exception {
        assertEquals(1, accessControlService.getSpecificAccessControl(true, true).getControlID());
        assertEquals(2, accessControlService.getSpecificAccessControl(true, false).getControlID());
        assertEquals(3, accessControlService.getSpecificAccessControl(false, true).getControlID());
        assertEquals(4, accessControlService.getSpecificAccessControl(false, false).getControlID());

    }


}