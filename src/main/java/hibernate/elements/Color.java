package hibernate.elements;

import javax.persistence.*;

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
    private String sales;
    private String relative_value;


    public Color(String name_ch, String name_en, int red, int green, int blue, String sales, String relative_value) {
        this.name_ch = name_ch;
        this.name_en = name_en;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.sales = sales;
        this.relative_value = relative_value;
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

    public static void getColorByHex(String hex){
        //TO DO
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getRelative_value() {
        return relative_value;
    }

    public void setRelative_value(String other) {
        this.relative_value = other;
    }
}
