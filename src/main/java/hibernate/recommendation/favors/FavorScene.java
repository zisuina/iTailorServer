package hibernate.recommendation.favors;

import hibernate.elements.Scene;

import javax.persistence.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Favor_Scenes")
public class FavorScene extends FavorElement {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sceneID_FK")
    private Scene scene;

    public FavorScene() {
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
