package recommendation.IGA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by crystal.liker on 2015/8/11.
 */
//TODO
public class GetFakeSocre {
    String filePath="C:\\Users\\crystal.liker\\Desktop\\WorkPlace\\iTailorServer\\src\\main\\java\\recommendation\\IGA\\PantScore";
    public ArrayList readScore(String style){
        ArrayList<String> code= new ArrayList<String>();
        ArrayList<String> score= new ArrayList<String>();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader( new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] data = lineTxt.split(" ");
                    code.add(data[0]);
                    score.add(data[1]);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        if(style.equalsIgnoreCase("ID"))
        {
            return code;
        }else if(style.equalsIgnoreCase("score"))
        {
            return score;
        }else {
            return  score;
        }
    }
}
