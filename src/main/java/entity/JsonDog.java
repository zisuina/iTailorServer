package entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by liker on 09/07/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */

@XmlRootElement
@XmlType(propOrder = {"dogId", "dogName"})
public class JsonDog {
    private String dogId;
    private String dogName;
    public JsonDog() {
        dogId = "1024";
        dogName = "wa-ca-wa-ca";
    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}
