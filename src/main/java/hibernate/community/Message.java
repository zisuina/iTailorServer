package hibernate.community;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "messages")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int messageID;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID_FK")
    private Account senderAccount;
    private String context = "";
    private Timestamp createdTime;

    public Message() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public int getMessageID() {
        return messageID;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public Message(String context, Account senderAccount) {
        this.context = context;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.senderAccount = senderAccount;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }
}
