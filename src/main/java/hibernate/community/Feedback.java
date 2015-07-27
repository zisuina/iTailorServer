package hibernate.community;

import javax.persistence.*;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
public class Feedback extends Message{
    private boolean isAccepted;

    public Feedback(String context, Account sender) {
        super(context, sender);
    }
    public Feedback() {
    }

    public boolean isAccepted() {
        return isAccepted;
    }
    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
}
