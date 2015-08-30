package recommendation.userSimilarity;

import enums.ClothType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/12.
 */
public class ClothBinaryString {
    private List<ClothComponent> components = new ArrayList<>();
    private ClothType clothType = ClothType.Undefine;

    public List<ClothComponent> getComponents() {
        return components;
    }

    public void setComponents(List<ClothComponent> components) {
        this.components = components;
    }

    public ClothType getClothType() {
        return clothType;
    }

    public void setClothType(ClothType clothType) {
        this.clothType = clothType;
    }

    public String toString() {
        String str = "";
        for (ClothComponent component : components) {
            str += component.getComponent();
        }
        return str;
    }

}
