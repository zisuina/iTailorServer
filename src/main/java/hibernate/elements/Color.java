package hibernate.elements;

import javax.persistence.*;

/**
 * Created by liker on 25/07/2015 0025.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "colors")
public class Color extends Element{

//    private int colorID;
    private String name_ch = "";
    private String name_en = "";
    private int red;
    private int green;
    private int blue;
    private int hue;//色相
    private int saturation;//饱和度
    private int lightness;//明度
    private String hex = "";

    public Color() {
    }

    public Color(String name_ch) {
        this.name_ch = name_ch;
    }

    public String getName_ch() {
        return name_ch;
    }

    public void setName_ch(String name_ch) {
        this.name_ch = name_ch;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getLightness() {
        return lightness;
    }

    public void setLightness(int lightness) {
        this.lightness = lightness;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
