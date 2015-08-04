//package hibernate.services;
//
//import hibernate.community.Account;
//import org.junit.Before;
//import org.junit.Test;
//import util.BaseDAO;
//
//import static junit.framework.TestCase.*;
//
///**
// * Created by liker on 01/08/2015 0001.
// * Group iTailor.hunters.neu.edu.cn
// */
//public class AccountServiceTest {
//    AccountService accountService;
//
//    @Before
//    public void setUp() throws Exception {
//        accountService = new AccountService();
//
//    }
//
//    @Test
//    public void testRegisterANewAccount() throws Exception {
//        accountService.registerANewAccount("liker.xu@foxmail.com", "666666");
//        accountService.registerANewAccount("thea.zhu@gmail.com", "666666");
//        assertEquals(2, new BaseDAO<Account>().list("select a from Account as a").size());
//    }
//
//    @Test
//    public void testGetAccountByEmail() throws Exception {
//        accountService.registerANewAccount("liker.xu@foxmail.com", "666666");
////        Account account = accountService.getAccountByEmail("liker.xu@foxmail.com");
////        assertEquals("liker.xu@foxmail.com", account.getEmail());
//    }
//
//    @Test
//    public void testIsAccountAlreadyExisted() throws Exception {
//        accountService.registerANewAccount("liker.xu@foxmail.com", "666666");
////        assertTrue(accountService.isAccountAlreadyExisted("liker.xu@foxmail.com"));
//
//    }
//
//    @Test
//    public void testLoginAccountByEmail() throws Exception {
//        accountService.registerANewAccount("liker.xu@foxmail.com", "666666");
//        accountService.loginAccountByEmail("liker.xu@foxmail.com");
////        assertTrue(accountService.getAccountByEmail("liker.xu@foxmail.com").isLogIn());
//    }
//
//    @Test
//    public void testLogoutAccountByEmail() throws Exception {
//        accountService.registerANewAccount("liker.xu@foxmail.com", "666666");
////        assertTrue(accountService.getAccountByEmail("liker.xu@foxmail.com").isLogIn());
//        accountService.loginAccountByEmail("liker.xu@foxmail.com");
//        accountService.logoutAccountByEmail("liker.xu@foxmail.com");
////        assertFalse(accountService.getAccountByEmail("liker.xu@foxmail.com").isLogIn());
//    }
//
//    @Test
//    public void testIsEmailWellFormatted() throws Exception {
//        assertTrue(accountService.isEmailWellFormatted("liker.xu@foxmail.com"));
//        assertFalse(accountService.isEmailWellFormatted(""));
//        assertFalse(accountService.isEmailWellFormatted(null));
//
//
//    }
//
//    @Test
//    public void testIsAccountExisted() throws Exception {
//        accountService.registerANewAccount("liker.xu@foxmail.com", "666666");
////        assertEquals("liker.xu@foxmail.com", accountService.getAccountIfExisted("liker.xu@foxmail.com").getEmail());
//    }
//
//    @Test
//    public void testIsNull() throws Exception {
//        assertTrue(accountService.isNull(null));
//        assertFalse(accountService.isNull(""));
//        assertFalse(accountService.isNull(new Account("liker.xu@foxmail.com", "888888")));
////        List list = new BaseDAO<Color>().list("select a from Color as a");
////        System.out.println(list == null);
//    }
//
//
//    @Test
//    public void testDoHibernate() throws Exception {
//        accountService.doHibernateSaveOrUpdate();
//        int before = new BaseDAO<Account>().list("select a from Account as a").size();
//        accountService.registerANewAccount("thea4.zhu@foxmail.com", "555555");
//        System.out.println("BEFORE:" + accountService.getAccountArrayList().size());
//        accountService.doHibernateSaveOrUpdate();
//        System.out.println("AFTER:" + accountService.getAccountArrayList().size());
//        int after = new BaseDAO<Account>().list("select a from Account as a").size();
//        assertEquals(1, after - before);
//    }
//}