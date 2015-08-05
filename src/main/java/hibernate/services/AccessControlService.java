package hibernate.services;

import hibernate.community.AccessControl;
import org.hibernate.Session;
import util.BaseDAO;
import util.hibernate.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccessControlService {
    private AccessControl[] accessControls = {
            new AccessControl(1, true, true),
            new AccessControl(2, true, false),
            new AccessControl(3, false, true),
            new AccessControl(4, false, false)
    };

    private List<AccessControl> accessControlList = new ArrayList<>();

    public void comeBackFromDB() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.createSQLQuery("delete from access_control").executeUpdate();
        for (int i = 0; i < accessControls.length; i++) {
            session.persist(accessControls[i]);
        }
    }


    public void settleIntoDB() {
        List<AccessControl> accesss =
                new BaseDAO<AccessControl>().list("select ac from AccessControl as ac");
        if (accesss.size() == 0) {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                for (int i = 0; i < accessControls.length; i++) {
                    session.persist(accessControls[i]);
                }
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            } finally {
                session.close();
            }
        }

    }

    public AccessControl getSpecificAccessControl(boolean receive, boolean send) {
        for (AccessControl accessControl : accessControls) {
            if (accessControl.isSend() == send && accessControl.isReceive() == receive) {
                return accessControl;
            }
        }
        return null;
    }

}
