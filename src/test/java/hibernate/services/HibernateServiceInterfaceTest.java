package hibernate.services;

import hibernate.community.AccessControl;
import org.hibernate.Session;
import org.junit.Test;
import util.hibernate.HibernateSessionFactory;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class HibernateServiceInterfaceTest {
    class OneService {
        AccessControl[] accessControls = {
                new AccessControl(1, true, true),
                new AccessControl(2, true, false),
                new AccessControl(3, false, true),
                new AccessControl(4, false, false)
        };

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        HibernateServiceInterface hibernateServiceInterface = (session) -> {
            session.createSQLQuery("delete from access_control");
            for (int i = 0; i < accessControls.length; i++) {
                session.persist(accessControls[i]);
            }
        };
    }

    @Test
    public void test() {
        OneService one2Service = new OneService();
        one2Service.hibernateServiceInterface.doHibernate();
    }
}