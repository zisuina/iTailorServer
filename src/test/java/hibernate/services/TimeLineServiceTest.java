package hibernate.services;

import hibernate.community.AccessControl;
import hibernate.community.Account;
import hibernate.community.Group;
import org.junit.Before;
import org.junit.Test;
import resource.service.TimeLineService;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by liker on 03/08/2015 0003.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TimeLineServiceTest {
    TimeLineService timeLineService;
    AccessControl accessControl;
    AccessControl accessControl2;
    Account account;
    Group rootGroup;
    Group group;
    Account addedAccount;
    Account addedAccount2;
    Account addedAccount3;

    @Before
    public void setUp() throws Exception {
        account = new Account();
        account.setEmail("liker.xu@foxmial.com");
        timeLineService = new TimeLineService(account);
        addedAccount = new Account();
        addedAccount.setEmail("thea.zhu@foxmial.com");
        addedAccount2 = new Account();
        addedAccount2.setEmail("thea2.zhu@foxmial.com");
        addedAccount3 = new Account();
        addedAccount3.setEmail("thea3.zhu@foxmial.com");
        accessControl = new AccessControl(1, false, true);
        accessControl2 = new AccessControl(2, true, false);
        rootGroup = new Group();
        group = new Group();
        account.setRootGroup(rootGroup);
        account.getGroups().add(group);
        group.setAccessControl(accessControl2);
        rootGroup.setAccessControl(accessControl);
        rootGroup.getAccountList().add(addedAccount);
        group.getAccountList().add(addedAccount2);
        group.getAccountList().add(addedAccount3);
    }


    @Test
    public void testGetSendAccountList() throws Exception {
        List<Account> result = timeLineService.getSendAccountList();
        assertTrue(result.contains(addedAccount));
        assertFalse(result.contains(addedAccount2));
        assertFalse(result.contains(addedAccount3));
    }


    @Test
    public void testGetReceiveAccountList() throws Exception {
        List<Account> result = timeLineService.getReceiveAccountList();
        assertFalse(result.contains(addedAccount));
        assertTrue(result.contains(addedAccount2));
        assertTrue(result.contains(addedAccount3));
    }


    @Test
    public void testIsPushAccepted() throws Exception {
        Group group = new Group();
        group.getAccountList().add(account);
        AccessControl accessControl3 = new AccessControl(3, true, true);
        group.setAccessControl(accessControl3);
        addedAccount.setRootGroup(group);
        assertTrue(timeLineService.isPushAccepted(account, addedAccount));
        group.getAccessControl().setReceive(false);
        assertFalse(timeLineService.isPushAccepted(account, addedAccount));
    }


}