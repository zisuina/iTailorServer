package hibernate.community;


import enums.AccountType;
import hibernate.recommendation.User;
import resource.json.AccountJson;
import util.encryption.MD5;

import javax.persistence.*;
import java.sql.Timestamp;
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
    @JoinColumn(name = "userID_FK")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<Message> messageList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_groups",
            joinColumns = {@JoinColumn(name = "accountID_FK", referencedColumnName = "accountID")},
            inverseJoinColumns = {@JoinColumn(name = "groupID_FK", referencedColumnName = "groupID")})
    private List<Group> groups = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "timeLineID_FK")
    private TimeLine timeLine = new TimeLine();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<ShareItem> shareItems = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<LoginRecord> loginRecords = new ArrayList<>();
    private boolean sync;
    private boolean logIn;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rootGroupID_FK")
    private Group rootGroup = new Group();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private List<Account> pursuers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.CUSTOMER;

    private Timestamp latestSyncTime = new Timestamp(System.currentTimeMillis());


    @Transient
    private String authenticate;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        this.getGroups().add(new Group("Friends"));
    }

    public Account() {
        this.getGroups().add(new Group("Friends"));
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
        return this.authenticate;
    }

    public void setAuthenticate(String authenticate) {
        this.authenticate = authenticate;
    }

    public void updateAuthenticate() {
        this.authenticate = MD5.getMD5(this.email + "itailor" + this.password);
    }

    public Group getRootGroup() {
        return rootGroup;
    }

    public void setRootGroup(Group rootGroup) {
        this.rootGroup = rootGroup;
    }

    public List<Account> getPursuers() {
        return pursuers;
    }

    public void setPursuers(List<Account> pursuers) {
        this.pursuers = pursuers;
    }

    public Timestamp getLatestSyncTime() {
        return latestSyncTime;
    }

    public void setLatestSyncTime(Timestamp latestSyncTime) {
        this.latestSyncTime = latestSyncTime;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * @param account
     * @return 双向"Friends"维护
     */
    public boolean isAFriendOf(Account account) {
        if (this.getRootGroup().getAccountList().contains(account)) {
            return true;
        }
        for (Group group : this.getGroups()) {
            if (group.getAccountList().contains(account)) {
                return true;
            }
        }
        return false;
    }

    public boolean wantToConnect(Account zAccount) {
        if (!this.isAFriendOf(zAccount) && !this.pursuers.contains(zAccount)) {
            zAccount.getPursuers().add(this);
            //消息推送
            return true;
        }
        return false;
    }

    public boolean agreeToConnect(Account zAccount) {
        if (!this.isAFriendOf(zAccount) && this.pursuers.contains(zAccount)) {
            this.getRootGroup().getAccountList().add(zAccount);
            this.pursuers.remove(zAccount);
            return true;
        }
        return false;
    }

    public AccountJson becomeToJson() {
        AccountJson accountJson = new AccountJson();
        accountJson.setAccountID(this.getAccountID());
        accountJson.setPassword(this.password);
        accountJson.setEmail(this.email);
        accountJson.setUserID(this.user != null ? this.user.getUser() : 0);
        accountJson.setTimeLineID(this.getTimeLine() != null ? this.getTimeLine().getTimelineID() : 0);
        accountJson.setSync(this.isSync());
        accountJson.setLogIn(this.isLogIn());
        accountJson.setRootGroupID(this.rootGroup != null ? this.rootGroup.getGroupID() : 0);
        accountJson.setLatestSyncTime(this.latestSyncTime);
        accountJson.setAuthenticate(this.getAuthenticate());
        return accountJson;
    }

    public void mergeJsonToEntity(AccountJson accountJson) {
//        this.setPassword(accountJson.getPassword() == null ? "" : accountJson.getPassword());
        this.setPassword(accountJson.getPassword());
        this.setSync(accountJson.isSync());
        this.setLogIn(accountJson.isLogIn());
    }


    /**
     * 用于被删除不级联删除其他用户产生的对象
     */
    public void beGivenUp() {
        this.groups.forEach(hibernate.community.Group::beGivenUp);
        this.shareItems.forEach(hibernate.community.ShareItem::beGivenUp);
        this.rootGroup.beGivenUp();
        this.pursuers = null;
        this.user = null;
    }
}
