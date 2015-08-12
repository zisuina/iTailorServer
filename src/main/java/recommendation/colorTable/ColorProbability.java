package recommendation.colorTable;

import hibernate.elements.Color;
import javax.persistence.*;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "color_probabilities")
public class ColorProbability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int colorProbabilityID;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "colorID_FK")
    private Color color;
    private float probability;

    public ColorProbability(Color color, float probability) {
        this.color = color;
        this.probability = probability;
    }

    public ColorProbability() {
    }

    public int getColorProbabilityID() {
        return colorProbabilityID;
    }

    public void setColorProbabilityID(int colorProbabilityID) {
        this.colorProbabilityID = colorProbabilityID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }
}
