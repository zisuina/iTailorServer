package securities;

import javax.persistence.*;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "name")

    private String name;
    @Column(name = "password")
    private String pwd;

    public Account(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Account() {
    }
}
