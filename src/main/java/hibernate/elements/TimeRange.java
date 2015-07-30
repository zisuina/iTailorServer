package hibernate.elements;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "timeRanges")
public class TimeRange extends Element{
    private Timestamp beginTimestamp;
    private Timestamp endTimestamp;
    public TimeRange() {
    }
}
