package resource.message;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "AccountJson")
public class AccountJson {
    private int accountID;
    private String email;
    private String password = "*******";
    private int userID;
    private int timeLineID;
    private boolean sync;
    private boolean logIn;
    private int rootGroupID;
    private Timestamp latestSyncTime;
    private String authenticate;

    public AccountJson() {
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public int getTimeLineID() {
        return timeLineID;
    }

    public void setTimeLineID(int timeLineID) {
        this.timeLineID = timeLineID;
    }
    

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public int getRootGroupID() {
        return rootGroupID;
    }

    public void setRootGroupID(int rootGroupID) {
        this.rootGroupID = rootGroupID;
    }

    public Timestamp getLatestSyncTime() {
        return latestSyncTime;
    }

    public void setLatestSyncTime(Timestamp latestSyncTime) {
        this.latestSyncTime = latestSyncTime;
    }

    public String getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(String authenticate) {
        this.authenticate = authenticate;
    }
}
