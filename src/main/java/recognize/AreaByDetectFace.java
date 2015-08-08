package recognize;

import enums.MyPathManager;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KZoneOfX on 2015/8/7.
 */
public class AreaByDetectFace {
    public void run(String fileurl) throws AWTException, IOException {

        ArrayList<Color> colors = getColorsFromTxt();
        Queue<ColorVote> colorVoteQueue=new PriorityQueue<ColorVote>(99,voteNumberComparator);
        File file = new File(fileurl);
        BufferedImage bufferedImage= ImageIO.read(file);
        Map<String ,ColorArea> map=getArea(fileurl);            //获得四个取色区域
        for (Map.Entry<String , ColorArea> entry:map.entrySet()) {          //遍历四个取色区域
            System.out.println(entry.getValue().toString());
            ColorArea colorArea=entry.getValue();
            for (int i = colorArea.getLeftTopX(); i <colorArea.getRightDownX() ; i++) {
                for (int j = colorArea.getLeftTopY()   ; j < colorArea.getRightDownY(); j++) {
                    int[] rgb = new int[3];
                    rgb[0] = (bufferedImage.getRGB(i,j) & 0xff0000 ) >> 16 ;
                    rgb[1] = (bufferedImage.getRGB(i,j) & 0xff00 ) >> 8 ;
                    rgb[2] = (bufferedImage.getRGB(i,j) & 0xff );
                    Color color=getColorByRGB(rgb[0],rgb[1],rgb[2],colors);     //获取像素点 颜色
                    addColorVoteToQueue(colorVoteQueue, changeColorToColorVote(color));
                }
            }
        }
        //得出前五个颜色
        for (int i = 0; i < 5; i++) {
            if (colorVoteQueue.isEmpty()){
                break;
            }
            System.out.println(colorVoteQueue.poll().toString());
        }

    }

    public ColorVote changeColorToColorVote(Color color){
        ColorVote vote = new ColorVote(color.getName_ch(),1);
        vote.setName_en(color.getName_en());
        vote.setRed(color.getRed());
        vote.setGreen(color.getGreen());
        vote.setBlue(color.getBlue());
        vote.refresh();
        return vote;
    }
    //优先队列的 排序依据
    public Comparator<ColorVote> voteNumberComparator =new Comparator<ColorVote>() {
        public int compare(ColorVote o1, ColorVote o2) {
            return (int)(o2.getVoteNumber()-o1.getVoteNumber());
        }
    };
    //向优先队列中添加数据
    private void addColorVoteToQueue(Queue<ColorVote> colorVoteQueue,ColorVote colorVote){
        if (colorVoteQueue.isEmpty()){
            colorVoteQueue.add(colorVote);
            return;
        }
        for (ColorVote vote:colorVoteQueue){
            if (vote.getName_ch().endsWith(colorVote.getName_ch())){

                colorVoteQueue.remove(vote);
                int num=vote.getVoteNumber();
                num++;
                vote.setVoteNumber(num);
                colorVoteQueue.add(vote);
                return;
            }
        }
        colorVoteQueue.add(colorVote);
    }


    //通过距离 对比颜色
    public Color getColorByRGB(int red,int green,int blue,ArrayList<Color> colors){
        Color rightColor=null;
        int minAbs=getDistanceRgb(red, green, blue, colors.get(0));
        for(Color c:colors){
            if (c.getBlue()==blue&&
                    c.getRed()==red&&
                    c.getGreen()==green){
//                System.out.println("suitable  "+c.toString());
                return c;
            }else {
                if (getDistanceRgb(red, green, blue, c)<=minAbs){
                    rightColor=c;
                    minAbs=getDistanceRgb(red, green, blue, c);
                }
            }
        }
//        System.out.println("minDistance:"+minAbs+"\t"+rightColor.toString());
        return rightColor;
    }

    //获得与目标颜色的距离之和
    public Integer getDistanceRgb(int red,int green,int blue,Color c){
        return (int)Math.sqrt(Math.pow(red - c.getRed(), 2)+Math.pow(blue-c.getBlue(), 2)+Math.pow(green-c.getGreen(),2));
    }

