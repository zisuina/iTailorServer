package resource.community;

import hibernate.community.AccessControl;
import hibernate.community.LoginRecord;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import resource.ApplicationConfig;
import resource.json.AccountJson;
import resource.json.GroupJson;
import resource.json.MessageJson;
import resource.json.ShareItemJson;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.List;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 06/08/2015 0006.
 * Group iTailor.hunters.neu.edu.cn
 */
public class AccountResourceTest extends JerseyTest {

    private static final String BASEURI = "/accountS";
    WebTarget queryTarget = null;

    @Override
    protected Application configure() {
        return new ApplicationConfig();
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
//        final URL resource = getClass().getClassLoader().getResource("gua.txt");
//        System.out.println(resource.toString());
//        final String file = resource.getFile();
//        final File f = new File(file);
//        final Invocation.Builder request = target(BASEURI).path("imagesServer").request();
//        Entity<File> e = Entity.entity(f, MediaType.TEXT_PLAIN_TYPE);
//        final Response response = request.post(e, Response.class);
//
//        String result = response.readEntity(String.class);
//        System.out.println(result);
        //        List<RestPm25Item> rsList = result.readEntity(new GenericType<List<RestPm25Item>>(){});
//         RestPm25Item[] rsList = result.readEntity(RestPm25Item[].class);

    }

