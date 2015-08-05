package hibernate.community;

import resource.message.MessageJson;

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


    public MessageJson becomeToJson() {
        MessageJson messageJson = new MessageJson();
        messageJson.setContext(this.getContext());
        messageJson.setCreatedTime(this.getCreatedTime());
        messageJson.setMessageID(this.messageID);
        messageJson.setSenderAccountID(this.getSenderAccount() != null ? this.getSenderAccount().getAccountID() : 0);
        return messageJson;
    }


//    public Message transferMessageJson(MessageJson messageJson) {
//
//        Message message = new Message();
//        AccountNewService accountNewService = new AccountNewService();
//        Account account =
//                accountNewService.getAccountWithoutCheckPasswordByAccountID(messageJson.getSenderAccountID());
//        System.out.println("MESSAGEJSON:" + messageJson.getMessageID());
//        if (account != null) {
//            message.setContext(messageJson.getContext());
//            message.setSenderAccount(account);
////            if (messageJson.getCreatedTime() == null) {
////                messageJson.setCreatedTime(new Timestamp(System.currentTimeMillis()));
////            }
//            message.setCreatedTime(messageJson.getCreatedTime());
////            new BaseDAO<Message>().create(this);
//            System.out.println("RETURN");
//            return message;
//        }
//        return null;
//
//    }
}
