package hibernate.recommendation.favors;

import hibernate.recommendation.FavorElement;
import hibernate.recommendation.Resource;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_Resources")
public class FavorResource extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "resourceID_FK")
    private Resource resource;
    public FavorResource() {
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
