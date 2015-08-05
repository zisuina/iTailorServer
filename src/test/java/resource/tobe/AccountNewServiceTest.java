package resource.tobe;

import hibernate.community.Account;
import org.junit.Before;
import org.junit.Test;
import resource.service.AccountNewService;
import util.BaseDAO;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

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
        Account account = new Account("thea.zhu@foxmail.com", "888");
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

    @Test
    public void testGetAllEmailsInDB() throws Exception {
        accountNewService.comeBackFromDB();
        Account account = new Account("thea2.zhu@foxmail.com", "888");
        accountNewService.getAccountArrayList().add(account);
        accountNewService.settleIntoDB();
        List<String> emails = accountNewService.getAllEmailsInDB();
        assertTrue(emails.contains("thea2.zhu@foxmail.com"));
        emails.forEach(System.out::println);
    }
}