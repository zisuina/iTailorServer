package recommendation.crystal.com.company;

/**
 * Created by crystal.liker on 2015/7/26.
 */
public class WomanData extends HumanData {

    public String GetColothType( int weight , int height)
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
        if(height<=175 && height>155 &&weight <=100) {
            return S;
        }
        if((height<=175 && height>155 && weight <=140 && weight >130)
                ||(height<=175 && height>165 && weight <=160 && weight >140)) {
            return XXL;
        }
        if((height<=175 && height>155 && weight <=130 && weight >120)) {
            return XL;
        }
        if((height<=175 && height>165 && weight <=110 && weight >100)
                ||(height<=175 && height>=155 && weight <120 && weight >110)) {
            return L;
        }
        if(height<=165 && height>155 && weight <110 && weight >100) {
            return M;
        }   else
            return "Sorry,we should design for individually!";

    }
}
