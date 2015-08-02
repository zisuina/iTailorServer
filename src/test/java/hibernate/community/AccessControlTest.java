package hibernate.community;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.hibernate.HibernateSessionFactory;

import java.util.List;
import static junit.framework.TestCase.assertEquals;


/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccessControlTest {
    AccessControl accessControl;
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    List<AccessControl> accessControls;

    @Before
    public void setUp() throws Exception {
        accessControl = new AccessControl();
        session.beginTransaction();
    }

    @Test
    public void testAccessControlConstructor() {
        new AccessControl();
    }

    @Test
    public void testSetReceive() throws Exception {
        accessControl.setReceive(true);
        assertEquals(true, accessControl.isReceive());
        accessControl.setReceive(false);
        assertEquals(false, accessControl.isReceive());
    }

    @Test
    public void testSetSend() throws Exception {
        accessControl.setSend(true);
        assertEquals(true, accessControl.isSend());
        accessControl.setSend(false);
        assertEquals(false, accessControl.isSend());
    }

    @Test
    public void testGetControlID() throws Exception {
        assertEquals(0, accessControl.getControlID());
        session.persist(accessControl);
        assertEquals(0, accessControl.getControlID());
    }

    @Test
    public void testSetControlID() throws Exception {
        accessControl.setControlID(100);
        session.persist(accessControl);
        assertEquals(100, accessControl.getControlID());
    }

    @After
    public void tearDown() throws Exception {
        session.getTransaction().rollback();
        session.close();
    }
}