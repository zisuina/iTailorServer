package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "comment")
public class Comment {
    @XmlElement(name = "initiativeID")
    private int initiativeID;
    @XmlElement(name = "passiveID")
    private int passiveID;
    @XmlElement(name = "commentID")
    private int commentID;
    @XmlElement(name = "context")
    private int context;//点赞可为特殊context
    @XmlElement(name = "timestamp")
    private Timestamp timestamp;
    private int thumbNum;//点赞数
    public Comment() {
    }
}
