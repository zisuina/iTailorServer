package crawler;
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
    public void getImage(String image) {
        URL url;
        try {
            url = new URL("http://" + image);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] data = readInputStream(inStream);//得到图片的二进制数据

            String name = String.valueOf(Math.random() * 100);
            System.out.println(name);

            File ImageFile = new File(".\\src\\main\\webapp\\images\\" + name + ".png");//存到本地硬盘名为“captain”
            FileOutputStream outstream = new FileOutputStream(ImageFile);
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
