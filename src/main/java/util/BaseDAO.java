package util;

import org.hibernate.Query;
import org.hibernate.Session;
import util.hibernate.HibernateSessionFactory;
import java.io.Serializable;
import java.util.List;

public class BaseDAO<T> {
    public boolean isExist(T object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            System.out.println("@@@@@@@@@@@@@");
            Query query = session.createQuery(" select t from " + object.getClass().getName() + " as t ");
            List<T> objectList = query.list();
            System.out.println("SIZE:::"+objectList.size());
            if (objectList.contains(object)) {
                System.out.println("$$$$$$$$$$$$$");
                session.getTransaction().commit();
                session.close();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public void create(T object) {

        Session session =  HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void update(T object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void delete(T object) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    //	@SuppressWarnings("unchecked")
    public T find(Class<? extends T> clazz, Serializable id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            return (T) session.get(clazz, id);
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    //	@SuppressWarnings("unchecked")
    public List<T> list(String hql) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            return session.createQuery(hql).list();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}
