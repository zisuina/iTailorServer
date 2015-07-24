package resource.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "color")
public class Color {
    @XmlElement(name = "red")
    private float redValue;
    @XmlElement(name = "blue")
    private float blueValue;
    @XmlElement(name = "green")
    private float greenValue;
    @XmlElement(name = "condition")
    private String condition;
    public Color() {
    }
}
