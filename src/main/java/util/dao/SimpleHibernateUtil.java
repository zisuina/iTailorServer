package util.dao;

import hibernate.community.Account;
import hibernate.community.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SimpleHibernateUtil {

	private static final SessionFactory sessionFactory;
	private static String configFile = "/hibernate.cfg.xml";
	private static Configuration configuration = new Configuration();
	static {
		try {
			configuration.configure(configFile);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		Session session = getSessionFactory().getCurrentSession();
		session.flush();
		session.beginTransaction();
		session.save(new Message("hello",new Account("liker.xu@foxmail.com","6666")));
		session.getTransaction().commit();
	}

}