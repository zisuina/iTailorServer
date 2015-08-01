package hibernate.community;


import hibernate.recommendation.User;
import util.encryption.MD5;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountID;
    @Column(name = "email", unique = true, updatable = false)
    private String email;
    private String password = "";
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "userID_FK", nullable = false, updatable = false)
    @JoinColumn(name = "userID_FK")
//    private User user = new User();
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<Feedback> feedbacks = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<Message> messageList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_groups",
            joinColumns = {@JoinColumn(name = "accountID_FK", referencedColumnName = "accountID")},
            inverseJoinColumns = {@JoinColumn(name = "groupID_FK", referencedColumnName = "groupID")})
    private List<Group> groups = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "timeLineID_FK", nullable = false)
    @JoinColumn(name = "timeLineID_FK")
//    private TimeLine timeLine = new TimeLine();
    private TimeLine timeLine;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<ShareItem> shareItems = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<LoginRecord> loginRecords = new ArrayList<>();
    private boolean sync;
    private boolean logIn;
    @Transient
    private String authenticate;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account() {
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

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public TimeLine getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(TimeLine timeLine) {
        this.timeLine = timeLine;
    }

    public List<ShareItem> getShareItems() {
        return shareItems;
    }

    public void setShareItems(List<ShareItem> shareItems) {
        this.shareItems = shareItems;
    }

    public List<LoginRecord> getLoginRecords() {
        return loginRecords;
    }

    public void setLoginRecords(List<LoginRecord> loginRecords) {
        this.loginRecords = loginRecords;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public String getAuthenticate() {
        return MD5.getMD5(this.email + "itailor" + this.password);
    }

    public void setAuthenticate(String authenticate) {
        this.authenticate = MD5.getMD5(this.email + "itailor" + this.password);
    }

    public void login(){
        this.logIn = true;
        this.authenticate = MD5.getMD5(this.email + "itailor" + this.password);
    }

    public void logout(){
        this.logIn = false;
        this.authenticate = "undefine";
    }
}
