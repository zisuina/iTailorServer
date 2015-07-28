package hibernate.community;


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

    private int accountID;
    private String email;
    private String password;
    //    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user", referencedColumnName = "account")
//    private User user;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "feedback_accountID")
    private List<Feedback> feedbacks = new ArrayList<>();
    private List<Message> messageList = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    //    private Map<Group,AccessControl> groupAccessControlMap;
//    private TimeLine timeLine;
    private List<ShareItem> shareItems = new ArrayList<>();
    private List<LoginRecord> loginRecords = new ArrayList<>();
//    private Map<String,Boolean> applicationSettings;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    //    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    //    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
    public List<LoginRecord> getLoginRecords() {
        return loginRecords;
    }

    public void setLoginRecords(List<LoginRecord> loginRecords) {
        this.loginRecords = loginRecords;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_groups",
            joinColumns = {@JoinColumn(name = "accountID", referencedColumnName = "accountID")},
            inverseJoinColumns = {@JoinColumn(name = "groupID", referencedColumnName = "groupID")})
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
    public List<ShareItem> getShareItems() {
        return shareItems;
    }

    public void setShareItems(List<ShareItem> shareItems) {
        this.shareItems = shareItems;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
