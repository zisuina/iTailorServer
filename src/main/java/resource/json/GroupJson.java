package resource.json;

import hibernate.community.AccessControl;
import hibernate.community.Group;
import resource.service.AccountNewService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "GroupJson")
public class GroupJson {
    @XmlElement(name = "groupID")
    private int groupID;
    @XmlElement(name = "receive")
    private boolean receive;
    @XmlElement(name = "send")
    private boolean send;
    @XmlElement(name = "groupName")
    private String groupName;

    public GroupJson() {
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public boolean isReceive() {
        return receive;
    }

    public void setReceive(boolean receive) {
        this.receive = receive;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Group becomeToGroup() {
        System.out.println("RECEIVE: " + this.isReceive());
        System.out.println("SEND: " + this.isSend());
        System.out.println("GroupName: " + this.getGroupName());
        Group group = new Group();
        group.setAccessControl(new AccessControl(2, this.isReceive(), this.isSend()));
        group.setGroupName(this.groupName);
        AccountNewService accountNewService = new AccountNewService();
//        for (int i : this.accountIDs) {
//            Account account = accountNewService.getAccountWithoutCheckPasswordByAccountID(i);
//            System.out.println("AccountID:" + i);
//            if (account != null) {
//                System.out.println("ONE ADDED!");
//                group.getAccountList().add(account);
//            }
//        }
        return group;
    }
}
