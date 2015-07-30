package hibernate.elements;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "clothing_shapes")
public class ClothingShape extends Element{
    public ClothingShape() {
    }
}
