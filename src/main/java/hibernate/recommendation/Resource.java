package hibernate.recommendation;

import javax.persistence.*;
import java.sql.Timestamp;
/**
 * Created by liker on 19/06/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resourceId;
    private int userId;
    private int commentId;
    private String location = "";
    private float sizeKB = 0.0f;
    private Timestamp timestamp;
    private String source= "";
    private String description = "";
    private int thumbNum = 0;

    public Resource() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getResourceId() {

        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSizeKB() {
        return sizeKB;
    }

    public void setSizeKB(float sizeKB) {
        this.sizeKB = sizeKB;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(int thumbNum) {
        this.thumbNum = thumbNum;
    }
}
