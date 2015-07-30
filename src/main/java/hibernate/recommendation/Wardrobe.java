package hibernate.recommendation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "Wardrobes")
public class Wardrobe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wardrobeID;
    private String name ="Honey Wardrobe";
    private boolean isPublic = false;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wardrobeID_FK")
    private List<Wardrobe> subWardrobeList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "wardrobeID_FK")
    private List<Resource> resources = new ArrayList<>();

    public Wardrobe() {
    }

    public int getWardrobeID() {
        return wardrobeID;
    }

    public void setWardrobeID(int wardrobeID) {
        this.wardrobeID = wardrobeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Wardrobe> getSubWardrobeList() {
        return subWardrobeList;
    }

    public void setSubWardrobeList(List<Wardrobe> subWardrobeList) {
        this.subWardrobeList = subWardrobeList;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
