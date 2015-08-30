package recommendation;

import enums.*;
import hibernate.elements.Color;
import recommendation.userSimilarity.Item;
import recommendation.userSimilarity.ItemWithTimeAndScore;
import recommendation.userSimilarity.ViewRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */

public class User {
    private int bodyTypeID;


    private BodyShape bodyShape = BodyShape.X;//X


    private ClothStyle bodyStyle;//韩版风格

    private int bodyHeight;//162

    private BodyFaceShape bodyFaceShape;//圆形

    private int bodyAge;//20

    private Personality bodyCharacter;//外向

    private int bodyWeight;//54KG


    private Color bodySkinColor;//偏白

    private Color bodyHairColor;
    private SkinColor skinColor;
    private ClothSize clothSize;
    private ViewRecord viewRecord;



//    private static Map<ClothType,Integer> clothType = new HashMap<>();



    //用户已经看的衣服
    private List<ItemWithTimeAndScore> items = new ArrayList<>();


    public User(int bodyAge, int bodyHeight, int bodyWeight, BodyShape bodyShape, BodyFaceShape bodyFaceShape,
                Personality bodyCharacter, Color bodySkinColor, Gender gender) {
        this.bodyShape = bodyShape;
        this.bodyHeight = bodyHeight;
        this.bodyFaceShape = bodyFaceShape;
        this.bodyAge = bodyAge;
        this.bodyCharacter = bodyCharacter;
        this.bodyWeight = bodyWeight;
        this.bodySkinColor = bodySkinColor;
        this.gender = gender;
    }

    private Gender gender;

//    private List<Color>


    public User() {
    }

    public void setBodyAge(int bodyAge) {
        this.bodyAge = bodyAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public BodyFaceShape getBodyFaceShape() {
        return bodyFaceShape;
    }

    public void setBodyFaceShape(BodyFaceShape bodyFaceShape) {
        this.bodyFaceShape = bodyFaceShape;
    }

    public void setSkinColor(SkinColor skinColor) {
        this.skinColor = skinColor;
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

    public WeightType getWeightType() {
       float BMI = (float)(bodyWeight/(float)(bodyHeight/100.0)* (bodyHeight/100.0));
       if(BMI<18.5)
       {
           return WeightType.偏瘦;
       }else if(BMI>=18.5&&BMI<25)
        {
            return WeightType.标准;
        }
        else if(BMI>=25 && BMI <28)
        {
            return WeightType.偏胖;
        }
        else if(BMI>=28)
        {
            return WeightType.肥胖;
        }else {
           throw new IllegalArgumentException("Sorry , May be something wrong about weight and height");
       }
    }

    public Color getBodySkinColor() {
        return bodySkinColor;
    }

    public void setBodySkinColor(Color bodySkinColor) {
        this.bodySkinColor = bodySkinColor;
    }

    public SkinColor getSkinColor()
    {
        int r= this.bodySkinColor.getRed();
        int g =this.bodySkinColor.getGreen();
        int b = this.bodySkinColor.getBlue();
        float diff[] = new float[4];
        diff[0] = (r - 0)*(r - 0)+(g-0)*(g-0)+(b-0)*(b-0);
        diff[1] = (r - 255)*(r - 255)+(g-0)*(g-0)+(b-0)*(b-0);
        diff[2] = (r - 255)*(r - 255)+(g-255)*(g-255)+(b-255)*(b-255);
        diff[3] = (r - 255)*(r - 255)+(g-255)*(g-255)+(b-0)*(b-0);
        float temp = 0f;
        for (int i = diff.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (diff[j + 1] <diff[j])
                {
                    temp = diff[j];
                    diff[j] = diff[j + 1];
                    diff[j + 1] = temp;
                }
            }
        }
        SkinColor skincolor[] = SkinColor.values();
        for(int i =0 ; i<diff.length;i++)
        {
            if(diff[0] == diff[i])
            {
                return skincolor[i];
            }
        }
        throw   new IllegalArgumentException("Data of SkinColor may be illegal" );
    }

    public String toString() {
        return  this.getSkinColor() + ";" + this.getBodyShape() + ";" + this.getBodyFaceShape()+ ";" +
                this.getBodyCharacter();
    }

    public List<ItemWithTimeAndScore> getItems() {
        return items;
    }

    public void setItems(List<ItemWithTimeAndScore> items) {
        this.items = items;
    }

    public ViewRecord getViewRecord() {
        return viewRecord;
    }

    public void setViewRecord(ViewRecord viewRecord) {
        this.viewRecord = viewRecord;
    }
}
