package recommendation.userSimilarity;

/**
 * Created by crystal.liker on 2015/8/12.
 */
public class ClothComponent {
    private String component;
    private float effect;


    public ClothComponent(String component, float effect) {
        this.component = component;
        this.effect = effect;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public float getEffect() {
        return effect;
    }

    public void setEffect(float effect) {
        this.effect = effect;
    }
}
