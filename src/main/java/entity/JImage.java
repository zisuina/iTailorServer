package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@XmlRootElement(name = "image")
public class JImage {
    @XmlElement(name = "userID")
    private String userID;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "format")
    private String format;
    @XmlElement(name = "size")
    private String size;
    @XmlElement(name = "description")
    private String description;
    public JImage() {
    }

    public String getUserID() {
        return userID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
