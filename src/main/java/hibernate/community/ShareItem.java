package hibernate.community;

import hibernate.recommendation.Resource;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ShareItem {
    private Resource resource;
    private List<Comment> comments;
    private Timestamp timestamp;
}
