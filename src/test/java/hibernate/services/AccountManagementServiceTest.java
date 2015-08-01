package hibernate.services;

import hibernate.community.Account;
import org.junit.Before;
import org.junit.Test;
import util.BaseDAO;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountManagementServiceTest {
    AccountManagementService accountManagementService;

    @Before
    public void setUp() throws Exception {
        accountManagementService = new AccountManagementService();

    }

    @Test
    public void testRegisterANewAccount() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        accountManagementService.registerANewAccount("thea.zhu@gmail.com", "666666");
        assertEquals(2, new BaseDAO<Account>().list("select a from Account as a").size());
    }

    @Test
    public void testGetAccountByEmail() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        Account account = accountManagementService.getAccountByEmail("liker.xu@foxmail.com");
        assertEquals("liker.xu@foxmail.com", account.getEmail());
    }

    @Test
    public void testIsAccountAlreadyExisted() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        assertTrue(accountManagementService.isAccountAlreadyExisted("liker.xu@foxmail.com"));

    }

    @Test
    public void testLoginAccountByEmail() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        accountManagementService.loginAccountByEmail("liker.xu@foxmail.com");
        assertTrue(accountManagementService.getAccountByEmail("liker.xu@foxmail.com").isLogIn());
    }

    @Test
    public void testLogoutAccountByEmail() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        assertTrue(accountManagementService.getAccountByEmail("liker.xu@foxmail.com").isLogIn());
        accountManagementService.loginAccountByEmail("liker.xu@foxmail.com");
        accountManagementService.logoutAccountByEmail("liker.xu@foxmail.com");
        assertFalse(accountManagementService.getAccountByEmail("liker.xu@foxmail.com").isLogIn());
    }

    @Test
    public void testNewUserForNotNullAccount() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        accountManagementService.newUserForNotNullAccount(
                accountManagementService.getAccountByEmail("liker.xu@foxmail.com"), "my USER data"
        );
        assertEquals("my USER data",
                accountManagementService
                        .getAccountByEmail("liker.xu@foxmail.com")
                        .getUser().getNickname()
        );
    }

    @Test
    public void testNewTimeLineForNotNullAccount() throws Exception {
        accountManagementService.registerANewAccount("liker.xu@foxmail.com", "666666");
        assertNotNull(accountManagementService
                .getAccountByEmail("liker.xu@foxmail.com")
                .getTimeLine());
    }
}