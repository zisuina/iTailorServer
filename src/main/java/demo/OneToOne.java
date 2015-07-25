package demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

/**
 * Created by liker on 14/07/2015 0014.
 * Group iTailor.hunters.neu.edu.cn
 */
public class OneToOne {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSession();
        Transaction trans = session.beginTransaction();
        Manager manager = new Manager();
        manager.setName("liker");
        Department department = new Department();
        department.setName("world");
        department.setManager(manager);
        manager.setDepartment(department);
        session.persist(department);
        session.persist(manager);
        trans.commit();
        session.close();
        System.exit(-1);
    }
}
