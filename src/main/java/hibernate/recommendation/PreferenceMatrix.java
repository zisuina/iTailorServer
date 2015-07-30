package hibernate.recommendation;

import hibernate.recommendation.favors.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Preference_Matrix")
public class PreferenceMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int preferenceID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorColor> colorPreference = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorStyle> stylePreference = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorScene> scenePreference = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorPriceRange> pricePreference = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorTimeRange> timePreference = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorClothingMaterial> materialPreference = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<FavorResource> resourcePreference = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferenceID_FK")
    private List<Resource> favourResourceList = new ArrayList<>();

    public int getPreferenceID() {
        return preferenceID;
    }

    public void setPreferenceID(int preferenceID) {
        this.preferenceID = preferenceID;
    }

    public List<FavorColor> getColorPreference() {
        return colorPreference;
    }

    public void setColorPreference(List<FavorColor> colorPreference) {
        this.colorPreference = colorPreference;
    }

    public List<FavorStyle> getStylePreference() {
        return stylePreference;
    }

    public void setStylePreference(List<FavorStyle> stylePreference) {
        this.stylePreference = stylePreference;
    }

    public List<FavorScene> getScenePreference() {
        return scenePreference;
    }

    public void setScenePreference(List<FavorScene> scenePreference) {
        this.scenePreference = scenePreference;
    }

    public List<FavorPriceRange> getPricePreference() {
        return pricePreference;
    }

    public void setPricePreference(List<FavorPriceRange> pricePreference) {
        this.pricePreference = pricePreference;
    }

    public List<FavorTimeRange> getTimePreference() {
        return timePreference;
    }

    public void setTimePreference(List<FavorTimeRange> timePreference) {
        this.timePreference = timePreference;
    }

    public List<FavorClothingMaterial> getMaterialPreference() {
        return materialPreference;
    }

    public void setMaterialPreference(List<FavorClothingMaterial> materialPreference) {
        this.materialPreference = materialPreference;
    }

    public List<FavorResource> getResourcePreference() {
        return resourcePreference;
    }

    public void setResourcePreference(List<FavorResource> resourcePreference) {
        this.resourcePreference = resourcePreference;
    }

    public List<Resource> getFavourResourceList() {
        return favourResourceList;
    }

    public void setFavourResourceList(List<Resource> favourResourceList) {
        this.favourResourceList = favourResourceList;
    }
}
