package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "shareItems")
public class ShareItem {

    private int shareItemID;
    //    private Resource resource;
    private List<Comment> comments = new ArrayList<>();
    private Timestamp createdTime;

    public ShareItem() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getShareItemID() {
        return shareItemID;
    }

    public void setShareItemID(int shareItemID) {
        this.shareItemID = shareItemID;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shareItemID")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    @Column(name = "createdTime")
    public Timestamp getTimestamp() {
        return createdTime;
    }

    public void setTimestamp(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}
