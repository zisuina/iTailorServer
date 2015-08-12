package recommendation.userSimilarity.util;

import enums.BodyFaceShape;
import enums.BodyShape;
import enums.Personality;
import enums.SkinColor;
import recommendation.User;

/**
 * Created by crystal.liker on 2015/8/10.
 */
public class CalculateUserDataSimilarity {

    public static float CalculateAllValueSimilarity(User user1,User user2)
    {
        return CalculateStringValueSimilarity(user1,user2)+CalculateNumericValueSimilarity(user1,user2);
    }

    final static int boundary1 = 4 ;
    final static int boundary2 = 8 ;
    final static int NumericAttributesNumber =3;
    static float attributes_weight[] = {0.1f,0.15f,0.05f,0.3f,0.1f,0.15f,0.15f};//应从数据库中获取 TODO
    // 年龄，身高，体重，   体型，脸型，性格，肤色，TODO发色（不包含衣服尺寸，身高体重决定尺寸）
    // 前三个为数值型，后4个为字符型
    static int length[] = new int[attributes_weight.length-NumericAttributesNumber];
    static public int count =2*(attributes_weight.length-NumericAttributesNumber);//记录两个用户属性的并集
    //在每个区间的不同值
    public static int GetEachAttributeScore(int user1_attribute, int user2_attribute)
    {
        int diff = Math.abs(user1_attribute-user2_attribute);
        if(diff>=0 && diff < boundary1)
        {
            return 0;
        }else if(diff>=boundary1&&diff<boundary2)
        {
            return 1;
        }else if(diff>= boundary2)
        {
            return 2;
        }else
            throw new IllegalArgumentException("The abstraction is illegal.");
    }

    public static int GetEachAttributeScore(float user1_attribute, float user2_attribute)
    {
        float diff = Math.abs(user1_attribute-user2_attribute);
        if(diff>=0 && diff < boundary1)
        {
            return 0;
        }else if(diff>=boundary1&&diff<boundary2)
        {
            return 1;
        }else if(diff>= boundary2)
        {
            return 2;
        }else
            throw new IllegalArgumentException("The abstraction is illegal.");
    }

    public static float CalculateNumericValueSimilarity(User user1,User user2)
    {
        float similarity = 0f;
            if(user1.getGender().equals(user2.getGender()))
            {
                similarity +=  GetEachAttributeScore(user1.getBodyAge(),user2.getBodyAge())*attributes_weight[0];
                similarity +=  GetEachAttributeScore(user1.getBodyHeight(),user2.getBodyHeight())*attributes_weight[1];
                similarity +=  GetEachAttributeScore(user1.getBodyWeight(),user2.getBodyWeight())*attributes_weight[2];
                return similarity;
            }else {
                return 0f;
            }
    }

    public static void CalculateCodeLongestLength()
    {
        BodyShape bodyShape[] = BodyShape.values();
        BodyFaceShape bodyFaceShape[] = BodyFaceShape.values();
        Personality personality[] = Personality.values();
        SkinColor skinColor[] = SkinColor.values();
        //TODO
        length[0]=Integer.toBinaryString(bodyShape.length-1).length() ;
        length[1]=Integer.toBinaryString(bodyFaceShape.length-1).length() ;
        length[2]=Integer.toBinaryString(personality.length-1).length() ;
        length[3]=Integer.toBinaryString(skinColor.length-1).length() ;

    }
    public static String FillBinaryString(String str,int len)
    {
        String a = "0";
        if(str.length()<len)
        {
            int diff = len - str.length();
            for(int i =0 ;i<diff; i++)
            {
                str=  a.concat(str);
            }
        }
        return str;
    }
    public  static String GetEachUserStringAttributeCode(User user)
    {
        CalculateCodeLongestLength();
        int attribute_len = 0;
        String str = "";
        String stri="";
        BodyShape bodyShape[] = BodyShape.values();
        BodyFaceShape bodyFaceShape[] = BodyFaceShape.values();
        Personality personality[] = Personality.values();
        SkinColor skinColor[] = SkinColor.values();
        for(int i  = 0 ; i< bodyShape.length;i++)
        {
            if(user.getBodyShape().equals(bodyShape[i]))
            {
                str+= FillBinaryString(Integer.toBinaryString(i),length[0]);
               // System.out.println("str1 "+str);
            }
        }
        for(int i  = 0 ; i<bodyFaceShape.length;i++)
        {
            if(user.getBodyFaceShape().equals(bodyFaceShape[i]))
            {   str +=  FillBinaryString(Integer.toBinaryString(i), length[1]);
           // System.out.println("str2 "+str);
           }
        }
        for(int i  = 0 ; i< personality.length;i++)
        {
            if(user.getBodyCharacter().equals(personality[i]))
            {
                str += FillBinaryString(Integer.toBinaryString(i),length[2]);
              //  System.out.println("str3 "+str);
            }

        }
        for(int i  = 0 ; i< skinColor.length;i++)
        {
            if(user.getSkinColor().equals(skinColor[i]))
            {
                str += FillBinaryString(Integer.toBinaryString(i),length[3]);
               // System.out.println("str4 "+str);
            }

        }
        return str;

    }
    public static float CalculateStringValueSimilarity(User user1,User user2)
    {
        String user1_code= GetEachUserStringAttributeCode(user1);
        String user2_code = GetEachUserStringAttributeCode(user2);
        int diff = 0;
       // System.out.println(user1_code.length());
        for(int i =0; i<user1_code.length();i++)
        {
            if(user1_code.charAt(i)!=user2_code.charAt(i))
            {
                diff++;
            }
        }
        float avg_weight = 0f;
        for(int i =0; i<attributes_weight.length-NumericAttributesNumber;i++)
        {
            avg_weight += attributes_weight[NumericAttributesNumber+i];
        }
        avg_weight =  avg_weight/(float)user1_code.length();
        float similarity = diff*avg_weight;
       // System.out.println("similarity : "+similarity);
        return similarity;
    }


}
