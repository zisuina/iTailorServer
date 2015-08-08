package recognize;

/**
 * Created by KZoneOfX on 2015/8/6.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        int i = 256;
        System.loadLibrary("opencv_java249");
        String fileUri = "C:\\Users\\liker\\Videos\\Pictures\\234.jpg";
        String new_fileUri = new RarPicture().reduce(fileUri, i, i, true);
        new AreaByDetectFace().run(new_fileUri);
//        new AreaByDetectFace().run(fileUri);
    }
}
