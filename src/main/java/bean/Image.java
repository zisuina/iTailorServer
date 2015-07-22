package bean;

import javax.persistence.*;

/**
 * Created by liker on 10/07/2015 0010.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "address")
    private String address;

    public Image() {
    }

    public Image(String address) {
        this.address = address;
    }
}
