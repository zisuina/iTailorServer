package hibernate.community;

import javax.persistence.*;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "access_Control")
public class AccessControl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int controlID;
    @Column(name = "receive")
    private boolean receive;
    @Column(name = "send")
    private boolean send;

    public AccessControl() {
        this.send = true;
        this.receive = true;
    }

    public AccessControl(boolean receive, boolean send) {
        this.receive = receive;
        this.send = send;
    }

    public AccessControl(int i, boolean b, boolean b1) {
        this.controlID = i;
        this.receive = b;
        this.send = b1;
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
