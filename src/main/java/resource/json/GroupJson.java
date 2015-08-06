package resource.json;

import hibernate.community.AccessControl;
import hibernate.community.Group;

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
        Group group = new Group();
        group.setAccessControl(new AccessControl(this.isReceive(), this.isSend()));
        group.setGroupName(this.groupName);
        return group;
    }
}