    @Test
    public void testPostAccount() throws Exception {
        queryTarget = target(BASEURI)
//                .queryParam("email", "liker" + new Random().nextInt() + "@gmail.com");
                .queryParam("email", "liker.text@gmail.com");
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", "pwd4test");
        final Response response = invocationBuilder.post(null);
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testGetAccount() throws Exception {
        queryTarget = target(BASEURI)
                .queryParam("email", "liker.text@gmail.com");
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", "pwd4test");
        final Response response = invocationBuilder.get();
        assertEquals(200, response.getStatus());
        AccountJson accountJson = response.readEntity(AccountJson.class);
        assertEquals("liker.text@gmail.com", accountJson.getEmail());
    }

    @Test
    public void testPutAccount() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson accountJson = accountResource.getAccount("liker.text@gmail.com", "pwd4test");
        queryTarget = target(BASEURI)
                .queryParam("accountID", accountJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", accountJson.getPassword());
        AccountJson accountJson2 = new AccountJson();
        accountJson2.setSync(true);
        accountJson2.setPassword("newPwd4testAgain");
        Entity<AccountJson> e = Entity.entity(accountJson2, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.put(e, Response.class);
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
        //406 not accepted
    }

    @Test
    public void testDeleteAccount() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        queryTarget = target(BASEURI)
                .queryParam("accountID", godJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.delete();
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testPostMessage() throws Exception {
        AccountResource accountResource = new AccountResource();
        accountResource.postAccount("liker.text@gmail.com", "newPwd4testAgain");
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        queryTarget = target(BASEURI + "/messageS")
                .queryParam("accountID", godJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN);
        MessageJson messageJson = new MessageJson();
        messageJson.setContext("2.This is a message 4 test!");
        Entity<MessageJson> e = Entity.entity(messageJson, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.post(e, Response.class);
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testGetMessage() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        queryTarget = target(BASEURI + "/messageS")
                .queryParam("accountID", godJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.get();
        List<MessageJson> rsList = response.readEntity(new GenericType<List<MessageJson>>() {
        });
        assertEquals(1, rsList.size());
        assertEquals(200, response.getStatus());
        //500 内部出错
    }

    @Test
    public void testDeleteMessage() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        MessageJson messageJson = new MessageJson();
        messageJson.setContext("3.This is a message 4 test!");
        accountResource.postMessage(godJson.getAccountID(), messageJson);
        List<MessageJson> messageJsons = accountResource.getMessage(godJson.getAccountID(), "newPwd4testAgain");
        queryTarget = target(BASEURI + "/messageS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("messageID", messageJsons.get(0).getMessageID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.delete();
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testPostGroup() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        queryTarget = target(BASEURI + "/groupS")
                .queryParam("accountID", godJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());

        GroupJson groupJson = new GroupJson();
        groupJson.setGroupName("new group for test!");
        Entity<GroupJson> e = Entity.entity(groupJson, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.post(e, Response.class);

        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testGetGroup() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        GroupJson groupJson = new GroupJson();
        groupJson.setGroupName("3.new group for test!");
        groupJson.setSend(true);
        accountResource.postGroup(godJson.getAccountID(), godJson.getPassword(), groupJson);
        queryTarget = target(BASEURI + "/groupS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("groupName", groupJson.getGroupName());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.get();
        GroupJson res = response.readEntity(GroupJson.class);
        assertEquals(200, response.getStatus());
        assertTrue(res.isSend());
    }

    @Test
    public void testDeleteGroup() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        GroupJson groupJson = new GroupJson();
        groupJson.setGroupName("4.new group for test!");
        groupJson.setSend(true);
        accountResource.postGroup(godJson.getAccountID(), godJson.getPassword(), groupJson);
        GroupJson godGroup = accountResource.getGroup(godJson.getAccountID(), groupJson.getGroupName(), godJson.getPassword());
        queryTarget = target(BASEURI + "/groupS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("groupID", godGroup.getGroupID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.delete();
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testPutGroup() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        GroupJson groupJson = new GroupJson();
        groupJson.setGroupName("newGroupForChanged");
        groupJson.setSend(false);

        GroupJson godGroup = accountResource.getGroup(godJson.getAccountID(), "3.new group for test!", godJson.getPassword());

        queryTarget = target(BASEURI + "/groupS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("groupID", godGroup.getGroupID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());

        Entity<GroupJson> e = Entity.entity(groupJson, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.put(e, Response.class);

        assertEquals(200, response.getStatus());
        GroupJson res = response.readEntity(GroupJson.class);
        assertTrue(!res.isSend());

    }

    @Test
    public void testPostGroupAccount() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        GroupJson godGroup = accountResource.getGroup(godJson.getAccountID(), "newGroupForChanged", godJson.getPassword());

        queryTarget = target(BASEURI + "/groupS/accountS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("groupID", godGroup.getGroupID())
                .queryParam("email", "liker.xu@foxmail.com");
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.post(null);
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
        //500 内部错误
    }

    @Test
    public void testGetGroupAccount() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        AccountJson godJson2 = accountResource.getAccount("liker.xu@foxmail.com", "hellothea");

        queryTarget = target(BASEURI + "/groupS/accountS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("accountID2", godJson2.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());
        final Response response = invocationBuilder.get();
        AccountJson res = response.readEntity(AccountJson.class);
        assertEquals(200, response.getStatus());
        assertEquals("liker.xu@foxmail.com", res.getEmail());
    }

    @Test
    public void testDeleteGroupAccount() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        AccountJson godJson2 = accountResource.getAccount("liker.xu@foxmail.com", "hellothea");

        queryTarget = target(BASEURI + "/groupS/accountS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("accountID2", godJson2.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());

        final Response response = invocationBuilder.delete();
        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));

    }

    @Test
    public void testPutAccessControl() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        GroupJson godGroup = accountResource.getGroup(godJson.getAccountID(), "newGroupForChanged", godJson.getPassword());

        queryTarget = target(BASEURI + "/groupS/accessControl")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("groupID", godGroup.getGroupID());
        AccessControl accessControl = new AccessControl();
        accessControl.setReceive(false);
        accessControl.setSend(false);
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());

        Entity<AccessControl> e = Entity.entity(accessControl, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.put(e, Response.class);

        assertEquals(200, response.getStatus());
        AccessControl res = response.readEntity(AccessControl.class);
        assertTrue(!res.isSend());
        assertTrue(!res.isReceive());
        // 405

    }

    @Test
    public void testGetAccessControl() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        GroupJson godGroup = accountResource.getGroup(godJson.getAccountID(), "newGroupForChanged", godJson.getPassword());

        queryTarget = target(BASEURI + "/groupS/accessControl")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("groupID", godGroup.getGroupID());

        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());

        final Response response = invocationBuilder.get();
        assertEquals(200, response.getStatus());
        AccessControl res = response.readEntity(AccessControl.class);
        assertTrue(!res.isSend());
        assertTrue(!res.isReceive());
    }

//    @Test
//    public void testGetTimeLine() throws Exception {
//
//        AccountResource accountResource = new AccountResource();
//        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
//
//        queryTarget = target(BASEURI + "/groupS/accessControl")
//                .queryParam("accountID", godJson.getAccountID())
//                .queryParam("limit", 1);
//        final Invocation.Builder invocationBuilder
//                = queryTarget.request(MediaType.APPLICATION_JSON)
//                .header("password", godJson.getPassword());
//
//        final Response response = invocationBuilder.get();
//
//        List<ShareItemJson> rsList = response.readEntity(new GenericType<List<ShareItemJson>>() {});
//        assertEquals(0, rsList.size());
//        assertEquals(200, response.getStatus());
//
//    }

    @Test
    public void testDeleteTimelineShareItem() throws Exception {

    }

    @Test
    public void testGetTimeLineShareItems() throws Exception {

    }

    @Test
    public void testPostTimeLineShareItemsComment() throws Exception {

    }

    @Test
    public void testDeleteTimeLineShareItemsComment() throws Exception {

    }

    @Test
    public void testGetTimeLineShareItemsComment() throws Exception {

    }

    @Test
    public void testPostLoginRecords() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/loginRecordS")
                .queryParam("email", godJson.getEmail());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN)
                .header("password", godJson.getPassword());

        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        loginRecord.setUDID("456765434567765");
        loginRecord.setIp("127.0.0.1");

        Entity<LoginRecord> e = Entity.entity(loginRecord, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.post(e, Response.class);

        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testDeleteLoginRecords() throws Exception {

    }

    @Test
    public void testGetLoginRecords() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/loginRecordS")
                .queryParam("email", godJson.getEmail())
                .queryParam("limit", 1);
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());

        final Response response = invocationBuilder.get();

        List<LoginRecord> rsList = response.readEntity(new GenericType<List<LoginRecord>>() {
        });
        if (rsList == null) {
            assertEquals(204, response.getStatus());
        } else {
            assertEquals(200, response.getStatus());
            assertEquals(1, rsList.size());
        }
    }

    @Test
    public void testPostAccounts() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/accountS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("email", "thea.zhu@foxmail.com");

        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN);

        final Response response = invocationBuilder.post(null);

        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testDeleteAccounts() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");
        AccountJson godJson2 = accountResource.getAccount("thea.zhu@foxmail.com", "hellothea");
        accountResource.postAccounts(godJson.getAccountID(), godJson2.getEmail());
        queryTarget = target(BASEURI + "/accountS")
                .queryParam("accountID", godJson.getAccountID())
                .queryParam("accountID2", godJson2.getAccountID());

        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.TEXT_PLAIN);

