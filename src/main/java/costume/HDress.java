package costume;

import javax.persistence.*;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "half_body_dresses")
public class HDress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dressID;
    private String waist_height;
    private String style;
    private String shape;
    private String dress_length;

    public String getBinaryCode() {
        EnCodeService enCodeService = new EnCodeService();
//        瑞丽;蛋糕裙;超短裙;高腰
        return enCodeService.getPropertyBinary("style", "HDress", this.style) +
                enCodeService.getPropertyBinary("shape", "HDress", this.shape) +
                enCodeService.getPropertyBinary("dress_length", "HDress", this.dress_length) +
                enCodeService.getPropertyBinary("waist_height", "HDress", this.waist_height);
    }

    public HDress() {
    }

    public HDress(String waist_height, String style, String shape, String dress_length) {
        this.waist_height = waist_height;
        this.style = style;
        this.shape = shape;
        this.dress_length = dress_length;
    }

    public int getDressID() {
        return dressID;
    }

    public void setDressID(int dressID) {
        this.dressID = dressID;
    }

    public String getWaist_height() {
        return waist_height;
    }

    public void setWaist_height(String waist_height) {
        this.waist_height = waist_height;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getDress_length() {
        return dress_length;
    }

    public void setDress_length(String dress_length) {
        this.dress_length = dress_length;
    }
}
