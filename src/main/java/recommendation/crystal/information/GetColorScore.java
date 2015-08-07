package recommendation.crystal.information;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by crystal.liker on 2015/8/4.
 */
public class GetColorScore  {
    String filePath = "..\\NiceColor.txt";
    public ArrayList<String> readCoat(String type){
        ArrayList<String> color = new ArrayList();
        ArrayList<String>  pixel= new ArrayList();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader( new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] data = lineTxt.split(" ");
                 //   System.out.println(data.length);
                    color.add(data[0]);
                    if(data.length>1)
                    {pixel.add(data[1]);
                      //  System.out.println(data.length);
                    }

                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        if(type.equalsIgnoreCase("color"))
        {
            return color;
        }else if(type.equalsIgnoreCase("pixel"))
        {
            return pixel;
        }else
        {
            return pixel;
        }

    }
}
