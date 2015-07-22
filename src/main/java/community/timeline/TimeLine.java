package community.timeline;

import community.User;
import resource.Image;
import java.util.ArrayList;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
public class TimeLine {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    private ArrayList<Moment> moments;
    private ArrayList<Moment> history;

    public void update(Image image) {
        this.getUser().getMessagesQueue().push(new Push("Image Update!"));
    }
    public void update(Moment moment) {
        this.getUser().getMessagesQueue().push(new Push("Moment Update!"));
    }
}
