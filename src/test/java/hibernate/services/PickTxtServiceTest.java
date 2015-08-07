package hibernate.services;

import hibernate.elements.Color;
import org.junit.Before;
import org.junit.Test;
import util.BaseDAO;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class PickTxtServiceTest {
    PickColorService pickColorService = null;
    @Before
    public void setUp() throws Exception {
        pickColorService = new PickColorService();
    }

    @Test
    public void testSettleIntoDB() throws Exception {
        pickColorService.settleIntoDB();
        assertEquals(99, new BaseDAO<Color>().list("select c from Color as c").size());
    }


    @Test
    public void testWhichColorIsTheClosestFor() throws Exception {
        Color color = pickColorService.whichColorIsTheClosestFor(0, 0, 0);
        System.out.println(color.getName_ch());
        Color color2 = pickColorService.whichColorIsTheClosestFor(255, 255, 255);
        System.out.println(color2.getName_ch());
        Color color3 = pickColorService.whichColorIsTheClosestFor(232, 127, 21);
        System.out.println(color3.getName_ch());
        Color color4 = pickColorService.whichColorIsTheClosestFor(200, 200, 200);
        System.out.println(color4.getName_ch());
    }
}