package recommendation;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TxtServiceTest {

    TxtService txtService;

    @Before
    public void setUp() throws Exception {

        txtService = new TxtService();
    }

    @Test
    public void testSettleColorsIntoDB() throws Exception {
        txtService.settleColorsIntoDB();
    }

    @Test
    public void testSettleDressesIntoDB() throws Exception {
        txtService.settleDressesIntoDB();
    }

    @Test
    public void testSettleBDressesIntoDB() throws Exception {
        txtService.settleBDressesIntoDB();
    }

    @Test
    public void testSettleCoatsIntoDB() throws Exception {
        txtService.settleCoatsIntoDB();
    }

    @Test
    public void testSettlePantsIntoDB() throws Exception {
        txtService.settlePantsIntoDB();
    }

    @Test
    public void testSettleUClothIntoDB() throws Exception {
        txtService.settleUClothIntoDB();
    }

    @Test
    public void testSettleColorPrefixIntoDB() throws Exception {
        txtService.settleColorPrefixIntoDB();
    }
}