package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "login_Records")
public class LoginRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loginRecordID;
    private Timestamp createdTime;
    private String UDID = "";
    private String ip = "127.0.0.1";


    public LoginRecord(String UDID, String ip) {
        this.UDID = UDID;
        this.ip = ip;
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public LoginRecord() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public int getLoginRecordID() {
        return loginRecordID;
    }

    public void setLoginRecordID(int loginRecordID) {
        this.loginRecordID = loginRecordID;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getUDID() {
        return UDID;
    }

    public void setUDID(String UDID) {
        this.UDID = UDID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
