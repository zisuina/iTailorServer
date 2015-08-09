package recommendation.colorTable;

import hibernate.elements.Color;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "choose_color_while_favor_color_table")
public class ChooseColorWhileFavorColorTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int colorProbabilityID;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "choose_colorID_FK")
    private Color chooseColor;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "colorProbabilityID_FK")
    private List<ColorProbability> colorProbabilities = new ArrayList<>();

    public ChooseColorWhileFavorColorTable() {
    }

    public int getColorProbabilityID() {
        return colorProbabilityID;
    }

    public void setColorProbabilityID(int colorProbabilityID) {
        this.colorProbabilityID = colorProbabilityID;
    }

    public Color getChooseColor() {
        return chooseColor;
    }

    public void setChooseColor(Color chooseColor) {
        this.chooseColor = chooseColor;
    }

    public List<ColorProbability> getColorProbabilities() {
        return colorProbabilities;
    }

    public void setColorProbabilities(List<ColorProbability> colorProbabilities) {
        this.colorProbabilities = colorProbabilities;
    }
}
