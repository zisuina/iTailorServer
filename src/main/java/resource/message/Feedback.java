package resource.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "feedback")
public class Feedback {
    @XmlElement(name = "userID")
    private String userID;
    @XmlElement(name = "context")
    private String context;
    @XmlElement(name = "timestamp")
    private Timestamp timestamp;
    public Feedback() {
    }
}
