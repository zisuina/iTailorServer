package hibernate.community;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "access_Control")
public class AccessControl {
    @Id
    private int controlID;
    @Column(name = "receive", updatable = false)
    private boolean receive;
    @Column(name = "send", updatable = false)
    private boolean send;

    public AccessControl() {
        this.send = true;
        this.receive = true;
    }

    public AccessControl(int controlID, boolean receive, boolean send) {
        this.controlID = controlID;
        this.receive = receive;
        this.send = send;
    }

    public void setReceive(boolean receive) {
        this.receive = receive;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public boolean isReceive() {
        return receive;
    }

    public boolean isSend() {
        return send;
    }

    public int getControlID() {
        return controlID;
    }

    public void setControlID(int controlID) {
        this.controlID = controlID;
    }




}
