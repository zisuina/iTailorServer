package demo;

import javax.persistence.*;
import javax.persistence.OneToOne;

/**
 * Created by liker on 14/07/2015 0014.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity

@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    @OneToOne
    @JoinColumn(name="manager",insertable=true,unique=true)
    private Manager manager;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
