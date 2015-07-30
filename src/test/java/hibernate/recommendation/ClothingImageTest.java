package hibernate.recommendation;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ClothingImageTest {
    @Test
    public void testClothingImageHibernateBasic(){
        ClothingImage clothingImage = new ClothingImage();

        new BaseDAO<ClothingImage>().create(clothingImage);

    }

}