    //获得与目标颜色的绝对值之和
    public Integer getMinAbsRgb(int red,int green,int blue,Color c){
        return Math.abs(c.getRed()-red)+Math.abs(c.getBlue() -blue)+Math.abs(c.getGreen()-green);
    }

    //get the clothes area
    public Map<String ,ColorArea> getArea(String fileurl){
        System.out.println("\nRunning AreaByDetectFace");
        System.out.println(getClass().getResource("..\\lbpcascade_frontalface.xml").getPath());
        String xmlfilePath=getClass().getResource("..\\lbpcascade_frontalface.xml").getPath().substring(1);
        CascadeClassifier faceDetector = new CascadeClassifier(xmlfilePath);
//    Mat image = Highgui.imread(getClass().getResource("RedCloth.PNG").getPath().substring(1));
        Mat image= Highgui.imread(fileurl);
        // Detect faces in the image.
        // MatOfRect is a special container class for Rect.
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        //store left,right,mid,down  four areas
        HashMap<String, ColorArea> areaMap=new HashMap<String, ColorArea>();
        for (Rect rect : faceDetections.toArray()) {
            areaMap.put("right",
                    new ColorArea((rect.x + rect.width), (int) (rect.y + 1.5 * (rect.height)),
                            (int)(rect.x + 1.7 * (rect.width)), (rect.y + 2 * (rect.height))));
            areaMap.put("left",
                    new ColorArea((int)(rect.x- 0.7*(rect.width)), (int) (rect.y + 1.5 * (rect.height)),
                            (rect.x ), (rect.y + 2 * (rect.height))));
            areaMap.put("mid",
                    new ColorArea((int) (rect.x - 0.5 * (rect.width)), (rect.y + 2 * (rect.height)),
                            (int) (rect.x + 1.5 * (rect.width)), (rect.y + 3 * (rect.height))));
            areaMap.put("down",
                    new ColorArea((rect.x), (rect.y + 3 * (rect.height)),
                            (rect.x + rect.width), (rect.y) + 4 * (rect.height)));
            System.out.println("heigth:" + rect.height + " width:" + rect.width);
        }
        // Save the visualized detection.
        String filename = fileurl+"deal.png";
        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, image);
        return areaMap;
    }

    //get colors  from the 99.txt
    public ArrayList<Color> getColorsFromTxt() throws IOException {
        ArrayList<Color> colors=new ArrayList<Color>();
            Color color;
        String fileUrl = MyPathManager.colorsPath;
        File file= new File(fileUrl);
        String regexCN = "[\u4E00-\u9FA5]{1,6}";
        String regexEN = "[A-Za-z]{1,20}";
        String regexNUM = "[0-9]{1,3}";
        Matcher matcher=null;
        Pattern pattern = null;
        InputStreamReader inputStreamReader = new InputStreamReader( new FileInputStream(file),"UTF-8");//考虑到编码格式
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String read=null,result="";
        ArrayList<Integer> rgbs=new ArrayList<Integer>();
        while (null!=(read=bufferedReader.readLine())){
            result="";
            if (null!=read){
                //
                pattern=Pattern.compile(regexCN);
                matcher=pattern.matcher(read);
                while (matcher.find()){
                    result=matcher.group(0);
                }
                color=new Color(result.trim());
                result="";
                pattern=Pattern.compile(regexNUM);
                matcher=pattern.matcher(read);
                while (matcher.find()){
                    rgbs.add(Integer.parseInt(matcher.group(0).trim()));
                }
                color.setRed(rgbs.get(0));
                color.setGreen(rgbs.get(1));
                color.setBlue(rgbs.get(2));

                pattern=Pattern.compile(regexEN);
                matcher=pattern.matcher(read);
                while (matcher.find()){
                    result=matcher.group(0);
                }
                color.setName_en(result.trim());
                color.refresh();
//                System.out.println(color);
                colors.add(color);
                rgbs.clear();
            }
        }
        if (null!=bufferedReader) {
            bufferedReader.close();
        }
        if (null!=inputStreamReader){
            inputStreamReader.close();
        }
        return colors;
    }
}
