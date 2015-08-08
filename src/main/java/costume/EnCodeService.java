package costume;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import util.NumFormatter;
import util.hibernate.HibernateSessionFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class EnCodeService {
    //00000000030null
    private static Logger logger = Logger.getLogger(EnCodeService.class);

    public Map<String, String> getBinaryPropertyMap(String property, String entity) {
        Map<String, String> map = new HashMap<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            String hql = "select c." + property + " from " + entity + " c";
            List<String> temp = session.createQuery(hql).list();
            Iterator<String> iterator = temp.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals("")) {
                    iterator.remove();
                }
            }
            for (int j = 0; j < temp.size(); j++) {
                map.put(NumFormatter.addZeroForNum(Integer.toBinaryString(j),
                        Integer.toBinaryString(temp.size()).length()), temp.get(j));
            }
            logger.debug(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return map;
        }
    }

    public Map<String, String> getPropertyBinaryMap(String property, String entity) {
        Map<String, String> map = new HashMap<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            String hql = "select c." + property + " from " + entity + " c";
            List<String> temp = session.createQuery(hql).list();
            Iterator<String> iterator = temp.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals("")) {
                    iterator.remove();
                }
            }
            for (int j = 0; j < temp.size(); j++) {
                map.put(temp.get(j), NumFormatter.addZeroForNum(Integer.toBinaryString(j),
                        Integer.toBinaryString(temp.size()).length()));
            }
            logger.debug(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            return map;
        }
    }

    public String getPropertyBinary(String property, String entity, String key) {
        //可以优化
        Map<String, String> map = new HashMap<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        try {
            String hql = "select c." + property + " from " + entity + " c";
            List<String> temp = session.createQuery(hql).list();
            Iterator<String> iterator = temp.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals("")) {
                    iterator.remove();
                }
            }
            for (int j = 0; j < temp.size(); j++) {
                map.put(temp.get(j), NumFormatter.addZeroForNum(Integer.toBinaryString(j),
                        Integer.toBinaryString(temp.size()).length()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            logger.debug("Get binary-code of " + key);
            return map.get(key);
        }
    }


}
