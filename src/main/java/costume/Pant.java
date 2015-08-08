package costume;

import javax.persistence.*;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "pants")
public class Pant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pantID;
    private String length;
    private String shape;
    private String thickness;
    private String waist_height;
    private String style;

    public String getBinaryCode() {
        EnCodeService enCodeService = new EnCodeService();
//        长裤;锥形裤;薄款;高腰;瑞丽
        return enCodeService.getPropertyBinary("length", "Pant", this.length) +
                enCodeService.getPropertyBinary("shape", "Pant", this.shape) +
                enCodeService.getPropertyBinary("thickness", "Pant", this.thickness) +
                enCodeService.getPropertyBinary("waist_height", "Pant", this.waist_height) +
                enCodeService.getPropertyBinary("style", "Pant", this.style);
    }


    public Pant(String length, String shape, String thickness, String waist_height, String style) {
        this.length = length;
        this.shape = shape;
        this.thickness = thickness;
        this.waist_height = waist_height;
        this.style = style;
    }

    public Pant() {
    }

    public int getPantID() {
        return pantID;
    }

    public void setPantID(int pantID) {
        this.pantID = pantID;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
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
}
