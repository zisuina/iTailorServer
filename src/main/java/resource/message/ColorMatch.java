package resource.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "colorMatch")
public class ColorMatch {
    @XmlElement(name = "primary")
    private Color primaryColor;
    @XmlElement(name = "secondary")
    private Color secondaryColor;
    @XmlElement(name = "ratio")
    private float ratio;
    public ColorMatch() {
    }
}
