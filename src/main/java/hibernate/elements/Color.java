package hibernate.elements;

import util.BaseDAO;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liker on 25/07/2015 0025.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int colorID;
    private String name_ch = "";
    private String name_en = "";
    private int red;
    private int green;
    private int blue;
    private float hue;//色相
    private float saturation;//饱和度
    private float brightness;//明度
    private String hex = "";
    private String quantityInTmall;//所有用户都缺了个0
    private boolean nice_for_white;
    private boolean nice_for_yellow;
    private boolean nice_for_red;
    private boolean nice_for_black;
    private boolean nice_for_fat;
    private boolean nice_for_standard;
    private boolean nice_for_thin;
    private boolean nice_for_young_age;
    private boolean nice_for_middle_age;
    private boolean nice_for_ole_age;
    private boolean nice_for_inward;
    private boolean nice_for_outward;
//    private String relative_value;


    public void setPrefixColor(boolean nice_for_white, boolean nice_for_yellow, boolean nice_for_red, boolean nice_for_black, boolean nice_for_fat, boolean nice_for_standard, boolean nice_for_thin, boolean nice_for_young_age, boolean nice_for_middle_age, boolean nice_for_ole_age, boolean nice_for_inward, boolean nice_for_outward) {
        this.nice_for_white = nice_for_white;
        this.nice_for_yellow = nice_for_yellow;
        this.nice_for_red = nice_for_red;
        this.nice_for_black = nice_for_black;
        this.nice_for_fat = nice_for_fat;
        this.nice_for_standard = nice_for_standard;
        this.nice_for_thin = nice_for_thin;
        this.nice_for_young_age = nice_for_young_age;
        this.nice_for_middle_age = nice_for_middle_age;
        this.nice_for_ole_age = nice_for_ole_age;
        this.nice_for_inward = nice_for_inward;
        this.nice_for_outward = nice_for_outward;
    }

    public Color(String name_ch, String name_en, int red, int green, int blue, String quantityInTmall, String relative_value) {
        this.name_ch = name_ch;
        this.name_en = name_en;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.quantityInTmall = quantityInTmall;
//        this.relative_value = relative_value;
    }

    public Color(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            this.red = this.green = this.blue = 128;
        } else {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

    public double getColorDistance(Color another) {
        return Math.pow(Math.abs(this.getRed() - another.getRed()), 2) +
                Math.pow(Math.abs(this.getGreen() - another.getGreen()), 2) +
                Math.pow(Math.abs(this.getBlue() - another.getBlue()), 2);
    }


    public Color() {
    }

    public void refresh() {
        float[] hsbvals = new float[3];
        int cmax = (red > green) ? red : green;
        if (blue > cmax) cmax = blue;
        int cmin = (red < green) ? red : green;
        if (blue < cmin) cmin = blue;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - red)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - green)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - blue)) / ((float) (cmax - cmin));
            if (red == cmax)
                hue = bluec - greenc;
            else if (green == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hex = "#FF" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
    }

    public Color(String name_ch) {
        this.name_ch = name_ch;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
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

    public float getHue() {
        return hue;
    }

    public void setHue(float hue) {
        this.hue = hue;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }

    public float getBrightness() {
        return brightness;
    }

    public void setBrightness(float brightness) {
        this.brightness = brightness;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;

    }

    public static void getColorByHex(String hex) {
        //TO DO
    }

    public String getQuantityInTmall() {
        return quantityInTmall;
    }

    public void setQuantityInTmall(String sales) {
        this.quantityInTmall = sales;
    }


//
//    float[] rgb = new float[] { rgbR, rgbG, rgbB };
//    Arrays.sort(rgb);
//    float max = rgb[2];
//    float min = rgb[0];
//    float hsbB = max / 255.0f;
//    float hsbS = max == 0 ? 0 : (max - min) / (float) max;
//
//    float hsbH = 0;
//    if (max == rgbR && rgbG >= rgbB) {
//        hsbH = (rgbG - rgbB) * 60f / (max - min) + 0;
//    } else if (max == rgbR && rgbG < rgbB) {
//        hsbH = (rgbG - rgbB) * 60f / (max - min) + 360;
//    } else if (max == rgbG) {
//        hsbH = (rgbB - rgbR) * 60f / (max - min) + 120;
//    } else if (max == rgbB) {
//        hsbH = (rgbR - rgbG) * 60f / (max - min) + 240;
//    }
//
//    float[] hsb = new float[3];
//    hsb[0]= hsbH;
//    hsb[1]= hsbS;
//    hsb[2]= hsbB;
//    return hsb;

    public static void main(String[] args) {
        List<Color> colors =  new BaseDAO<Color>().list("select from Color");

    }
}
