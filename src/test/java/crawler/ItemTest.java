package crawler;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ItemTest {

    Item item;
    @Before
    public void setUp() throws Exception {
//        item = new Item("44787408094");
//        item = new Item("44723853293");
        item = new Item("45480076081");
    }

    @Test
    public void testHibernate() throws Exception {
        item.maintain();
//        new BaseDAO<Item>().create(item);
        System.out.println("Please check you database record.");
    }
}