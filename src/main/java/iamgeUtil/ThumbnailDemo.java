package iamgeUtil;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ThumbnailDemo {
    public static void main(String[] args) throws IOException {
//        Thumbnails.of(".\\src\\main\\webapp\\images\\123.jpg");
        File _file = new File(".\\src\\main\\webapp\\images\\123.jpg"); //读入文件
        Image src = javax.imageio.ImageIO.read(_file); //构造Image对象
        int wideth = src.getWidth(null); //得到源图宽
        int height = src.getHeight(null); //得到源图长
        BufferedImage tag = new BufferedImage(wideth / 2, height / 2, BufferedImage.TYPE_INT_RGB);
        tag.getGraphics().drawImage(src, 0, 0, wideth / 2, height / 2, null); //绘制缩小后的图
        FileOutputStream out = new FileOutputStream(".\\src\\main\\webapp\\images\\newfile.jpg"); //输出到文件流
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(tag); //近JPEG编码
    //System.out.print(width+"*"+height);
        out.close();
    }


}


