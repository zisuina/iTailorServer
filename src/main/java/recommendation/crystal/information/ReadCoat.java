package recommendation.crystal.information;

/**
 * Created by crystal.liker on 2015/7/26.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCoat {
    /**
     * 读取Excel里的数据
     *
     * @param filePath
     * @return
     */
    String filePath = "..\\Coat.txt";

    public ArrayList readCoat(String type){
        ArrayList<String> collar = new ArrayList();
        ArrayList<String> sleeve = new ArrayList();
        ArrayList<String> style = new ArrayList();
        ArrayList<String> thickness = new ArrayList();
        ArrayList<String> length = new ArrayList();
        ArrayList<String> button = new ArrayList();
        ArrayList<String> others = new ArrayList();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader( new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //int i =0;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] data = lineTxt.split(" ");
                  //  i++;
                    if(!data[0].equals(""))
                    sleeve.add(data[0]);
                    //  System.out.println(i+" "+data.length);
                    if(data.length>1)
                    {
                        if(!data[1].equals(""))
                        length.add(data[1]);
                        //    System.out.println(data[1]);
                        if(data.length>2)
                        {
                            if(!data[2].equals(""))
                            thickness.add(data[2]);
                            //    System.out.println(data[2]);
                            if(data.length>3)
                            {
                                if(!data[3].equals(""))
                               collar.add(data[3]);
                                //         System.out.println(data[3]);
                                if(data.length>4)
                                {
                                    if(!data[4].equals(""))
                                    button.add(data[4]);
                                    //         System.out.println(data[3]);
                                    if(data.length>5)
                                    {
                                        if(!data[5].equals(""))
                                        style.add(data[5]);
                                        //         System.out.println(data[3]);
                                    }
                                }
                            }
                        }
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
        if(type.equalsIgnoreCase("sleeve"))
        {
            return sleeve;
        }else if(type.equalsIgnoreCase("length"))
        {
            return length;
        }else if(type.equalsIgnoreCase("thickness"))
        {
            return  thickness;
        }else if(type.equalsIgnoreCase("collar"))
        {
            return collar;
        }else if(type.equalsIgnoreCase("button"))
        {
            return button;
        }else if(type.equalsIgnoreCase("style"))
        {
            return style;
        }else
        {
            return others;
        }
    }

}