        final Response response = invocationBuilder.delete();

        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testGetAccounts() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/accountS")
                .queryParam("accountID", godJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.get();

        List<AccountJson> rsList = response.readEntity(new GenericType<List<AccountJson>>() {
        });
        assertEquals(200, response.getStatus());
        assertNotNull(rsList);
    }

    @Test
    public void testPostShareItems() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/shareItemS")
                .queryParam("accountID", godJson.getAccountID());
        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());

        ShareItemJson shareItemJson = new ShareItemJson();
        shareItemJson.setCommentIDs(null);
        shareItemJson.setCreatedTime(new Timestamp(System.currentTimeMillis()));

        Entity<ShareItemJson> e = Entity.entity(shareItemJson, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.post(e, Response.class);

        assertEquals(200, response.getStatus());
        assertTrue(response.readEntity(boolean.class));
    }

    @Test
    public void testDeleteShareItems() throws Exception {

    }

    @Test
    public void testGetShareItems() throws Exception {

    }

    @Test
    public void testPutRootGroup() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/rootGroup")
                .queryParam("accountID", godJson.getAccountID());

        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());
        GroupJson groupJson = new GroupJson();
        groupJson.setSend(false);
        groupJson.setReceive(false);
        groupJson.setGroupName("My Group");
        Entity<GroupJson> e = Entity.entity(groupJson, MediaType.APPLICATION_JSON);
        final Response response = invocationBuilder.put(e, Response.class);

        assertEquals(200, response.getStatus());
        GroupJson res = response.readEntity(GroupJson.class);
        assertEquals("My Group", res.getGroupName());
    }

    @Test
    public void testGetRootGroup() throws Exception {
        AccountResource accountResource = new AccountResource();
        AccountJson godJson = accountResource.getAccount("liker.text@gmail.com", "newPwd4testAgain");

        queryTarget = target(BASEURI + "/rootGroup")
                .queryParam("accountID", godJson.getAccountID());

        final Invocation.Builder invocationBuilder
                = queryTarget.request(MediaType.APPLICATION_JSON)
                .header("password", godJson.getPassword());

        final Response response = invocationBuilder.get();
        assertEquals(200, response.getStatus());
        GroupJson res = response.readEntity(GroupJson.class);
        assertTrue(res != null);
    }

    @Test
    public void testPutUser() throws Exception {

    }

    @Test
    public void testGetUser() throws Exception {

    }
}