package bean;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;

/**
 * Created by liker on 08/07/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
@NamedQuery(name="dog by name",query = "select c from Dog c where c.name = :name")
@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }
    public String show(){
        return "My name is "+this.name+" wang wang~";
    }
}
