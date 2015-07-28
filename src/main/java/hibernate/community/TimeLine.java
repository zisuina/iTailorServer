package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;
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
    @JoinColumn(name="shareItemID")
    private List<ShareItem> shareItems;

    private Timestamp recentlyUpdatedTime;
}
