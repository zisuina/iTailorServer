package hibernate.recommendation.favorelements;

import hibernate.elements.ClothingMaterial;
import hibernate.recommendation.FavorElement;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_ClothingMaterials")
public class FavorClothingMaterial extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clothingMaterialID_FK")
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
