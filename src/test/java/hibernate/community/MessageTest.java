package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class MessageTest {
    @Test
    public void testHibernateToSaveSender(){

//        SimpleHibernateUtil simpleHibernateUtil = new SimpleHibernateUtil();

        Account account = new Account();
        account.setEmail("liker.xu@foxmail.com");
        Message message = new Message("hello world",account);
        BaseDAO<Message> dao = new BaseDAO<>();
        dao.create(message);

    }

}