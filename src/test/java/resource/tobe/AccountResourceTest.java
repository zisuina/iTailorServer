package resource.tobe;

import org.junit.Test;
import resource.community.AccountResource;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
//public class AccountResourceTest extends JerseyTest{
public class AccountResourceTest{
//    private static final String BASEURI = "itailor/";
//    @Override
//    protected Application configure(){
//        return new ApplicationConfig();
//    }
//
//    @Test
//    public void testGet() throws Exception {
//        final WebTarget queryTarget = target(BASEURI+"account")
//                .queryParam("email","liker.xu@foxmail.com");
//        final Invocation.Builder invocationBuilder =
//                queryTarget.request(MediaType.APPLICATION_JSON_TYPE);
//        final Response response = invocationBuilder.get();
//        System.out.println(response.toString());
//        System.out.println(response.getLength());
//        System.out.println(response.getHeaders().toString());
//        System.out.println(response.getStatus());
//    }

    @Test
    public void testRegisterAccount() throws Exception {
        AccountResource accountResource = new AccountResource();
        assertTrue(accountResource.registerAccount("likser2.xu@foxmail.com","88888"));

    }



}