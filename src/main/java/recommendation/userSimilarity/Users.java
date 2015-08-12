package recommendation.userSimilarity;

import recommendation.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/12.
 */
public class Users {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
