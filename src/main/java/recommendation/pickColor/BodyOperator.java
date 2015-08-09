package hibernate.recommendation;

import enums.*;
import hibernate.elements.Color;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "body_types")
public class BodyOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bodyTypeID;

    @Enumerated(EnumType.STRING)
    private BodyShape bodyShape = BodyShape.X;//X

    @Enumerated(EnumType.STRING)
    private ClothStyle bodyStyle;//韩版风格

    private int bodyHeight;//162
    @Enumerated(EnumType.ORDINAL)
    private FaceShape bodyFaceShape;//圆形

    private int bodyAge;//20
    @Enumerated(EnumType.STRING)
    private Personality bodyCharacter;//外向

    private int bodyWeight;//54KG

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skin_colorID_FK")
    private Color bodySkinColor;//偏白
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hair_colorID_FK")
    private Color bodyHairColor;

    @Enumerated(EnumType.STRING)
    private ClothSize clothSize;
    @Enumerated(EnumType.STRING)
    private Gender gender;


//    private List<Color>


    public BodyOperator() {
    }

    public int getBodyTypeID() {
        return bodyTypeID;
    }

    public void setBodyTypeID(int bodyTypeID) {
        this.bodyTypeID = bodyTypeID;
    }

    public BodyShape getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(BodyShape bodyShape) {
        this.bodyShape = bodyShape;
    }

    public ClothStyle getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(ClothStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(int bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public FaceShape getBodyFaceShape() {
        return bodyFaceShape;
    }

    public void setBodyFaceShape(FaceShape bodyFaceShape) {
        this.bodyFaceShape = bodyFaceShape;
    }

    public int getBodyAge() {
        return bodyAge;
    }


    public Personality getBodyCharacter() {
        return bodyCharacter;
    }

    public void setBodyCharacter(Personality bodyCharacter) {
        this.bodyCharacter = bodyCharacter;
    }

    public int getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public Color getBodySkinColor() {
        return bodySkinColor;
    }

    public void setBodySkinColor(Color bodySkinColor) {
        this.bodySkinColor = bodySkinColor;
    }

    public Color getBodyHairColor() {
        return bodyHairColor;
    }

    public void setBodyHairColor(Color bodyHairColor) {
        this.bodyHairColor = bodyHairColor;
    }

    public void setClothSize(ClothSize clothSize) {
        this.clothSize = clothSize;
    }

    private ClothSize getClothSize() {
        int height = this.bodyHeight;
        int weight = this.bodyWeight;
        if (this.gender == Gender.MALE) {
            if (height >= 175 && height < 155 && weight >= 100) {
                if ((height >= 175 && height < 155 && weight >= 140 && weight < 130)
                        || (height <= 175 && height > 165 && weight <= 160 && weight > 140)) {
                    if ((height >= 175 && height < 155 && weight >= 130 && weight < 120)) {
                        if ((height >= 175 && height < 165 && weight >= 110 && weight < 100)
                                || (height >= 175 && height <= 155 && weight > 120 && weight < 110)) {
                            if (height >= 165 && height < 155 && weight > 110 && weight < 100) {
                            } else return ClothSize.M;

                        } else return ClothSize.L;

                    } else return ClothSize.XL;
                } else return ClothSize.XXL;
            } else return ClothSize.S;
            return ClothSize.UNDEFINE;
        } else if (this.gender == Gender.FEMALE) {
            if (height <= 175 && height > 155 && weight <= 100) {
                return ClothSize.S;
            }
            if ((height <= 175 && height > 155 && weight <= 140 && weight > 130)
                    || (height <= 175 && height > 165 && weight <= 160 && weight > 140)) {
                return ClothSize.XXL;
            }
            if ((height <= 175 && height > 155 && weight <= 130 && weight > 120)) {
                return ClothSize.XL;
            }
            if ((height <= 175 && height > 165 && weight <= 110 && weight > 100)
                    || (height <= 175 && height >= 155 && weight < 120 && weight > 110)) {
                return ClothSize.L;
            }
            if (height <= 165 && height > 155 && weight < 110 && weight > 100) {
                return ClothSize.M;
            }
        }
        return ClothSize.UNDEFINE;
    }
}
