package hibernate.recommendation;


import hibernate.elements.SearchWord;
import resource.json.UserJson;

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
    private int user;
    private String nickname = "undefine";
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private PreferenceMatrix preferenceMatrix;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
//    @OrderBy("resourceId")
    private List<Resource> resourceList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userID_FK")
    private List<SearchWord> searchWordsHistory = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bodyID_FK")
    private Body body;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wardrobeID_FK")
    private Wardrobe rootWardrobe;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "userID_FK")
//    private List<Item> itemRecommendedToday = new ArrayList<>();

//    private AccountType userType;

    public User() {
        this.nickname = "anonymous";
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int userID) {
        this.user = userID;
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

    public List<SearchWord> getSearchWordsHistory() {
        return searchWordsHistory;
    }

    public void setSearchWordsHistory(List<SearchWord> searchWordsHistory) {
        this.searchWordsHistory = searchWordsHistory;
    }

    public UserJson becomeToJson() {
        return null;
    }
//    public List<Item> getItemRecommendedToday() {
//        return itemRecommendedToday;
//    }
//
//    public void setItemRecommendedToday(List<Item> itemRecommendedToday) {
//        this.itemRecommendedToday = itemRecommendedToday;
//    }
}
