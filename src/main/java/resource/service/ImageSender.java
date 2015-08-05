package resource.service;

import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

/**
 * Created by liker on 05/08/2015 0005.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ImageSender {
    private File myfile;
    private String myfileFileName;
    private String myfileContentType;

    public String show() throws Exception {
        File file = new File(".\\src\\main\\java\\resource\\service\\test.jpg");
        InputStream is = FileUtils.openInputStream(file);
        byte[] bytes = readInputStream(is);
        return null;
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
