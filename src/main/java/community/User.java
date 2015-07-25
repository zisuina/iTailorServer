package community;

import community.share.Tag;
import community.timeline.Push;
import community.timeline.TimeLine;
import util.encryption.MD5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by liker on 28/06/2015 0028.
 * Tag iTailor.hunters.neu.edu.cn
 */
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String nickname;
    private String password;
    private int closetId;
    private int watchlistId;
    private Stack<Push> messagesQueue;
//    private ArrayList<bean.resource.finished.LoginRecord> loginRecords;
    private TimeLine timeLine;
    private ArrayList<Tag> tags = new ArrayList<Tag>();
    private ArrayList<User> friends = new ArrayList<User>();

    public ArrayList<User> getBaseSendList() {
        ArrayList<User> real = new ArrayList<User>();
        for (Tag tag : tags) {
            for (User user : tag.getGroupMembers()) {
                if (tag.isSend()) {
                    real.add(user);
                }
            }
        }
        return real;
    }

    public ArrayList<User> getBaseReceiveList() {
        ArrayList<User> real = new ArrayList<User>();
        for (Tag tag : tags) {
            for (User user : tag.getGroupMembers()) {
                if (tag.isReceive()) {
                    real.add(user);
                }
            }
        }
        return real;
    }

    public TimeLine getTimeLine() {
        return timeLine;
    }

    public void setPassword(String password) {
        this.password = MD5.getMD5(password);
    }

    public boolean isVerified(String pwd) {
        return this.password.equals(MD5.getMD5(pwd));
    }

    public User(String email, String password) {
//        Email email1 = new Email(email);
        this.password = MD5.getMD5(password);
    }

    public String getPassword() {
        return password;
    }

    public Stack<Push> getMessagesQueue() {
        return messagesQueue;
    }
}
