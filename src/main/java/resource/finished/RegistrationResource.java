package resource.finished;

import bean.Account;
import bean.BaseUser;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by liker on 23/07/2015 0023.
 * Group iTailor.hunters.neu.edu.cn
 */
@Path("/registration")
public class RegistrationResource {
    private static final Logger LOGGER = Logger.getLogger(RegistrationResource.class);

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
//    {
//        nickname,
//        email,
//        password,
//        machID
//    }
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean put(JSONObject jsonObject) {
        try {
            BaseUser baseUser = new BaseUser();
            baseUser.setNickname(jsonObject.getString("nickname"));
            baseUser.setAccount(new Account(jsonObject.getString("nickname"), jsonObject.getString("nickname")));
            //TO DO
            baseUser.getLoginRecords().add(new LoginRecord());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}
