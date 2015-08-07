package recommendation.crystal.com.company;

/**
 * Created by crystal.liker on 2015/6/18.
 */
public class Men extends HumanData{

    public String GetColothSize( int weight , int height)
    {
        if(weight<=0&&height<=0)
        {
            throw new IllegalArgumentException("Body's info must be greater than 0");
        }
        String S ="S";
        String M ="M";
        String L ="L";
        String XL ="XL";
        String XXL ="XXL";
        if(height>=175 && height<155 &&weight >=100) {
            if((height>=175 && height<155 && weight >=140 && weight <130)
                    ||(height<=175 && height>165 && weight <=160 && weight >140)) {
                if((height>=175 && height<155 && weight >=130 && weight <120)) {
                    if((height>=175 && height<165 && weight >=110 && weight <100)
                            ||(height>=175 && height<=155 && weight >120 && weight <110)) {
                        if(height>=165 && height<155 && weight >110 && weight <100) {
                        }else  return M;

                    }else return L;

                }else return XL;
            }else return XXL;
        }else return S;
        return "soory" ;






    }

}
