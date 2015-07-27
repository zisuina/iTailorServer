package hibernate.recommendation;

import hibernate.community.Comment;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by liker on 19/06/2015 0019.
 */
public class Resource {
    private int resourceId;
    private int userId;
    private int commentId;
    private String location;
    private float sizeKB;
    private Timestamp timestamp;
    private String source;
    private List<Comment> comments;
    private String description;
    private int thumbNum;
}
