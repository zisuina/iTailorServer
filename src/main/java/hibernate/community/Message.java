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

    private int messageID;
    private Account senderAccount;
    private String context;
    private Timestamp createdTime;

    public Message() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getMessageID() {
        return messageID;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountID")
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

    @Column(name = "createdTime")
    public Timestamp getTimestamp() {
        return createdTime;
    }

    public void setTimestamp(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }
}
