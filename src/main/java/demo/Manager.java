package demo;

import javax.persistence.*;
import javax.persistence.OneToOne;

/**
 * Created by liker on 14/07/2015 0014.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "manager")
public class Manager {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department", nullable = false)
    private Department department;
    @OneToOne(mappedBy = "manager", optional = false)
    private Department department2;

    public Department getDepartment2() {
        return department2;
    }

    public void setDepartment2(Department department2) {
        this.department2 = department2;
    }
}
