package recommendation.userSimilarity.util;


import crawler.Property;
import hibernate.recommendation.User;
import recommendation.userSimilarity.Item;
import recommendation.userSimilarity.View;
import recommendation.userSimilarity.ViewRecord;
import recommendation.userSimilarity.util.SimilarDegreeByCos;
import util.QickSort;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by crystal.liker on 2015/8/10.
 */
public class CalculateUserRecordSimilarity {

    /**
     * 使用COS来计算两用户的浏览记录的相似度
     * 对原先的算法进行了修改，原先的方法存在不能一一对应相应的Item.
     *
     * @return
     */

    public static float UserRecordSimilarity(ViewRecord viewRecord1, ViewRecord viewRecord2) {
        String str1 = GetAllThisUserRecordProperties(viewRecord1);
        String str2 = GetAllThisUserRecordProperties(viewRecord2);
        SimilarDegreeByCos similarDegreeByCos = new SimilarDegreeByCos();
        float similarity = (float) (1 - similarDegreeByCos.getSimilarDegree(str1, str2));
       // System.out.println("record similarity" + similarity);
        return similarity;
    }

    //TODO 数据的获取


    static String total_string1 = "";
    ArrayList<String> properties = new ArrayList<>();


    /**
     * 初始化本用户的浏览记录，将所有浏览记录储存在String里
     */
    public static String GetAllThisUserRecordProperties(ViewRecord viewRecord) {

        for (int i = 0; i < viewRecord.getClothingImages().size(); i++) {
            List<Property> list = viewRecord.getClothingImages().get(i).getItem().getProperties();

            String str1 = "";
            for (int j = 0; j < list.size(); j++) {
                str1 += String.valueOf(list.get(j).getTheValue()) + " ";
            }
            total_string1 += str1;
        }

        return total_string1;
    }


}
