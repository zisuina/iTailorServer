package hibernate.community;


import javax.persistence.*;

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
    private String email;
    private String password;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user", referencedColumnName = "account")
//    private User user;
//    private List<Feedback> feedbacks;
//    private List<Message> messageList;
//    private Map<Group,AccessControl> groupAccessControlMap;
//    private TimeLine timeLine;
//    private List<ShareItem> shareItems;
//    private List<LoginRecord> loginRecords;
//    private Map<String,Boolean> applicationSettings;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account() {
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
}
