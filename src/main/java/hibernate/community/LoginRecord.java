package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "login_records")
public class LoginRecord {

    private int loginRecordID;
    private Timestamp createdTime;
    private String UDID;
    private String ip;

    public LoginRecord() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getLoginRecordID() {
        return loginRecordID;
    }

    public void setLoginRecordID(int loginRecordID) {
        this.loginRecordID = loginRecordID;
    }
    @Column(name = "createdTime")
    public Timestamp getTimestamp() {
        return createdTime;
    }

    public void setTimestamp(Timestamp createdTime) {
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
