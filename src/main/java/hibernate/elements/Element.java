package hibernate.elements;

import javax.persistence.*;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "elements")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int elementID;
    private String name = "";
    private String description = "";
//    private String type = "";

    public Element() {
        this.elementID = 0;
    }

    public int getElementID() {
        return elementID;
    }

    public void setElementID(int elementID) {
        this.elementID = elementID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
