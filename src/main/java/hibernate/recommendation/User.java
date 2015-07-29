package hibernate.recommendation;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 23/07/2015 0023.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String nickname = "";
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK", nullable = false, updatable = false)
    private PreferenceMatrix preferenceMatrix = new PreferenceMatrix();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userID")
//    @OrderBy("resourceId")
    private List<Resource> resourceList = new ArrayList<>();

//    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "account")
//    private Account account;

//    private UserType userType;
//
//    private Wardrobe rootWardrobe;
//    private List<Message> pushMessageList;


//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumns(value = {@JoinColumn(name = "loginRecords", referencedColumnName = "id")})
//    private ArrayList<LoginRecord> loginRecords;

//    public User(String nickname, Account account) {
//        this.nickname = nickname;
//        this.account = account;
//    }

    public User() {
        this.nickname = "anonymous";
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }


    public PreferenceMatrix getPreferenceMatrix() {
        return preferenceMatrix;
    }

    public void setPreferenceMatrix(PreferenceMatrix preferenceMatrix) {
        this.preferenceMatrix = preferenceMatrix;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
