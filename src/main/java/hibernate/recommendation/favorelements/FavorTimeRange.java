package hibernate.recommendation.favorelements;

import hibernate.elements.TimeRange;
import hibernate.recommendation.FavorElement;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_TimeRanges")
public class FavorTimeRange extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "timeRangeID_FK")
    private TimeRange timeRange = new TimeRange();
    public FavorTimeRange() {
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRange timeRange) {
        this.timeRange = timeRange;
    }
}
