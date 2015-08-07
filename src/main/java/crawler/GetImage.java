package crawler;

import hibernate.recommendation.ClothingImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class GetImage {
    public void getImage(String itemName, ClothingImage clothingImage) {
        String image = clothingImage.getSource();
        URL url;
        try {
            url = new URL("http://" + image);
            clothingImage.setSource(url.toString());
            clothingImage.setName(itemName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] data = readInputStream(inStream);//得到图片的二进制数据

//            String realPath = application.getRealPath("/images");
//            System.out.println("Path:" + realPath + "\\" + imageName);

//            File ImageFile = new File(".\\src\\main\\webapp\\images\\" + itemName + ".jpg");
            File imagePath = new File("..\\images");
            if (!imagePath.exists()) {
                imagePath.mkdir();
            }

            File ImageFile = new File(imagePath + "\\" + itemName + ".jpg");
            System.out.println("FILE Path@ "+ImageFile.getAbsolutePath());
            //我手动创建了目录


            FileOutputStream outstream = new FileOutputStream(ImageFile);
            clothingImage.setSizeB(data.length);
            outstream.write(data);
            outstream.close();
            System.out.println("One OK!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static byte[] readInputStream(InputStream instream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1204];
        int len;
        while ((len = instream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        instream.close();
        return outStream.toByteArray();
    }
}
