package hibernate.services;

import hibernate.community.*;
import org.junit.Before;
import org.junit.Test;
import resource.service.TimeLineService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by liker on 03/08/2015 0003.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ShareItemServiceTest {
    TimeLineService timeLineService;
    ShareItemService shareItemService;
    AccessControl accessControl;
    AccessControl accessControl3;
    Account account;
    Group rootGroup;
    Group group;
    Group group2;
    Account addedAccount;
    ShareItem shareItem;
    TimeLine timeLine;
    TimeLine timeLine2;


    @Before
    public void setUp() throws Exception {
        account = new Account();
        account.setEmail("liker.xu@foxmial.com");
        timeLineService = new TimeLineService(account);
        addedAccount = new Account();
        addedAccount.setEmail("thea.zhu@foxmial.com");
        accessControl = new AccessControl(1, false, true);
        rootGroup = new Group();
        account.setRootGroup(rootGroup);
        rootGroup.setAccessControl(accessControl);
        rootGroup.getAccountList().add(addedAccount);

        timeLine = new TimeLine();
        timeLine2 = new TimeLine();

        group2 = new Group();
        group2.getAccountList().add(account);
        accessControl3 = new AccessControl(3, true, true);
        group2.setAccessControl(accessControl3);
        addedAccount.setRootGroup(group2);
        shareItemService = new ShareItemService();
        shareItem = new ShareItem();
        account.setTimeLine(timeLine);
        addedAccount.setTimeLine(timeLine2);
    }

    @Test
    public void testPushShareItem() throws Exception {
        shareItemService.pushShareItem(account, shareItem);
        assertTrue(addedAccount.getTimeLine().getShareItems().contains(shareItem));
        assertTrue(account.getTimeLine().getShareItems().contains(shareItem));
    }

    @Test
    public void testPushShareItemInclude() throws Exception {
        List<Account> accounts = new ArrayList<>();
        Account account2 = new Account();
        Group group3 = new Group();
        TimeLine timeLine = new TimeLine();
        account2.setRootGroup(group3);
        AccessControl accessControl = new AccessControl(4, true, true);
        group3.setAccessControl(accessControl);
        group3.getAccountList().add(account);
        group3.getAccountList().add(addedAccount);
        account2.setTimeLine(timeLine);

        accounts.add(account2);

        account.getRootGroup().getAccountList().add(account2);
        account.getRootGroup().getAccessControl().setSend(false);

        shareItemService.pushShareItemInclude(account, shareItem, accounts);

        assertFalse(timeLineService.isPushAccepted(account, account2));
        assertTrue(account2.getTimeLine().getShareItems().contains(shareItem));
        assertTrue(account.getTimeLine().getShareItems().contains(shareItem));
    }

    @Test
    public void testPushShareItemExcept() throws Exception {
        List<Account> accounts = new ArrayList<>();
        Account account2 = new Account();
        Group group3 = new Group();
        TimeLine timeLine = new TimeLine();
        account2.setRootGroup(group3);
        AccessControl accessControl = new AccessControl(4, true, true);
        group3.setAccessControl(accessControl);
        group3.getAccountList().add(account);
        group3.getAccountList().add(addedAccount);
        account2.setTimeLine(timeLine);

        accounts.add(account2);

        account.getRootGroup().getAccountList().add(account2);
        account.getRootGroup().getAccessControl().setSend(true);
        shareItemService.pushShareItemExcept(account, shareItem, accounts);

        assertTrue(timeLineService.isPushAccepted(account, account2));
        assertFalse(account2.getTimeLine().getShareItems().contains(shareItem));
        assertTrue(account.getTimeLine().getShareItems().contains(shareItem));
    }
}