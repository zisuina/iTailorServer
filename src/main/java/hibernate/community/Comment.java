package hibernate.community;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "comments")
public class Comment extends Message {
    private int thumbNum;//点赞数

    public Comment(String context, Account sender) {
        super(context, sender);
    }

    public Comment() {
        this.thumbNum = 0;
    }

    public int getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(int thumbNum) {
        this.thumbNum = thumbNum;
    }
}
