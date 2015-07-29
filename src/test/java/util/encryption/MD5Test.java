package util.encryption;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Created by liker on 29/07/2015 0029.
 * Group iTailor.hunters.neu.edu.cn
 */
public class MD5Test {
    private String imageURL = "G:\\Desktop\\JavaCrawler\\server\\iTailorServer\\src\\main\\webapp\\images\\123.png";
    @Test
    public void testBase64Encoder(){
        BASE64Encoder encoder = new BASE64Encoder();

        try {
            StringBuilder pictureBuffer = new StringBuilder();
            InputStream input = new FileInputStream(new File(imageURL));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            for(int len = input.read(temp); len != -1;len = input.read(temp)){
                out.write(temp, 0, len);
                pictureBuffer.append(encoder.encode(out.toByteArray()));
                //out(pictureBuffer.toString());
                out.reset();
            }

            out(pictureBuffer.toString());
            out("Encoding the picture Success");



            BASE64Decoder decoder = new BASE64Decoder();
            FileOutputStream write = new FileOutputStream(new File("G:\\Desktop\\JavaCrawler\\server\\iTailorServer\\src\\main\\webapp\\images\\123.png"));
            byte[] decoderBytes = decoder.decodeBuffer(pictureBuffer.toString());
            write.write(decoderBytes);
            out("Decoding the picture Success");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void out(Object o){
        System.out.println(o.toString());
    }
}