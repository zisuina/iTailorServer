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
    private String nickname = "undefine";
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "preferenceID_FK", nullable = false, updatable = false)
    @JoinColumn(name = "preferenceID_FK")
    private PreferenceMatrix preferenceMatrix;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userID")
//    @OrderBy("resourceId")
    private List<Resource> resourceList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bodyID_FK")
    private Body body;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wardrobeID_FK")
    private Wardrobe rootWardrobe;


//    private UserType userType;



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

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Wardrobe getRootWardrobe() {
        return rootWardrobe;
    }

    public void setRootWardrobe(Wardrobe rootWardrobe) {
        this.rootWardrobe = rootWardrobe;
    }
}
