package crawler;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class SellCountGetterTest {

    @Test
    public void testGetSellCount() throws Exception {
        assertEquals(86, new ItemMaintainer(new Item("45493455074")).getSellCount());
    }
}