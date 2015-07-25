package util.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by liker on 09/07/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class FileCreate {
    public static void main(String[] args) {
//        String path1 = FileCreate.class.getResource("").toString();
//        System.out.println(path1);
        String path = ".\\images";
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        String fileName="test3.txt";
        File file = new File(f,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println(file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
