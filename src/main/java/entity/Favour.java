package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "favour")
public class Favour {
    @XmlElement(name = "userID")
    private int userID;
    @XmlElement(name = "itemID")
    private int itemID;
    @XmlElement(name = "timestamp")
    private Timestamp timestamp;
    public Favour() {
    }
}
