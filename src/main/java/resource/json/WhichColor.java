package resource.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "whichColor")
public class WhichColor {
    @XmlElement(name = "name")
    private String color;
    @XmlElement(name = "source")
    private String source;
    public WhichColor() {
    }
}
