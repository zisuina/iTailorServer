package hibernate.recommendation;

import javax.persistence.*;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "recommended_Resources")
public class RecommendedResource extends Resource {
    private boolean twoAsOne = false;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cloth_colorID_FK")
    private ClothingImage cloth;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pants_colorID_FK")
    private ClothingImage pants;
    private String recommendReason = "undefine";
    private float matchingRatio = 0.0f;

    public boolean isTwoAsOne() {
        return twoAsOne;
    }

    public void setTwoAsOne(boolean twoAsOne) {
        this.twoAsOne = twoAsOne;
    }

    public ClothingImage getCloth() {
        return cloth;
    }

    public void setCloth(ClothingImage cloth) {
        this.cloth = cloth;
    }

    public ClothingImage getPants() {
        return pants;
    }

    public void setPants(ClothingImage pants) {
        this.pants = pants;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason;
    }

    public float getMatchingRatio() {
        return matchingRatio;
    }

    public void setMatchingRatio(float matchingRatio) {
        this.matchingRatio = matchingRatio;
    }
}
