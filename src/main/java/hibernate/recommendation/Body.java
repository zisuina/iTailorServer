package hibernate.recommendation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "bodies")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bodyID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bodyID_FK")
    private List<BodyStatus> bodyStatusList = new ArrayList<>();

    public Body() {
    }

    public int getBodyID() {
        return bodyID;
    }

    public void setBodyID(int bodyID) {
        this.bodyID = bodyID;
    }


    public List<BodyStatus> getBodyStatusList() {
        return bodyStatusList;
    }

    public void setBodyStatusList(List<BodyStatus> bodyStatusList) {
        this.bodyStatusList = bodyStatusList;
    }
}
