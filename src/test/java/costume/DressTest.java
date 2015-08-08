package costume;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class DressTest {
    Dress dress;

    @Before
    public void setUp() throws Exception {
        dress = new Dress("翻领", "插肩袖", "民族", "拼接群", "超长裙");
    }

    @Test
    public void testGetBinaryCode() throws Exception {
        System.out.println(dress.getBinaryCode());
        dress = new Dress("斜领", "灯笼袖", "朋克", "大摆型", "");
        System.out.println(dress.getBinaryCode());
    }
}