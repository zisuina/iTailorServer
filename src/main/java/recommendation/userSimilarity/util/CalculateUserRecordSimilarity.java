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
     * ʹ��COS���������û��������¼�����ƶ�
     * ��ԭ�ȵ��㷨�������޸ģ�ԭ�ȵķ������ڲ���һһ��Ӧ��Ӧ��Item.
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

    //TODO ���ݵĻ�ȡ


    static String total_string1 = "";
    ArrayList<String> properties = new ArrayList<>();


    /**
     * ��ʼ�����û��������¼�������������¼������String��
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
