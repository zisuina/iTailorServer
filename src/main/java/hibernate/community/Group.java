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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupID;

//    @ManyToMany(mappedBy = "groups",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            targetEntity = Account.class)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_groups",
            joinColumns = {@JoinColumn(name = "groupID", referencedColumnName = "groupID")},
            inverseJoinColumns = {@JoinColumn(name = "accountID", referencedColumnName ="accountID")})
    private Set<Account> accountList = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "controlID")
    private AccessControl accessControl;

    public Group() {
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

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
