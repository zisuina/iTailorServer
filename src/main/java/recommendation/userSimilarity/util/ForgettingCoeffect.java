package recommendation.userSimilarity.util;

import recommendation.userSimilarity.ViewRecord;
import util.QickSort;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by crystal.liker on 2015/8/15.
 */
public class ForgettingCoeffect {
    static final float ForgetfulSpeed = 0.3f;    //遗忘速度
    static float mintime=0;                      //评论时间中的最近评论时间
    static float maxtime=0;                      //评论时间中的最远评论时间
    static Date date = new Date(0);
    float diff_time [] ;
    static Timestamp start_timestamp = new Timestamp(date.getTime());
    /**
     * 获取最大，最小评分相对时间
     */
    public  void GetMaxMinTime(ViewRecord viewRecord)

    {

        start_timestamp.setTime(date.getTime());
        long time = 1000*3600*24;
        for(int i =0; i< viewRecord.getClothingImages().size();i++)
        {
            diff_time [i]=(viewRecord.getClothingImages().get(i).getTimestamp().getTime()
                    -start_timestamp.getTime())/time;

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
    public float[] GetForgettingCoefficient(ViewRecord viewRecord)
    {
        GetMaxMinTime(viewRecord);
        float[] result = new float[viewRecord.getClothingImages().size()];
        for(int i =0; i<result.length;i++)
        {
            result[i] =ForgetfulSpeed- ForgetfulSpeed*((diff_time[i]-mintime)/(maxtime-mintime));
            //     System.out.println( result[i]);
        }
        return result;
    }
}
