package resource.user;

import hibernate.community.Account;
import org.junit.Before;
import org.junit.Test;
import util.BaseDAO;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 04/08/2015 0004.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountNewServiceTest {
    AccountNewService accountNewService;

    @Before
    public void setUp() throws Exception {
        accountNewService = new AccountNewService();
        accountNewService.reportStatus();
    }

    @Test
    public void testComeBackFromDB() throws Exception {
        List<Account> one = new BaseDAO<Account>().list("select a from Account as a");
        int i = accountNewService.getAccountArrayList().size();
        accountNewService.comeBackFromDB();
        int j = accountNewService.getAccountArrayList().size();
        assertEquals(i + one.size(), j);
    }

    @Test
    public void testSettleIntoDB() throws Exception {
        List<Account> one = new BaseDAO<Account>().list("select a from Account as a");
        Account account = new Account("likw432er.xu@foxmail.com", "888");
        boolean flag = true;
        for (Account ref : one) {
            if (ref.getEmail().equals(account.getEmail())) {
                flag = false;
            }
        }
        if (flag) {
            accountNewService.getAccountArrayList().add(account);
            accountNewService.settleIntoDB();
            List<Account> two = new BaseDAO<Account>().list("select a from Account as a");
            assertEquals(one.size() + 1, two.size());
        } else {
            accountNewService.settleIntoDB();
            List<Account> two = new BaseDAO<Account>().list("select a from Account as a");
            assertEquals(one.size(), two.size());
        }
    }

    @Test
    public void testRegisterAccountForWellFormattedEmail() throws Exception {
        accountNewService.comeBackFromDB();
        accountNewService.registerAccountForWellFormattedEmail("li553ker.xu@foxmail.com", "83888");
        accountNewService.settleIntoDB();
        accountNewService.reportStatus();
    }

}