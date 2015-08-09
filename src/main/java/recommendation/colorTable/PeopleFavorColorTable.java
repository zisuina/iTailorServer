package recommendation.colorTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "people_favor_color_table")
public class PeopleFavorColorTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int peopleFavorColorTableID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "colorProbabilityID_FK")
    private List<ColorProbability> colorProbabilities = new ArrayList<>();

    public PeopleFavorColorTable(List<ColorProbability> colorProbabilities) {
        this.colorProbabilities = colorProbabilities;
    }

    public int getPeopleFavorColorTableID() {
        return peopleFavorColorTableID;
    }

    public void setPeopleFavorColorTableID(int peopleFavorColorTableID) {
        this.peopleFavorColorTableID = peopleFavorColorTableID;
    }

    public List<ColorProbability> getColorProbabilities() {
        return colorProbabilities;
    }

    public void setColorProbabilities(List<ColorProbability> colorProbabilities) {
        this.colorProbabilities = colorProbabilities;
    }
}
