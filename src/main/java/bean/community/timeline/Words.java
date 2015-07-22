package bean.community.timeline;

import bean.community.User;

import java.sql.Timestamp;

/**
 * Created by liker on 29/06/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
public class Words {
    private int wordsID;
    private int likerNum;
    private Timestamp timestamp;
    private String context;
    private User toUser;
    private User fromUser;
}
