package costume;

import hibernate.elements.Color;
import util.BaseDAO;

import javax.persistence.*;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "nice_colors")
public class NiceColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int niceColorID;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "first_colorID_FK")
    private Color color_one;
    private int ratio_one;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "second_colorID_FK")
    private Color color_two;
    private int ratio_two;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "third_colorID_FK")
    private Color color_three;
    private int ratio_three;


    public NiceColor(Color color_one, int ratio_one, Color color_two, int ratio_two, Color color_three, int ratio_three) {
        this.color_one = color_one;
        this.ratio_one = ratio_one;
        this.color_two = color_two;
        this.ratio_two = ratio_two;
        this.color_three = color_three;
        this.ratio_three = ratio_three;
    }

    public NiceColor() {
    }

    public Color getColor_one() {
        return color_one;
    }

    public void setColor_one(Color color_one) {
        this.color_one = color_one;
    }

    public int getRatio_one() {
        return ratio_one;
    }

    public void setRatio_one(int ratio_one) {
        this.ratio_one = ratio_one;
    }

    public Color getColor_two() {
        return color_two;
    }

    public void setColor_two(Color color_two) {
        this.color_two = color_two;
    }

    public int getRatio_two() {
        return ratio_two;
    }

    public void setRatio_two(int ratio_two) {
        this.ratio_two = ratio_two;
    }

    public Color getColor_three() {
        return color_three;
    }

    public void setColor_three(Color color_three) {
        this.color_three = color_three;
    }

    public int getRatio_three() {
        return ratio_three;
    }

    public void setRatio_three(int ratio_three) {
        this.ratio_three = ratio_three;
    }

    public void settleIntoDB(){
        new BaseDAO<NiceColor>().create(this);
    }
}
