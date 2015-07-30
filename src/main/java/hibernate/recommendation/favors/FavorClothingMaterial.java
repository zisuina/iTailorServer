package hibernate.recommendation.favors;

import hibernate.elements.ClothingMaterial;
import hibernate.recommendation.FavorElement;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_Clothing_Materials")
public class FavorClothingMaterial extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clothingMaterialID_FK",columnDefinition = "int default 0")
    private ClothingMaterial clothingMaterial= new ClothingMaterial();
    public FavorClothingMaterial() {
    }

    public ClothingMaterial getClothingMaterial() {
        return clothingMaterial;
    }

    public void setClothingMaterial(ClothingMaterial clothingMaterial) {
        this.clothingMaterial = clothingMaterial;
    }
}
