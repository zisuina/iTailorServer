package resource;

import bean.community.User;
import bean.community.share.Tag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
@Entity(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;
    private User user;
    private ArrayList<Tag> tagsToSend;
    private ArrayList<User> specialSend;
    private ArrayList<User> specialNotSend;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Tag> getTagsToSend() {
        return tagsToSend;
    }

    public void setTagsToSend(ArrayList<Tag> tagsToSend) {
        this.tagsToSend = tagsToSend;
    }

    public ArrayList<User> getSpecialSend() {
        return specialSend;
    }

    public void setSpecialSend(ArrayList<User> specialSend) {
        this.specialSend = specialSend;
    }


    public void send(ArrayList<User> specialSend, ArrayList<User> specialNotSend) {
        ArrayList<User> last = user.getBaseSendList();
        for (User user : specialNotSend) {
            last.remove(user);
        }
        for (User user : specialSend) {
            last.add(user);
        }
        for (User user : last) {
            if (user.getBaseReceiveList().contains(this.getUser())) {
                user.getTimeLine().update(this);
            }
        }
        this.getUser().getTimeLine().update(this);
    }
}
