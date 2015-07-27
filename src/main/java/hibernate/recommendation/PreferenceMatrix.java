package hibernate.recommendation;

import hibernate.elements.*;
import javafx.scene.Scene;

import java.util.List;
import java.util.Map;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class PreferenceMatrix {
    private int userID;
    private Map<Color,Integer> colorPreference;
    private Map<Style,Integer> stylePreference;
    private Map<Scene,Integer> scenePreference;
    private Map<PriceRange,Integer> pricePreference;
    private Map<TimeRange,Integer> timePreference;
    private Map<ClothingMaterial,Integer> materialPreference;
    private Map<ClothingComponent,Integer> componentPreference;
    private Map<Resource,Integer> resourcePreference;
    private List<Resource> favourResourceList;
}
