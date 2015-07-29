package hibernate.recommendation;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "favor_elements")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FavorElement{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int favorElementID;


    private int favorDegree;

    public int getFavorElementID() {
        return favorElementID;
    }

    public void setFavorElementID(int favorElementID) {
        this.favorElementID = favorElementID;
    }

    public int getFavorDegree() {
        return favorDegree;
    }

    public void setFavorDegree(int favorDegree) {
        this.favorDegree = favorDegree;
    }
}
