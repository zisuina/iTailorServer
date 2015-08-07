package recommendation.crystal.com.company;

import java.util.ArrayList;

/**
 * Created by crystal.liker on 2015/7/26.
 */
public class Clothes {
    ArrayList<Cloth> niceclothes= new ArrayList<Cloth>();
    public void addCloth(Cloth cloth)
    {
        niceclothes.add(cloth);
    }
    public void deleteCloth(Cloth cloth)
    {
        for(int i =0; i<niceclothes.size();i++)
        {
            if(cloth.equals(niceclothes.get(i)))
            {
                niceclothes.remove(i);
            }
        }
    }
}
