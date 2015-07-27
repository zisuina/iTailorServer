package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageID;
    private String context;
    private Timestamp timestamp;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "senderAccount", nullable = false)
    private Account senderAccount;
    public Message(String context, Account sender) {
        this.context = context;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.senderAccount = sender;
    }
    public Message() {
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public Account getSender() {
        return senderAccount;
    }
    public void setSender(Account sender) {
        this.senderAccount = sender;
    }
}
