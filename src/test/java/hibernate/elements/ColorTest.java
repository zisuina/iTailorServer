package hibernate.elements;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ColorTest {

    @Test
    public void testGetColorDistance() throws Exception {
        Color color = new Color(0, 0, 0);
        Color another = new Color(255, 255, 255);
        assertEquals(195075.0, color.getColorDistance(another));
    }

    @Test
    public void testGetColorDistanceAbnormal() throws Exception {
        Color color = new Color(-1, 0, 0);
        Color another = new Color(257, 255, 255);
        assertEquals(0.0, color.getColorDistance(another));
    }


}