package crawler;

import javax.persistence.*;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int propertyID;
    private String theKey;
    private String theValue;

    public Property() {
    }

    public Property(String theKey, String theValue) {
        this.theKey = theKey;
        this.theValue = theValue;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getTheKey() {
        return theKey;
    }

    public void setTheKey(String theKey) {
        this.theKey = theKey;
    }

    public String getTheValue() {
        return theValue;
    }

    public void setTheValue(String theValue) {
        this.theValue = theValue;
    }
}
