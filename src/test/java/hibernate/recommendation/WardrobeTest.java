package hibernate.recommendation;

import org.junit.Test;
import util.BaseDAO;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class WardrobeTest {
    @Test
    public void testWardrobeHibernateBasic(){
        Wardrobe rootWardrobe = new Wardrobe();
        Wardrobe subWardrobe = new Wardrobe();
        rootWardrobe.getSubWardrobeList().add(subWardrobe);
        Resource rootResource = new Resource();
        rootResource.setDescription("hello");
        Resource subResource = new Resource();
        subResource.setDescription("world");
        rootWardrobe.getResources().add(rootResource);
        subWardrobe.getResources().add(subResource);
        subWardrobe.setIsPublic(true);
        new BaseDAO<Wardrobe>().create(rootWardrobe);
    }


}