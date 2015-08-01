package hibernate.community;

import hibernate.recommendation.Resource;

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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shareItemID;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "resourceID_FK", nullable = false)
    @JoinColumn(name = "resourceID_FK")
    private Resource resource = new Resource();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "shareItemID_FK", nullable = false)
    @JoinColumn(name = "shareItemID_FK")
    private List<Comment> comments = new ArrayList<>();

    private Timestamp createdTime;

    public ShareItem() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public int getShareItemID() {
        return shareItemID;
    }

    public void setShareItemID(int shareItemID) {
        this.shareItemID = shareItemID;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
