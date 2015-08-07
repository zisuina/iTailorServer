package recommendation.crystal.information;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by crystal.liker on 2015/7/26.
 */

public class GetColor {
    /**
     * 读取Excel里的数据
     *
     * @param filePath
     * @return
     */
    String filePath = "..\\99.txt";

    public ArrayList<String> readColor(String type){
        ArrayList<String> name = new ArrayList();
        ArrayList color_r = new ArrayList();
        ArrayList color_g = new ArrayList();
        ArrayList color_b = new ArrayList();
        ArrayList English_name = new ArrayList();
        ArrayList sales_volume = new ArrayList();
        ArrayList<String> others = new ArrayList();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader( new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
               // int i =0;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] data = lineTxt.split(" ");
                      // i++;
                     //  System.out.println(""+i+" :"+data.length);
                    name.add(data[0]);
                    if(data.length>1)
                    {
                        color_r.add(data[1]);
                        color_g.add(data[2]);
                        color_b.add(data[3]);
                        English_name.add(data[4]);
                        others.add(data[5]);
                        sales_volume.add(data[6]);
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
        if(type.equalsIgnoreCase("name"))
        {
            return name;
        }else if(type.equalsIgnoreCase("r"))
        {
            return  color_r ;
        }else if(type.equalsIgnoreCase("g"))
        {
            return  color_g ;
        }else if(type.equalsIgnoreCase("b"))
        {
            return color_b ;
        }
        else if(type.equalsIgnoreCase("sales_volume"))
        {
            return sales_volume ;
        }
        return others;

    }
    public float[][] GetColorRGB(ArrayList selectionclor2)
    {
        ArrayList crg_name = readColor("name");
        ArrayList ori_r =  readColor("r");
        ArrayList ori_g =  readColor("g");
        ArrayList ori_b = readColor("b");
        ArrayList r = new ArrayList();
        ArrayList g = new ArrayList();
        ArrayList b = new ArrayList();
        for(int i =0;i<crg_name.size();i++)
        {
            for(int j =0 ; j<selectionclor2.size();j++)
            {
                if(selectionclor2.get(j).equals(crg_name.get(i)))
                {
                    r.add(ori_r.get(i));
                    g.add(ori_g.get(i));
                    b.add(ori_b.get(i));
                }
            }
        }
        float color[][] = new float[selectionclor2.size()][3];
        for(int i =0 ; i<selectionclor2.size();i++)
        {
            color[i][0]= Float.parseFloat(String.valueOf(r.get(i)));
            color[i][1]=  Float.parseFloat(String.valueOf(g.get(i)));
            color[i][2]=  Float.parseFloat(String.valueOf(b.get(i)));
        }
          return color;
    }
    public float[][] GetAllColorRGB()
    {
        ArrayList all_r = readColor("r");
        ArrayList all_g = readColor("g");
        ArrayList all_b = readColor("b");
        float[][] allcolor= new float[all_b.size()][3];
        for(int i =0; i<all_b.size();i++)
        {
            allcolor[i][0]=Float.parseFloat(String.valueOf(all_r.get(i)));
            allcolor[i][1]=Float.parseFloat(String.valueOf(all_g.get(i)));
            allcolor[i][2]=Float.parseFloat(String.valueOf(all_b.get(i)));
        }
        return allcolor;
    }

}
