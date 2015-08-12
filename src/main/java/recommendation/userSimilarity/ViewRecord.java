package recommendation.userSimilarity;

import hibernate.recommendation.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/10.
 */
public class ViewRecord {
    private User user;
    private List<View> clothingImages =new ArrayList<>();

    public ViewRecord(User user, List<View> clothingImages) {
        this.user = user;
        this.clothingImages = clothingImages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<View> getClothingImages() {
        return clothingImages;
    }

    public void setClothingImages(List<View> clothingImages) {
        this.clothingImages = clothingImages;
    }
}
