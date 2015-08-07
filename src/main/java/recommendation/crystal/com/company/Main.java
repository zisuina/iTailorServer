package recommendation.crystal.com.company;


import recommendation.crystal.algorithm.FindSuitableColorForYou;
import recommendation.crystal.algorithm.IGA;

public class Main {

    public static void main(String args[]) {
      //  Weather info = new Weather();
       // String weather = info.getWeather("北京");
      //  System.out.println(weather);
//        Match a = new Match();
//        a.IfBodyType("X","韩版风格",162,"圆形",20,"外向",54,"偏白");
//     //   ReadCoat test = new ReadCoat();
//      //  GetColor color= new GetColor();
//       // ArrayList<String> test1 = color.readColor("name");
//       // color.GetColorRGB();
//        String str1 = "偏白 青年 打球 O";
//        String str2 = "偏黑 青年 旅游 O";
//        String str3 = "Delivery of silver arrived in a silver truck";
//        String str4 = "Shipment of gold arrived in a truck";
//        String str5 = "gold gold gold gold gold gold";
        IGA iga = new IGA();
        iga.GetScore();
        iga.TypeOfComponent("ucloth");
        iga.CalculateFitness();
        for (int i = 0; i <1000; i++)
        {
            iga.CalculateFitness();
            iga.select();
            iga.cross();
            iga.mutation();
            iga.gernation=i;
        }
        iga.CalculatSimilarity();
        iga.GetKeyword("ucloth");
           FindSuitableColorForYou findSuitableColorForYou=new FindSuitableColorForYou();
       //findSuitableColorForYou.GetColdClor();
       //  findSuitableColorForYou.GetWarmClor();
       // findSuitableColorForYou.GetRGBdiffClor("b");
        findSuitableColorForYou.GetHighSColor("l");
     }
 }
