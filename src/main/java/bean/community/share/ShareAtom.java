package bean.community.share;

import bean.community.User;

/**
 * Created by liker on 29/06/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ShareAtom {
    private User user;
    private boolean receive;
    private boolean send;

    public ShareAtom(User user, boolean receive, boolean send) {
        this.user = user;
        this.receive = receive;
        this.send = send;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


}
