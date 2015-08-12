package recommendation.userSimilarity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/12.
 */
public class ClothBinaryString {
    private List<ClothComponent> components = new ArrayList<>();

    public List<ClothComponent> getComponents() {
        return components;
    }

    public void setComponents(List<ClothComponent> components) {
        this.components = components;
    }

    public String toString() {
        String str = "";
        for (ClothComponent component : components) {
            str += component.getComponent();
        }
        return str;
    }

}
