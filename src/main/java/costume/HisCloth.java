package costume;

import enums.ClothStyle;
import hibernate.elements.Color;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class HisCloth {

    private float price;
    private String itemName;
    private ClothStyle style;
    private int score;
//    private int times;
    private Color color;//

    public HisCloth(float price, String itemName, ClothStyle style, int score, Color color) {
        this.price = price;
        this.itemName = itemName;
        this.style = style;
        this.score = score;
//        this.times = times;
        this.color = color;
    }

    public HisCloth(String 衬衫, double v, String ol, String 红色, int i) {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ClothStyle getStyle() {
        return style;
    }

    public void setStyle(ClothStyle style) {
        this.style = style;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
