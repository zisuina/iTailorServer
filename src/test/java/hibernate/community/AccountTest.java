package hibernate.community;

import org.hibernate.Session;
import org.junit.Test;
import util.hibernate.HibernateSessionFactory;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountTest {
    @Test
    public void testHibernate() {
        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        try {
            Account account = new Account("liker.xu@foxmail.com","liker12134");
            session.beginTransaction();
            session.persist(account);
            System.out.println("FINEEEEEEEEEEEEEEEEEEE");
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

//        new BaseDAO<Account>().create(account);
    }

}