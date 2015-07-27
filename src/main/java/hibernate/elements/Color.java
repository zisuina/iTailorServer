package hibernate.elements;

import javax.persistence.*;

/**
 * Created by liker on 25/07/2015 0025.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "color")
public class Color {

    private int id;
    private String name_ch;
    private String name_en;
    private int red;
    private int green;
    private int blue;
    private int hue;//色相
    private int saturation;//饱和度
    private int lightness;//明度
    private String hex;

    public Color() {
    }

    public Color(String name_ch) {
        this.name_ch = name_ch;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name_ch")
    public String getName_ch() {
        return name_ch;
    }

    public void setName_ch(String name_ch) {
        this.name_ch = name_ch;
    }

    @Column(name = "name_en")
    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    @Column(name = "red")
    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    @Column(name = "green")
    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    @Column(name = "blue")
    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Column(name = "hue")
    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    @Column(name = "saturation")
    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    @Column(name = "lightness")
    public int getLightness() {
        return lightness;
    }

    public void setLightness(int lightness) {
        this.lightness = lightness;
    }

    @Column(name = "hex")
    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
