package hibernate.community;

import javax.persistence.*;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "feedback")
public class Feedback extends Message{
    @Column(name = "isAccepted")
    private boolean accepted;
    public Feedback(String context, Account sender) {
        super(context, sender);
    }
    public Feedback() {
    }
    public boolean isAccepted() {
        return accepted;
    }
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}
