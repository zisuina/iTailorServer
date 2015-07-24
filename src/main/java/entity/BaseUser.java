package entity;


import javax.persistence.*;

/**
 * Created by liker on 23/07/2015 0023.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "user")
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nickname")
    private String nickname;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "account")
    private Account account;

//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumns(value = {@JoinColumn(name = "loginRecords", referencedColumnName = "id")})
//    private ArrayList<LoginRecord> loginRecords;

    public BaseUser(String nickname, Account account) {
        this.nickname = nickname;
        this.account = account;
    }

    public BaseUser() {
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
