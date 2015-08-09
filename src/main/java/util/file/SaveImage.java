package util.file;

import java.io.*;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class SaveImage {
    public static boolean settleIntoDISK(File f, String imageName) {
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            File imagePath = new File("..\\images");
            if (!imagePath.exists()) {
                imagePath.mkdir();
            }
            File ImageFile = new File(imagePath + "\\" + imageName + ".jpg");
            fos = new FileOutputStream(ImageFile);
            fis = new FileInputStream(f);
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[2048];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            byte[] data = bos.toByteArray();
            fos.write(data);
            fis.close();
            bos.close();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
