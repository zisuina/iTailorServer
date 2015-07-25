package community.timeline;

import java.sql.Timestamp;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
public class Push {
    private int messageId;
    private int likeNum;
    private String context;
    private Timestamp timestamp;
    private int senderID;
    private int receiverID;

    public Push(String context) {
        this.context = context;
    }
}
