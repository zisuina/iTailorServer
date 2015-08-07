package costume;

import javax.persistence.*;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "uCloths")
public class UCloth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uClothID;
    private String collar_type;
    private String sleeve_type;
    private String style;
    private String pattern;
    private String length;


    public UCloth(String collar_type, String sleeve_type, String style, String pattern, String length) {
        this.collar_type = collar_type;
        this.sleeve_type = sleeve_type;
        this.style = style;
        this.pattern = pattern;
        this.length = length;
    }

    public UCloth() {
    }

    public int getuClothID() {
        return uClothID;
    }

    public void setuClothID(int uClothID) {
        this.uClothID = uClothID;
    }

    public String getCollar_type() {
        return collar_type;
    }

    public void setCollar_type(String collar_type) {
        this.collar_type = collar_type;
    }

    public String getSleeve_type() {
        return sleeve_type;
    }

    public void setSleeve_type(String sleeve_type) {
        this.sleeve_type = sleeve_type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }


}
