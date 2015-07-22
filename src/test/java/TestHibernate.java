import bean.Dog;
import bean.Image;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate.HibernateSessionFactory;

import java.util.List;
import java.util.Map;

public class TestHibernate {

    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSession();
        Transaction trans = session.beginTransaction();
        Dog dog = new Dog("New thealand.");
        Dog dog2 = new Dog("Amercian");
        Image image = new Image("123.jpg");
        dog.show();
        session.persist(dog);
        session.persist(dog2);
        session.persist(image);

        Query query = session.createQuery(" select d from Dog as d ");
        List<Dog> dogList = query.list();
        for (Dog d : dogList) {
            System.out.println(d.show());
        }

        List<String> nameList1 = session.createQuery("select c.name from Dog as c").list();
        for (String d : nameList1) {
            System.out.println(d);
        }
        List<Object[]> nameList2 = session.createQuery("select c.id,c.name from Dog as c").list();
        for (Object[] d : nameList2) {
            for (Object str : d) {
                System.out.println(" " + str);
            }
        }
        System.out.println("-----------------------------------------");
        List listMap = session.createQuery(" select " +
                "new map(c.name as name,c.id as id) from Dog c ").list();
        for (Map map : (List<Map>) listMap) {
            System.out.println(map.get("id"));
            System.out.println(map.get("name"));
        }
        System.out.println("-----------------------------------------");
        List<Dog> dogList3 = session.createQuery("select new Dog(c.name) from Dog c").list();
        for (Dog d : dogList) {
            System.out.println(d.show());
        }
        System.out.println("-----------------------------------------");
        SQLQuery sqlQuery = session.createSQLQuery("show variables");
        List<Object[]> list = sqlQuery.list();
        for (Object[] obj : list) {
            System.out.println(obj[0] + " , " + obj[1] + " , ");
        }
        System.out.println("-----------------------------------------");
        sqlQuery = session.createSQLQuery("SELECT * from dog");
        sqlQuery.addEntity(Dog.class);
        List<Dog> dogList4 = sqlQuery.list();
        for (Dog d : dogList4) {
            System.out.println(d.show());
        }
        System.out.println("-----------------------------------------");
        query = session.getNamedQuery("dog by name").setParameter("name","Amercian");
        List<Dog> dogList5 = query.list();
        for (Dog d : dogList5) {
            System.out.println(d.show());
        }
//        query = session.createQuery(" select count(name) from Dog d ");
//        Number dd = (Number)query.uniqueResult();
//        System.out.println("select count(c) from Dog d :"+dd.toString());
        trans.commit();
        session.close();
        System.exit(-1);
    }

}