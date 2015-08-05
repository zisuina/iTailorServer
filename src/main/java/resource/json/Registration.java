package resource.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "registration")
public class Registration {
    @XmlElement(name = "nickname")
    private String nickname;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "machID")
    private String machID;
    @XmlElement(name = "timestamp")
    private Timestamp timestamp;

    public Registration() {
    }
    public Registration(String nickname, String email, String password, String machID) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.machID = machID;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public void setMachID(String machID) {
        this.machID = machID;
    }
    public String getMachID() {
        return this.machID;
    }
}
