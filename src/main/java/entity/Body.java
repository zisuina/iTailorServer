package entity;

import resource.message.BodyStatus;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "body")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "userID")
    private int userID;
    @Column(name = "bodyStatusList")
    private List<BodyStatus> bodyStatusList;

}
