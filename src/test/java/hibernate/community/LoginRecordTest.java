package hibernate.community;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 28/07/2015 0028.
 * Group iTailor.hunters.neu.edu.cn
 */
public class LoginRecordTest {
    @Test
    public void testHibernate() {
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setIp("192.168.0.108");
        loginRecord.setUDID("4567654345677654456");
        new BaseDAO<LoginRecord>().create(loginRecord);
    }

}