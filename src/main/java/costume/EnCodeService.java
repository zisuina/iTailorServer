package costume;

import org.hibernate.Session;
import util.hibernate.HibernateSessionFactory;

import java.util.Iterator;
import java.util.List;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class EnCodeService {
    public static void main(String[] args) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
//            session.beginTransaction();
            List<String> coat_buttons = session.createQuery("select c.button from Coat c").list();
            Iterator<String> iterator = coat_buttons.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals("")) {
                    iterator.remove();
                }
            }
            System.out.println("Size:" + coat_buttons.size());
//            session.getTransaction().commit();
        } catch (Exception e) {
//            session.getTransaction().rollback();
        } finally {
            session.close();
        }


    }
}
