package recommendation.IGA;

import costume.EnCodeService;
import recommendation.TxtService;

/**
 * Created by crystal.liker on 2015/8/11.
 */
public class Test {
    public static void main(String[] args) {
        TxtService txtService = new TxtService();
        txtService.settleUClothIntoDB();
        EnCodeService enCodeService = new EnCodeService();
        System.out.println(enCodeService.getPropertyBinary("collar_type","UCloth","圆领"));


    }

}
