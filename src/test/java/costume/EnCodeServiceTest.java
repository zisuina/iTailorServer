package costume;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class EnCodeServiceTest {

    EnCodeService enCodeService;

    @Before
    public void setUp() throws Exception {
        enCodeService = new EnCodeService();

    }

    @Test
    public void testGetBinaryPropertyMap() throws Exception {
        enCodeService.getBinaryPropertyMap("button", "Coat");
        enCodeService.getBinaryPropertyMap("collar_type", "Coat");
        enCodeService.getBinaryPropertyMap("length", "Coat");
        enCodeService.getBinaryPropertyMap("sleeve_type", "Coat");
        enCodeService.getBinaryPropertyMap("style", "Coat");
        enCodeService.getBinaryPropertyMap("collar_type", "Dress");
        enCodeService.getBinaryPropertyMap("dress_length", "Dress");
        enCodeService.getBinaryPropertyMap("shape", "Dress");
        enCodeService.getBinaryPropertyMap("sleeve_type", "Dress");
        enCodeService.getBinaryPropertyMap("style", "Dress");
        enCodeService.getBinaryPropertyMap("length", "Pant");
        enCodeService.getBinaryPropertyMap("shape", "Pant");
        enCodeService.getBinaryPropertyMap("style", "Pant");
        enCodeService.getBinaryPropertyMap("waist_height", "Pant");
        enCodeService.getBinaryPropertyMap("thickness", "Pant");
        enCodeService.getBinaryPropertyMap("collar_type", "UCloth");
        enCodeService.getBinaryPropertyMap("length", "UCloth");
        enCodeService.getBinaryPropertyMap("pattern", "UCloth");
        enCodeService.getBinaryPropertyMap("sleeve_type", "UCloth");
        enCodeService.getBinaryPropertyMap("style", "UCloth");
        enCodeService.getBinaryPropertyMap("dress_length", "HDress");
        enCodeService.getBinaryPropertyMap("shape", "HDress");
        enCodeService.getBinaryPropertyMap("style", "HDress");
        enCodeService.getBinaryPropertyMap("waist_height", "HDress");

    }


    @Test
    public void testGetPropertyBinaryMap() throws Exception {
        enCodeService.getPropertyBinaryMap("style", "HDress");
    }

    @Test
    public void testGetPropertyBinary() throws Exception {
        System.out.println(enCodeService.getPropertyBinary("waist_height", "HDress","中腰"));
        System.out.println(enCodeService.getPropertyBinary("dress_length", "HDress","长裙"));
        System.out.println(enCodeService.getPropertyBinary("style", "Coat","OL"));
    }
}