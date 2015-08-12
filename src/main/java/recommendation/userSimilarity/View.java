package recommendation.userSimilarity;

import java.sql.Timestamp;

/**
 * Created by crystal.liker on 2015/8/10.
 */
public class View {
    private Item item;
    private Timestamp timestamp;

    public View(Item item, Timestamp timestamp) {
        this.item = item;
        this.timestamp = timestamp;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
