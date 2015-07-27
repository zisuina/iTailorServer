package entity;


import enums.UserType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liker on 23/07/2015 0023.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nickname")
    private String nickname;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "account")
    private Account account;

    private UserType userType;

    private Wardrobe rootWardrobe;
    private List<PushMessage> pushMessageList;


//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumns(value = {@JoinColumn(name = "loginRecords", referencedColumnName = "id")})
//    private ArrayList<LoginRecord> loginRecords;

    public User(String nickname, Account account) {
        this.nickname = nickname;
        this.account = account;
    }

    public User() {
    }

    public int getId() {
        return id;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
