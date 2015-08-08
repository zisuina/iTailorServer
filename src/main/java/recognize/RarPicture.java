package recognize;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by KZoneOfX on 2015/8/7. 2015年8月7日19:08:09
 * 图片压缩
 */
public class RarPicture {

    /**
     * @see 压缩图片
     * @param base 根目录
     * @param imgPath 要压缩的图片路径(虚拟路径)
     * @param width 压缩宽
     * @param height 压缩高
     * @param percentage 是否等比例压缩,true则宽高比自动调整
     * @return String
     */
    public String reduce(String imgPath, int width, int height, boolean percentage) {
        try {
            File srcfile = new File( imgPath);
            BufferedImage src = ImageIO.read(srcfile);
            if (percentage) {
                double rate1 = ((double) src.getWidth(null)) / (double) width + 0.1;
                double rate2 = ((double) src.getHeight(null)) / (double) height + 0.1;
                double rate = rate1 > rate2 ? rate1 : rate2;
                width = (int) (((double) src.getWidth(null)) / rate);
                height = (int) (((double) src.getHeight(null)) / rate);
            }
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            image.getGraphics().drawImage(src.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING), 0, 0, null);
            String newFile = imgPath+"_"+height+"_New.jpg";
            FileOutputStream out = new FileOutputStream(newFile);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            image.flush();
            out.flush();
            out.close();
            src.flush();
            return newFile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
