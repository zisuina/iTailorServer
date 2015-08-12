package recommendation.userSimilarity.util;


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





    public static float UserRecordSimilarity(ViewRecord viewRecord1,ViewRecord viewRecord2){
        //TODO
        return 0.0f;
    }








    //TODO 数据的获取
    static Item item1 = new Item();
    static Item item2 = new Item();
    static  Item item3 = new Item();
    static  User user1= new User();
    static   Calendar calendar1 = Calendar.getInstance();
    static  Calendar calendar2 = new GregorianCalendar(2015,8,11,0,0,0);
    static  Calendar calendar3= new GregorianCalendar(2015,8,10,0,0,0);
    static  Calendar calendar4 = new GregorianCalendar(2015,8,9,0,0,0);
    static  Date date1 = calendar1.getTime();
    static  Date start_date = new Date(0);
//    long daterange = data.getTime() - test.getTime();
    static  Date data2 = calendar2.getTime();
    static  Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
    static  Timestamp start_timestamp = new Timestamp(start_date.getTime());
    static  Timestamp timestamp3 = new Timestamp(data2.getTime());
    static  Timestamp timestamp4 = new Timestamp(calendar3.getTime().getTime());
    static  Timestamp timestamp5 = new Timestamp(calendar4.getTime().getTime());

    static View view1 =  new View(item1,timestamp1);
    static View view2 = new View(item2,timestamp3);
    static View view3 = new View(item1,timestamp4);
    static View view4 = new View(item2,timestamp5);
    static ArrayList<View> views1 = new ArrayList<View>(){{add(view1); add(view2);}};
    static ArrayList<View> views2 = new ArrayList<View>(){{add(view3); add(view4);}};

    ViewRecord user1_record = new ViewRecord(user1,views1);

    static final float ForgetfulSpeed = 0.3f;
    static float mintime=0;
    static float maxtime=0;
    float diff_time [] = new float[views1.size()];
    String total_string1="";
    String total_string2="";
    ArrayList<String> properties = new ArrayList<>();

    /**
     * 获取最大，最小评分相对时间
     */
    public  void GetMaxMinTime()
    {
        long time = 1000*3600*24;
        for(int i =0; i< views1.size();i++)
        {
            diff_time [i]=(views1.get(i).getTimestamp().getTime()-start_timestamp.getTime())/time;

        }
        QickSort quick = new QickSort();
        float sort_time[]=diff_time;
        quick.quick(sort_time);
        mintime = sort_time[0];
        maxtime = sort_time[diff_time.length-1];
        //System.out.println(mintime+" "+maxtime);
    }
    //获得遗忘系数

    /**
     * 获得遗忘函数的所有系数
     * @return
     */
    public float[] GetForgettingCoefficient()
    {
        GetMaxMinTime();
        float[] result = new float[views1.size()];
        for(int i =0; i<result.length;i++)
        {
            result[i] = ForgetfulSpeed*((diff_time[i]-mintime)/(maxtime-mintime))+1-ForgetfulSpeed;
       //     System.out.println( result[i]);
        }
        return result;
    }

    /**
     * 初始化本用户的浏览记录，将所有浏览记录储存在String里
     */
    public void GetAllThisUserRecordProperties()
    {

        for(int i =0; i<views1.size();i++) {
            List list = views1.get(i).getItem().getProperties();
            String str1= "";
            for(int j =0; i<list.size();j++)
            {
                str1 += list.toString() + ";";
            }
            total_string1 += str1;
        }
    }

    /**
     * 初始化对比用户的浏览几率。
     */
    public void GetAllTheOtherUserRecordProperties()
    {

        for(int i =0; i<views2.size();i++) {
            List list = views2.get(i).getItem().getProperties();
            String str1= "";
            for(int j =0; i<list.size();j++)
            {
                str1 += list.toString() + ";";
            }
            total_string2 += str1;
        }
    }

    /**
     * 使用COS来计算两用户的浏览记录的相似度
     * 对原先的算法进行了修改，原先的方法存在不能一一对应相应的Item.
     * @return
     */
    public  float CalculateSimilarity()
    {
        GetAllThisUserRecordProperties();
        GetAllTheOtherUserRecordProperties();
        SimilarDegreeByCos similarDegreeByCos = new SimilarDegreeByCos();
        float similarity =(float)(1- similarDegreeByCos.getSimilarDegree(total_string1,total_string2));
        return similarity;
   //      System.out.println( similarDegreeByCos.getSimilarDegree(total_string1,total_string2));
    }

}
