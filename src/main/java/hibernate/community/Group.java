package hibernate.community;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "groups")
public class Group {

    private int groupID;
    private Set<Account> accountList = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    private AccessControl accessControl;


    public Group() {
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "controlID")
    public AccessControl getAccessControl() {
        return accessControl;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
    public Set<Account> getAccountList() {
        return accountList;
    }
    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public void setAccountList(Set<Account> accountList) {
        this.accountList = accountList;
    }
}
