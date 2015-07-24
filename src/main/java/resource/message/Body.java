package resource.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "body")
public class Body {
    @XmlElement(name = "userID")
    private String userID;
    @XmlElement(name = "timestamp")
    private Timestamp timestamp;
    @XmlElement(name = "skin")
    private String skin;
    @XmlElement(name = "height")
    private int height;
    @XmlElement(name = "waistHeight")
    private int waistHeight;
    @XmlElement(name = "crotchHeight")
    private int crotchHeight;
    @XmlElement(name = "bust")
    private int bust;
    @XmlElement(name = "waist")
    private int waist;
    @XmlElement(name = "hips")
    private int hips;
    @XmlElement(name = "armLength")
    private int armLength;
    @XmlElement(name = "legLength")
    private int legLength;
    @XmlElement(name = "crossShoulder")
    private int crossShoulder;
    @XmlElement(name = "calfGirth")
    private int calfGirth;
    @XmlElement(name = "thighCircumference")
    private int thighCircumference;
    @XmlElement(name = "headBodyRatio")
    private float headBodyRatio;
    @XmlElement(name = "bodyProportion")
    private float bodyProportion;
    @XmlElement(name = "footLength")
    private float footLength;
    @XmlElement(name = "physicalAge")
    private int physicalAge;
    @XmlElement(name = "heartRate")
    private int heartRate;
    @XmlElement(name = "wristGirth")
    private int wristGirth;
    @XmlElement(name = "fatRatio")
    private int fatRatio;
    @XmlElement(name = "mood")
    private int mood;

    public Body() {
    }
}
