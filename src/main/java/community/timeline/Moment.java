package community.timeline;

import community.User;
import resource.Image;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
public class Moment {
    public User getUser() {
        return user;
    }

    public Moment(User user, Image image) {
        this.user = user;
        this.image = image;
    }

    private User user;
    private Image image;
    private Timestamp timestamp;
    private ArrayList<Words> discussion;
    public void pushMoment(){
        ArrayList<User> last = user.getBaseSendList();
        for (User user : last) {
            if (user.getBaseReceiveList().contains(this.getUser())) {
                user.getTimeLine().update(this);
            }
        }
        this.getUser().getTimeLine().update(this);
    }
}
