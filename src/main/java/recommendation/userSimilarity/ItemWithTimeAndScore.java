package recommendation.userSimilarity;

import java.sql.Timestamp;

/**
 * Created by crystal.liker on 2015/8/12.
 */
public class ItemWithTimeAndScore extends Item {
    private Timestamp timestamp;
    private int score = 0;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
