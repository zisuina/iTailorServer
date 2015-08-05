package resource.json;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "MessageJson")
public class MessageJson {
    private int messageID;
    private int senderAccountID;
    private String context;
    private Timestamp createdTime;

    public MessageJson() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getSenderAccountID() {
        return senderAccountID;
    }

    public void setSenderAccountID(int senderAccountID) {
        this.senderAccountID = senderAccountID;
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
}
