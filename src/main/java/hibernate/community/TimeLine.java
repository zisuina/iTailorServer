package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "timeline")
public class TimeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int timelineID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "timelineID_FK")
    private List<ShareItem> shareItems = new ArrayList<>();

    private Timestamp recentlyUpdatedTime;

    public TimeLine() {
        recentlyUpdatedTime = new Timestamp(System.currentTimeMillis());
    }

    public int getTimelineID() {
        return timelineID;
    }

    public void setTimelineID(int timelineID) {
        this.timelineID = timelineID;
    }

    public List<ShareItem> getShareItems() {
        return shareItems;
    }

    public void setShareItems(List<ShareItem> shareItems) {
        this.shareItems = shareItems;
    }

    public Timestamp getRecentlyUpdatedTime() {
        return recentlyUpdatedTime;
    }

    public void setRecentlyUpdatedTime(Timestamp recentlyUpdatedTime) {
        this.recentlyUpdatedTime = recentlyUpdatedTime;
    }

    public List<ShareItem> getSortedShareItems() {
        if(shareItems.isEmpty()){
            return new ArrayList<>();
        }
        Collections.sort(shareItems, new Comparator<ShareItem>() {
            public int compare(ShareItem arg0, ShareItem arg1) {
                return arg0.getCreatedTime().compareTo(arg1.getCreatedTime());
            }
        });
        return shareItems;
    }

    public void beGivenUp(){
        this.shareItems = null;
    }
}
