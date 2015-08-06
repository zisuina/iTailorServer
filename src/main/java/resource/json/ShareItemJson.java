package resource.json;

import hibernate.community.ShareItem;
import hibernate.recommendation.Resource;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "ShareItemJson")
public class ShareItemJson {
    private int shareItemID;
    private int resourceID;
    private List<Integer> commentIDs = new ArrayList<>();
    private Timestamp createdTime;

    public ShareItemJson() {
    }

    public int getShareItemID() {
        return shareItemID;
    }

    public void setShareItemID(int shareItemID) {
        this.shareItemID = shareItemID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public List<Integer> getCommentIDs() {
        return commentIDs;
    }

    public void setCommentIDs(List<Integer> commentIDs) {
        this.commentIDs = commentIDs;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public ShareItem becomeToJson() {
        ShareItem shareItem = new ShareItem();
        //TODO
        shareItem.setComments(null);
        shareItem.setResource(new Resource());
        return shareItem;
    }
}
