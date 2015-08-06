package hibernate.community;

import resource.json.GroupJson;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_groups",
            joinColumns = {@JoinColumn(name = "groupID_FK", referencedColumnName = "groupID")},
            inverseJoinColumns = {@JoinColumn(name = "accountID_FK", referencedColumnName = "accountID")})
    private List<Account> accountList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "controlID_FK")
    private AccessControl accessControl = new AccessControl();
    private String groupName = "undefine";

    public Group() {
    }



    public Group(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public AccessControl getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public GroupJson becomeToGroupJson() {
        GroupJson groupJson = new GroupJson();
        groupJson.setGroupID(this.groupID);
        groupJson.setSend(this.accessControl == null || this.accessControl.isSend());
        groupJson.setReceive(this.accessControl == null || this.accessControl.isReceive());
        groupJson.setGroupName(this.groupName);
        return groupJson;
    }

    public void beGivenUp(){
        this.accountList = null;
        this.accessControl = null;
    }

}
