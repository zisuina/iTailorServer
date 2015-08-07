package recognize;

import crawler.Item;
import enums.MyPathManager;
import hibernate.recommendation.ClothingImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
public class LoadImage {

    public List<File> loadImageFromDisk(Item item) {
        List<File> files = new ArrayList<>();
        File imagePath = new File(MyPathManager.imagePath);
        if (!imagePath.exists()) {
            return files;
        }
        List<ClothingImage> clothingImages = item.getClothingImages();
        files.addAll(clothingImages.stream().map(clothingImage -> new File(imagePath + "\\" + clothingImage.getName() + ".jpg")).collect(Collectors.toList()));
        return files;
    }

    public List<String> loadImageFromWeb(Item item) {
        List<ClothingImage> clothingImages = item.getClothingImages();
        return clothingImages.stream().map(ClothingImage::getSource).collect(Collectors.toList());
    }

    public File loadImageFromURL(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            byte[] data = readInputStream(inStream);
            File imagePath = new File(MyPathManager.imagePath);
            if (!imagePath.exists()) {
                imagePath.mkdir();
            }
            File ImageFile = new File(imagePath + "\\temp_" + new Random().nextInt() + ".jpg");
            FileOutputStream outstream = new FileOutputStream(ImageFile);
            outstream.write(data);
            outstream.close();
            return new File(imagePath + "\\temp_" + new Random().nextInt() + ".jpg");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] readInputStream(InputStream instream) throws Exception {
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
