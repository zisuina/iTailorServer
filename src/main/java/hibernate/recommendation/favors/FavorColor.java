package hibernate.recommendation.favors;


import hibernate.elements.Color;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_Colors")
public class FavorColor extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "colorID_FK")
    private Color color;
    public FavorColor() {
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
