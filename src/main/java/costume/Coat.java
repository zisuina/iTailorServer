package costume;

import javax.persistence.*;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "coats")
public class Coat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coatID;
    private String collar_type;//袖子
    private String length;//长度
    private String thickness;//厚薄
    private String sleeve_type;//领子
    private String button;//纽扣
    private String style;//风格

    public Coat(String collar_type, String length, String thickness, String sleeve_type, String button, String style) {
        this.collar_type = collar_type;
        this.length = length;
        this.thickness = thickness;
        this.sleeve_type = sleeve_type;
        this.button = button;
        this.style = style;
    }

    public Coat() {
    }

    public int getCoatID() {
        return coatID;
    }

    public void setCoatID(int coatID) {
        this.coatID = coatID;
    }

    public String getCollar_type() {
        return collar_type;
    }

    public void setCollar_type(String collar_type) {
        this.collar_type = collar_type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getSleeve_type() {
        return sleeve_type;
    }

    public void setSleeve_type(String sleeve_type) {
        this.sleeve_type = sleeve_type;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBinaryCode() {
        EnCodeService enCodeService = new EnCodeService();
        return enCodeService.getPropertyBinary("collar_type", "Coat", this.collar_type) +
                enCodeService.getPropertyBinary("length", "Coat", this.length) +
                enCodeService.getPropertyBinary("thickness", "Coat", this.thickness) +
                enCodeService.getPropertyBinary("sleeve_type", "Coat", this.sleeve_type) +
                enCodeService.getPropertyBinary("button", "Coat", this.button) +
                enCodeService.getPropertyBinary("style", "Coat", this.style);
    }

    public String getBinaryCodeFormat() {
        EnCodeService enCodeService = new EnCodeService();
        return enCodeService.getPropertyBinary("collar_type", "Coat", this.collar_type) + "-" +
                enCodeService.getPropertyBinary("length", "Coat", this.length) + "-" +
                enCodeService.getPropertyBinary("thickness", "Coat", this.thickness) + "-" +
                enCodeService.getPropertyBinary("sleeve_type", "Coat", this.sleeve_type) + "-" +
                enCodeService.getPropertyBinary("button", "Coat", this.button) + "-" +
                enCodeService.getPropertyBinary("style", "Coat", this.style);
    }


}
