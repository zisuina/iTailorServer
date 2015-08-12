package recommendation.IGA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by crystal.liker on 2015/8/11.
 */
public class GetFakeDataBase {
    String filePath="C:\\Users\\crystal.liker\\Desktop\\WorkPlace\\iTailorServer\\src\\main\\java\\recommendation\\IGA\\Score.txt";
    public ArrayList readData(){
        ArrayList<String> Code= new ArrayList<String>();
        ArrayList<String> others= new ArrayList<String>();
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                InputStreamReader read = new InputStreamReader( new FileInputStream(file),encoding);//���ǵ������ʽ
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    Code.add(lineTxt);
                }
                read.close();
            }else{
                System.out.println("�Ҳ���ָ�����ļ�");
            }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
        return Code;

    }
}
