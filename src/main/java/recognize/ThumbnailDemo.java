package recognize;

import net.coobird.thumbnailator.Thumbnails;
import java.io.IOException;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ThumbnailDemo {
    public static void main(String[] args) throws IOException {
//        指定大小进行缩放
        Thumbnails.of(".\\src\\main\\webapp\\images\\88.jpg")
                .size(80,80)
                .toFile(".\\src\\main\\webapp\\images\\new111.jpg");
//        Thumbnails.of(".\\src\\main\\webapp\\images\\456.jpg")
//                .size(2560, 2048)
//                .toFile(".\\src\\main\\webapp\\images\\new456.jpg");
        //keepAspectRatio(false)默认是按照比例缩放的
//        Thumbnails.of(".\\src\\main\\webapp\\images\\456.jpg")
//                .size(80,80)
//                .keepAspectRatio(false)
//                .toFile(".\\src\\main\\webapp\\images\\456.jpg");
        //rotate(角度),正数：顺时针负数：逆时针
//        Thumbnails.of(".\\src\\main\\webapp\\images\\678.jpg")
//                .size(800,800)
//                .rotate(90)
//                .toFile(".\\src\\main\\webapp\\images\\678.jpg");

//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .size(1280,1024)
//                .rotate(-90)
//                .toFile("c:/a380_rotate-90.jpg");

        //watermark(位置，水印图，透明度)
//        Thumbnails.of(".\\src\\main\\webapp\\images\\777.jpg")
//                .size(800, 800)
//                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(".\\src\\main\\webapp\\images\\123.jpg")), 0.5f)
//                .outputQuality(1.0f)
//                .toFile(".\\src\\main\\webapp\\images\\new777.jpg");

//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .size(1280,1024)
//                .watermark(Positions.CENTER,ImageIO.read(new File("images/watermark.png")),0.5f)
//                .outputQuality(0.8f)
//                .toFile("c:/a380_watermark_center.jpg");

        //sourceRegion()
//
////图片中心400*400的区域
//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .sourceRegion(Positions.CENTER,400,400)
//                .size(200,200)
//                .keepAspectRatio(false)
//                .toFile("c:/a380_region_center.jpg");
//
////图片右下400*400的区域
//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .sourceRegion(Positions.BOTTOM_RIGHT,400,400)
//                .size(200,200)
//                .keepAspectRatio(false)
//                .toFile("c:/a380_region_bootom_right.jpg");
//
////指定坐标
//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .sourceRegion(600,500,400,400)
//                .size(200,200)
//                .keepAspectRatio(false)
//                .toFile("c:/a380_region_coord.jpg");
//        //outputFormat(图像格式)
//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .size(1280,1024)
//                .outputFormat("png")
//                .toFile("c:/a380_1280x1024.png");
//
//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .size(1280,1024)
//                .outputFormat("gif")
////                .toFile("c:/a380_1280x1024.gif");
//
//        //toOutputStream(流对象)
//        OutputStream os = new FileOutputStream("c:/a380_1280x1024_OutputStream.png");
//        Thumbnails.of("images/a380_1280x1024.jpg")
//                .size(1280, 1024)
//                .toOutputStream(os);
//        ///asBufferedImage()返回BufferedImage
//        BufferedImage thumbnail = Thumbnails.of("images/a380_1280x1024.jpg")
//                .size(1280,1024)
//                .asBufferedImage();
//        ImageIO.write(thumbnail, "jpg", new File("c:/a380_1280x1024_BufferedImage.jpg"));

        //场景一：图片尺寸不变，修改图片文件类型
//        Thumbnails.of("F:\\image\\IMG_20131229_114806.png")
//                .scale(1f)
//                .outputFormat("jpg")
//                .toFile("F:\\image\\output\\IMG_20131229_114806");
//        //：图片尺寸不变，压缩图片文件大小
//        Thumbnails.of("F:\\image\\IMG_20131229_114806.png")
//                .scale(1f)
//                .outputQuality(0.25f)
//                .outputFormat("jpg")
//                .toFile("F:\\image\\output\\IMG_20131229_114806");
//        //utputQuality：输出的图片质量，范围：0.0~1.0，1为最高质量。
//        // 注意使用该方法时输出的图片格式必须为jpg（即outputFormat("jpg")。
//        // 其他格式我没试过，感兴趣的自己可以试试）。否则若是输出png格式图片，则该方法作用无效【这其实应该算是bug】。
//
////        场景三：压缩至指定图片尺寸（例如：横400高300），不保持图片比例
//        Thumbnails.of("F:\\image\\IMG_20131229_114806.png")
//                .forceSize(400, 300)
//                .toFile("F:\\image\\output\\IMG_20131229_114806");

    }



}


