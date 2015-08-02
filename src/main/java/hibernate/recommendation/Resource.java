package hibernate.recommendation;

import javax.persistence.*;
import java.sql.Timestamp;
/**
 * Created by liker on 19/06/2015 0019.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "resources")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int resourceId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userID_FK")
    private User userID;
    private String location = "undefine";
    private int sizeB;
    private Timestamp timestamp;
    private String source= "undefine";
    private String description = "undefine";
    private int thumbNum = 0;
    private long tmallID;

    public Resource() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSizeB() {
        return sizeB;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
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

    public long getTmallID() {
        return tmallID;
    }

    public void setTmallID(long tmallID) {
        this.tmallID = tmallID;
    }
}
