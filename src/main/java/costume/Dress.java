package costume;

import javax.persistence.*;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "dresses")
public class Dress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dressID;
    private String collar_type;
    private String sleeve_type;
    private String style;
    private String shape;
    private String dress_length;

    public String getBinaryCode() {
//        圆领;直袖;瑞丽;蛋糕裙;超短裙
        EnCodeService enCodeService = new EnCodeService();
        return enCodeService.getPropertyBinary("collar_type", "Dress", this.collar_type) +
                enCodeService.getPropertyBinary("sleeve_type", "Dress", this.sleeve_type) +
                enCodeService.getPropertyBinary("style", "Dress", this.style) +
                enCodeService.getPropertyBinary("shape", "Dress", this.shape) +
                enCodeService.getPropertyBinary("dress_length", "Dress", this.dress_length);
    }

    public Dress(String collar_type, String sleeve_type, String style, String shape, String dress_length) {
        this.collar_type = collar_type;
        this.sleeve_type = sleeve_type;
        this.style = style;
        this.shape = shape;
        this.dress_length = dress_length;
    }

    public Dress() {
    }

    public int getDressID() {
        return dressID;
    }

    public void setDressID(int dressID) {
        this.dressID = dressID;
    }

    public String getCollar_type() {
        return collar_type;
    }

    public void setCollar_type(String lingZi) {
        this.collar_type = lingZi;
    }

    public String getSleeve_type() {
        return sleeve_type;
    }

    public void setSleeve_type(String xiuZi) {
        this.sleeve_type = xiuZi;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDress_length() {
        return dress_length;
    }

    public void setDress_length(String qunChang) {
        this.dress_length = qunChang;
    }
}
