package hibernate.recommendation.favors;

import hibernate.elements.ClothingShape;

import javax.persistence.*;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_Clothing_Shapes")
public class FavorClothingShape {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clothingMaterialID_FK")
    private ClothingShape clothingShape;

    public FavorClothingShape() {
    }

    public ClothingShape getClothingShape() {
        return clothingShape;
    }

    public void setClothingShape(ClothingShape clothingShape) {
        this.clothingShape = clothingShape;
    }
}
