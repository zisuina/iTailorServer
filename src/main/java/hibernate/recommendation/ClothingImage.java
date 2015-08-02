package hibernate.recommendation;

import hibernate.elements.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "clothing_Images")
public class ClothingImage extends Resource{
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "colorID_FK")
    private Color color;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "styleID_FK")
    private Style style;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clothingMaterialID_FK")
    private ClothingMaterial clothingMaterial;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shapeID_FK")
    private ClothingShape shape;
    private float price = 0.0f;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "resourceId_FK")
    private Set<Element> elements = new HashSet<>();

    private String name = "undefine";
    private String format = "JPEG";

    public ClothingImage() {
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public ClothingMaterial getClothingMaterial() {
        return clothingMaterial;
    }

    public void setClothingMaterial(ClothingMaterial clothingMaterial) {
        this.clothingMaterial = clothingMaterial;
    }

    public ClothingShape getShape() {
        return shape;
    }

    public void setShape(ClothingShape shape) {
        this.shape = shape;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
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


}
