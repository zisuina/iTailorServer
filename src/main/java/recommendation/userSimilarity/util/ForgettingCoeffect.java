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
    static final float ForgetfulSpeed = 0.3f;    //�����ٶ�
    static float mintime=0;                      //����ʱ���е��������ʱ��
    static float maxtime=0;                      //����ʱ���е���Զ����ʱ��
    static Date date = new Date(0);
    float diff_time [] ;
    static Timestamp start_timestamp = new Timestamp(date.getTime());
    /**
     * ��ȡ�����С�������ʱ��
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
    //�������ϵ��

    /**
     * �����������������ϵ��
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
