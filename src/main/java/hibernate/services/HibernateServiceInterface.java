package hibernate.services;

import org.hibernate.Session;
import util.hibernate.HibernateSessionFactory;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public interface HibernateServiceInterface {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    public default boolean doHibernate() {
        try {
            session.beginTransaction();
            hibernateHook(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return false;
        } finally {
            session.close();
            return true;
        }
    }
    public void hibernateHook(Session session);
}
