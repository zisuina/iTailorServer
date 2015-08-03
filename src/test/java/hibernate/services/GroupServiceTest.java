package hibernate.services;

import hibernate.community.Account;
import hibernate.community.Group;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 03/08/2015 0003.
 * Group iTailor.hunters.neu.edu.cn
 */
public class GroupServiceTest {
    GroupService groupService;
    Account account;
    Group rootGroup;
    Group addedGroup;
    Account addedAccount;

    @Before
    public void setUp() throws Exception {
        groupService = new GroupService();
        account = new Account();
        rootGroup = new Group("root");
        addedGroup = new Group("friends");
        addedAccount = new Account();
        rootGroup.getAccountList().add(addedAccount);
        addedGroup.getAccountList().add(addedAccount);
        account.setRootGroup(rootGroup);
        account.getGroups().add(addedGroup);
    }


    @Test
    public void testGetUniqueAccountsFor() throws Exception {
        List<Account> result = groupService.getUniqueAccountsFor(account);
        assertEquals(1, result.size());
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        result = groupService.getUniqueAccountsFor(account);
        assertEquals(1, result.size());
//        result = groupService.getUniqueAccountsFor(account);
        assertEquals(5, account.getRootGroup().getAccountList().size());
    }

    @Test
    public void testDeleteGroupFromAccount() throws Exception {
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        account.getRootGroup().getAccountList().add(addedAccount);
        List<Account> result = groupService.getUniqueAccountsFor(account.getRootGroup());
        assertEquals(1, result.size());
    }

    @Test
    public void testGetUniqueAccountsFor1() throws Exception {

    }
}