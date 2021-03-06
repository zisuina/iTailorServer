package hibernate.recommendation.favors;

import hibernate.elements.PriceRange;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_PriceRanges")
public class FavorPriceRange extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "priceRangeID_FK")
    private PriceRange priceRange;
    public FavorPriceRange() {
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }
}
