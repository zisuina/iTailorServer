package recommendation.crystal.com.company;

import recommendation.crystal.algorithm.ColorPossibility;
import recommendation.crystal.algorithm.RgbToHsl;
import recommendation.crystal.information.GetColor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by crystal.liker on 2015/7/2.
 */
public class Match {
   private String[] dress ={"连衣裙","长袖连衣裙","棉麻连衣裙","牛仔连衣裙","针织连衣裙","礼服","旗袍"};
    RgbToHsl get_hsl_color= new RgbToHsl();
    GetColor getcolor = new GetColor();
    ArrayList<String> colors_name= getcolor.readColor("name");
    public int[][] info_color= {{0,1,1,0,1,1,0,1,1,1,1,1},{1,1,1,1,1,1,0,0,1,1,1,0},{0,0,1,1,0,1,1,1,1,1,1,1},
            {0,0,1,0,1,1,0,1,1,1,1,1},{1,0,1,0,1,1,1,1,1,1,1,1},{1,0,1,0,0,1,1,1,1,1,1,1},{0,1,0,1,0,1,1,1,1,1,1,1},
            {1,1,0,0,0,1,1,1,1,1,1,1}, {0,1,0,0,0,1,0,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1}, {1,1,0,0,0,1,1,1,1,1,1,1},
            {1,1,0,0,0,1,1,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1},{1,0,0,0,0,1,1,1,1,1,1,1},
            {0,1,0,0,0,1,0,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1},
            {1,1,0,0,0,1,1,1,1,1,1,1}, {1,1,0,0,0,1,1,1,1,1,1,1},{1,1,0,0,0,1,1,1,1,1,1,1},{0,1,0,0,0,1,0,1,1,1,1,1},
            {1,1,1,0,0,1,1,1,0,0,0,1},{1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,0,0,1,1,1,1,0,0,1},  {1,1,1,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1},{1,0,1,1,0,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1},{1,0,1,1,0,1,1,1,1,0,0,1},
            {1,1,1,1,1,1,1,1,1,0,0,1},{1,0,0,1,0,1,1,1,0,0,0,1},{0,0,1,1,1,1,0,1,1,1,1,1}, {0,0,1,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1},{1,0,1,1,0,1,1,1,1,0,0,1},
            {1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1}, {1,0,1,1,0,1,1,1,1,0,0,1},{1,0,1,1,0,1,1,1,1,0,0,1},
            {0,0,1,1,0,1,1,1,1,1,1,1},{0,0,1,1,0,1,1,1,1,0,0,1},{1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,0,0,1,1,1,0},
            {0,0,1,1,1,1,1,1,1,1,1,1},{1,1,1,0,1,1,0,0,1,1,1,0},{1,1,1,1,1,1,0,0,1,1,1,0},{0,1,1,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1},{0,1,1,1,0,1,1,1,1,1,1,1},
            {1,1,1,0,1,1,0,0,1,1,1,0},{1,1,1,0,1,1,0,0,1,1,1,0},{1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,0,1,1,0,0,1,1,1,0},
            {1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1},{0,1,1,0,1,1,0,1,1,0,0,1},{0,1,1,0,1,1,0,1,1,1,1,1},
            {0,1,1,0,1,1,0,1,1,1,1,1},{0,1,1,0,1,1,0,0,1,1,1,0},{0,1,0,0,1,1,0,1,1,1,1,1},{0,1,1,0,1,1,0,0,1,1,1,0},
            {0,1,1,0,1,1,0,1,1,1,1,1},{1,1,0,1,1,1,1,1,1,1,1,1},{0,1,1,0,1,1,0,1,1,1,1,1}, {0,0,1,0,1,1,0,1,1,1,1,1},
            {0,0,1,1,1,1,0,1,1,1,1,1},{0,1,1,0,1,1,0,1,1,1,1,1},{0,0,1,0,1,1,0,1,1,0,0,1},{0,0,1,0,1,1,0,0,1,1,1,0},
            {0,1,1,1,1,1,0,0,1,1,1,0},{1,1,0,1,1,1,1,1,1,1,1,1},{0,1,1,1,1,1,0,1,1,1,1,1},{1,1,1,0,1,1,1,1,0,0,0,1},
            {1,0,1,0,0,1,1,1,0,0,0,1},{0,0,1,1,1,1,0,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1}, {1,0,1,0,1,1,1,1,1,1,1,1},
            {1,0,1,1,0,1,1,1,0,0,0,1},{1,1,1,0,1,1,1,1,1,0,0,1},{1,1,1,0,0,1,1,1,1,1,1,1},{0,0,1,0,1,1,0,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},{1,1,0,0,1,1,1,1,0,0,0,1},{1,0,0,1,1,1,1,1,1,0,0,1},{1,0,0,1,1,1,1,1,1,0,0,1},
            {1,0,0,1,1,1,1,1,1,1,1,1},{1,0,0,1,1,1,1,1,1,1,1,1},{1,0,1,1,1,1,1,1,1,1,1,1}, {1,0,1,1,1,1,1,1,1,1,1,1}};
   Weather info = new Weather();
 //   int weather = Integer.parseInt(info.getWeather("沈阳"));
   int weather = 26;
    /**
     @根据体型，天气，身高，风格，脸型决定一套衣服的检索词
     @ 检索词： keyword1 指上衣  keyword2指半身裙或者裤装    keyword3 秋冬季的外套
     @return void
     */

    public int GetColor(String skin_color, double weight , double height, int age,String character)

    {
        ColorPossibility colorPossibility = new ColorPossibility();
        ArrayList slectionClor = colorPossibility.GetSlectionColor();
        float [] possibility = colorPossibility.CalculateFinalTable();
        Random radom = new Random();
        int place=-1;
        float count = radom.nextFloat();
        String str="";
        float te = 0;
        for(int i =0 ; i<possibility.length;i++)
        {
            te +=possibility[i];
            if(count< te && count>= te-possibility[i])
            {
                //  System.out.println("aaa:"+slectionClor.get(i));
                for(int j =0;j<colors_name.size();j++)
                {
                    if(slectionClor.get(i).equals(colors_name.get(j)))
                    {
                        place=j;
                    }
                }
            }
        }
        return place;

       /*
       int suitable_num[]= new int[100];
       //get color skin
       if(skin_color.equals("偏白"))
       {
           str=str+"0000";
       }
       if(skin_color.equals("偏黄"))
       {
           str=str+"0001";
       }
       if(skin_color.equals("偏红"))
       {
           str=str+"0010";
       }
       if(skin_color.equals("偏黑"))
       {
           str=str+"0011";
       }
       //Caculate by weight and height;

       double BMI=0;
       BMI=weight/(height*height);
       if(BMI<18)
       {
           str=str+"0100";
       }
       if(BMI>=18&&BMI<=25)
       {
           str=str+"0101";
       }
       if(BMI>25)
       {
           str=str+"0110";
       }
       //get age
       if(age>=18&&age<=40)
       {
           str=str+"0111";
       }
       if(age>=41&&age<=65)
       {
           str=str+"1000";
       }
       if(age>=66)
       {
           str=str+"1001";
       }
       //Get the character  introverted // extroverted
       if(character.equals("内向"))
       {
           str=str+"1010";
       }
       if(character.equals("外向"))
       {
           str=str+"1011";
       }
        /*
        analyse the string

       int color_num;
       int body_num;
       int gap_num;
       int character_num;
       color_num= Integer.parseInt(str.substring(0, 4), 2);
       body_num= Integer.parseInt(str.substring(4, 8), 2);
       gap_num= Integer.parseInt(str.substring(8, 12), 2);
       character_num= Integer.parseInt(str.substring(12, 16), 2);
       for(int i = 0 ;i<99;i++)
       {
           if(info_color[i][color_num]== 1)
           {
               if(info_color[i][body_num]== 1)
               {
                   if(info_color[i][gap_num]== 1)
                   {
                       if(info_color[i][character_num]== 1)
                       {
                           suitable_num[i+1]=1;
                       }
                   }
               }
           }
       }
       ArrayList list = new ArrayList();
       for(int i = 0 ;i<99;i++)
       {
           if(suitable_num[i+1] != 0)
           {
               list.add(i+1);
           }
       }
       int result = (int)(Math.random()*list.size());
       return (int)(list.get(result));*/
    }

    /**
   @ Input the first clor of cloth
    @ return suitable clor of next cloth
     */
    public String GetStuitableColor(int corlor_unm)
    {
        if(corlor_unm <=0 && corlor_unm> 99)
        {
            throw new IllegalArgumentException("There are only 99 colors");
        }
        ColorPossibility colorPossibility = new ColorPossibility();
        ArrayList slectionclorformatch = colorPossibility.GetSlectionColor2();
        GetColor getColor = new GetColor();
        ArrayList r = getColor.readColor("r");
        ArrayList g = getColor.readColor("g");
        ArrayList b = getColor.readColor("b");
        float[][] data = new float[1][3];
        data[0][0]=Float.parseFloat(String.valueOf(r.get(corlor_unm)));
        data[0][1]=Float.parseFloat(String.valueOf(g.get(corlor_unm)));
        data[0][2]=Float.parseFloat(String.valueOf(b.get(corlor_unm)));
        float[][] test=getcolor.GetColorRGB(slectionclorformatch);
        RgbToHsl hsl = new RgbToHsl();
        float clor_data[][] =  hsl.GetAllHSB(data);
        float[][] hsb_test = hsl.GetAllHSB(test);
        //色调配色
       // System.out.println(hsb_test.length);
        ArrayList suit_num = new ArrayList();
        for(int i =1;i<=hsb_test.length;i++) {
            if (clor_data[0][0] <= 345 && clor_data[0][0] >= 15) {
                if ((hsb_test[i - 1][0] < (clor_data[0][0]) + 15) && ((hsb_test[i - 1][0]) > (clor_data[0][0] - 15))) {
                    suit_num.add(i);
                } else if ((hsb_test[corlor_unm - 1][0] > 345 && hsb_test[corlor_unm - 1][0] <= 360) || (hsb_test[corlor_unm - 1][0] < 15 && hsb_test[corlor_unm - 1][0] >= 0)) {
                    if ((hsb_test[i - 1][0] < 15 && hsb_test[i - 1][0] >= 0) || (hsb_test[i - 1][0] > 345 && hsb_test[i - 1][0] <= 360))
                    {
                        suit_num.add(i);
                    }
                }
            }
        }
        //明度饱和度配色
        for(int i =1;i<hsb_test.length;i++) {
            for (int j = 1; j < 3; j++) {
                if (clor_data[0][j] <= 0.95 && clor_data[0][j] >= 0.05) {
                    if ((clor_data[0][j] < (hsb_test[corlor_unm - 1][j]) + 0.05) && clor_data[0][j] > (hsb_test[corlor_unm - 1][j] - 0.05)) {
                        suit_num.add(i);}
                    } else if ((clor_data[0][j] > 0.95 && clor_data[0][j] <= 1) || (clor_data[0][j] < 0.05 && clor_data[0][j] >= 0)) {
                        if ((hsb_test[i - 1][j] < 0.05 && hsb_test[i - 1][j] >= 0) || (hsb_test[i - 1][j] > 0.95 && hsb_test[i - 1][j] <= 1)) {
                            suit_num.add(i);
                        }
                    }
                }
            }

        int result = (int) (Math.random() * suit_num.size()) ;
        String str = colors_name.get((int)suit_num.get(result));
        return str;
    }

    public float[] GetComplementaryClor(float[] rgb)
    {
        float[] Complementary_rgb= new float[3];
        for(int i =0; i<3;i++)
        {
            Complementary_rgb[i]= 255-rgb[i];
        }
        return  Complementary_rgb;
    }

    public void IfBodyType(String body,String style,int height,String faceshape,int age,String personality,int weight,String skinclor)
    {

        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        if(style.equals("瑞丽风格")||style.equals("嬉皮风格")||style.equals("百搭风格")||style.equals("淑女风格")||style.equals("韩版风格")
                    ||style.equals("民族风格")||style.equals("欧美风格")||style.equals("学院风格")||style.equals("通勤风格")
                    ||style.equals("中性风格")||style.equals("嘻哈风格")||style.equals("田园风格")||style.equals("朋克风格")
                    ||style.equals("OL风格")||style.equals("洛丽塔风格")||style.equals("简约风格")||style.equals("街头风格")
                    ||style.equals("波西米亚风格"))
        {
        String  key_word1="";
        String key_word2="";
        String key_word3 = "";
        //获取颜色以及搭配颜色
        int color_num =GetColor(skinclor, weight, height, age, personality);
        key_word1+=colors_name.get(color_num)+" ";
        key_word2+= GetStuitableColor(color_num)+" ";
        key_word3+= GetStuitableColor(color_num)+" ";
        if(weather>=20)
        {
                key_word1 += GetSummerUpperCoat()+ " "+GetSleeve(body) + " ";
                key_word1 += GetCollorType(faceshape) + " "+GetShirtlength(body, height) + " "+style + " ";
                key_word2 += GetDressPant(body,height);
                System.out.print(key_word1+"   "+key_word2);
        }
        else if (weather<20||weather>5)
         {
                    key_word1 += GetSummerUpperCoat()+" "+GetSleeve(body) + " "+ GetCollorType(faceshape) + " "+GetShirtlength(body, height) + " "+style + " ";
                    key_word2 += GetDressPant(body, height);
                    key_word3+=GetAutumnSpringCoat(body,faceshape,style,162);
                    System.out.print(key_word1+"   "+key_word2+"   "+key_word3);
        }
       else if(weather<=5)
        {
            key_word2 += GetDressPant(body,height);
            key_word1 +=GetSummerUpperCoat()+" "+ GetSleeve(body) + " "+ GetCollorType(faceshape) + " "+GetShirtlength(body, height) + " "+style + " ";
            key_word3+= GetWinterCoat(body, faceshape,style,162);
            System.out.print(key_word1+"        "+key_word2+"        "+key_word3);
        }
        else{
            throw new IllegalArgumentException("Sorry, the weather may be illegal.");
        }}else {
            throw new IllegalArgumentException("Sorry, the style may be illegal.");
        }
    }
    /**
      @根据体型，天气，身高决定裤装或者裙装的细节
      @return String
     */
    public String GetDressPant(String body,int height)
    {
        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        String[] pant_dress_Y = {"裤装", "半身裙"};
        int count_num4 = (int) (Math.random() * 2);
        String key_word2="";
        if (pant_dress_Y[count_num4].equals("裤装")) {
            key_word2 += GetPants(body) + " " + GetThickness() + " ";
            key_word2 += GetPantLength(height) + " ";
        }
        if (pant_dress_Y[count_num4].equals("半身裙")) {
            key_word2 += "半身裙 " + GetDressType(body) + " ";
            /////////////内外向可以影响裙长
            key_word2 += GetDressLength(height) + " ";
        }
        return key_word2 ;
    }
    /**
    @随机获取夏天上衣的服装类型
    @return String
   */
    public String GetSummerUpperCoat()
    {
        String coat ="";
            String[] cloths_Y = { "衬衫", "T恤", "雪纺衫"};
            int count_num1 = (int) (Math.random() * 3);
            coat = cloths_Y[count_num1];
        return coat;
    }
    /**
  @根据体型决定裙子版型
  @return String
 */
   public String GetDressType(String bodytype)
   {
       String dress="";
       if(bodytype.equals("Y"))
       {
           String shape[] = {"蛋糕裙",  "百褶裙", "荷叶边裙", "A字裙", "花苞裙", "蓬蓬裙", "大摆型", "裙裤"};
           int count_num5 = (int) (Math.random() * 8);
           dress = shape[count_num5];
       }
      else if(bodytype.equals("X"))
       {
           String shape[] = {"蛋糕裙", "短裤", "百褶裙", "荷叶边裙", "A字裙", "花苞裙", "蓬蓬裙", "大摆型", "裙裤"};
           int count_num5 = (int) (Math.random() * 9);
           dress = shape[count_num5];
       }
      else if(bodytype.equals("A"))
       {
           String shape[] = {"蛋糕裙", "百褶裙", "荷叶边裙", "A字裙", "花苞裙", "蓬蓬裙", "大摆型"};
           int count_num5 = (int) (Math.random() * 7);
           dress = shape[count_num5];
       }
      else if(bodytype.equals("H"))
       {
           String shape[] = {"蛋糕裙", "百褶裙", "荷叶边裙", "A字裙", "花苞裙", "蓬蓬裙", "大摆型"};
           int count_num5 = (int) (Math.random() * 7);
           dress = shape[count_num5];
       }
      else if(bodytype.equals("O"))
       {
           String shape[] = {"蛋糕裙", "百褶裙", "荷叶边裙", "A字裙", "花苞裙", "蓬蓬裙", "大摆型"};
           int count_num5 = (int) (Math.random() * 7);
           dress = shape[count_num5];
       }else
       {
           throw new IllegalArgumentException("Sorry, the bodyshape may be illegal.");
       }
       return dress;
   }
    /**
  @根据脸型，天气决定领型
  @return String
 */
    public String GetCollorType(String faceshape)
    {
        String sleeve="";

            if (faceshape.equals("圆形")) {
                String callor_type1[] = {"圆领", "立领"};
                int count_num2 = (int) (Math.random() * 2);
                sleeve += callor_type1[count_num2] + " ";
            }
            else if (faceshape.equals("椭圆脸") || faceshape.equals("倒三角")) {
                String callor_type1[] = {"圆领", "V领", "飘带领", "驳领", "青果领", "翻领", "立领", "方领", "一字领", "连帽领", "绳线状领", "不对称式", "斜领", "低开口领", "无领", "高领"};
                int count_num2 = (int) (Math.random() * 16);
                if(weather>=20)
                {
                while (callor_type1[count_num2].equals("高领")) {
                    count_num2 = (int) (Math.random() * 15);
                }
                }
                sleeve += callor_type1[count_num2] + " ";
            }
           else if (faceshape.equals("四方脸")) {
                String callor_type1[] = {"圆领", "V领", "飘带领", "驳领", "青果领", "翻领", "方领", "连帽领", "绳线状领", "不对称式", "斜领", "低开口领", "无领"};
                int count_num2 = (int) (Math.random() * 13);
                sleeve += callor_type1[count_num2] + " ";
            }
           else if (faceshape.equals("长方脸")) {
                String callor_type1[] = {"圆领", "飘带领", "翻领", "立领", "方领", "一字领", "连帽领", "绳线状领", "不对称式", "斜领", "无领", "高领"};
                int count_num2 = (int) (Math.random() * 12);
                if(weather>=20)
                {
                while (callor_type1[count_num2].equals("高领")) {
                    count_num2 = (int) (Math.random() * 15);
                }}
                sleeve += callor_type1[count_num2] + " ";
            }
          else  if (faceshape.equals("菱形脸")) {
                String callor_type1[] = {"圆领", "V领", "飘带领", "驳领", "青果领", "翻领", "方领", "一字领", "连帽领", "绳线状领", "不对称式", "斜领", "低开口领", "无领", "高领"};
                int count_num2 = (int) (Math.random() * 15);
                if(weather>=20)
                {
                while (callor_type1[count_num2].equals("高领")) {
                    count_num2 = (int) (Math.random() * 15);
                }}
                sleeve += callor_type1[count_num2] + " ";
            }else {
                throw new IllegalArgumentException("Sorry, the faceshape may be illegal.");
            }
        return sleeve;
    }
    /**
  @根据身高决定裤装的长度
  @return String
 */
    public String GetPantLength(int height)
    {
        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        String key_word2="";
        if(height<164)
        {
            String length[]={"长裤","短裤","七分裤","九分裤","六分裤"};
            int count_num5=(int)( Math.random()*5);
            key_word2 +=  length[count_num5]+" ";
        }
        if(height>=164)
        {
            String length[]={"长裤","短裤","七分裤","九分裤","六分裤","四分裤","五分裤"};
            int count_num5=(int)( Math.random()*7);
            key_word2 +=  length[count_num5]+" ";
        }
        return key_word2;
    }
    /**
  @根据身高决定裙装的长度
  @return String
 */
    public String GetDressLength(int height)
    {
        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        String key_word2="";
        if(height<164)
        {
            String length[]={"超短裙","短裙","中裙"};
            int count_num6=(int)( Math.random()*3);
            key_word2 +=  length[count_num6]+" ";
        }
        if(height>=164)
        {
            String length[]={"超短","短裙","中裙","中长裙","长裙","及膝裙","过膝裙"};
            int count_num6=(int)( Math.random()*7);
            key_word2 += length[count_num6]+" ";
        }
        return key_word2;
    }
    /**
  @根据体型，身高决定上装的长度
  @return String
 */
    public String GetShirtlength(String bodytype,int height)
    {
        //{"常规","短款","中长款","长款"};
        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        String length="";
        if(height<164)
        {
         if(bodytype.equals("Y"))
          {
            String skirt_length[] ={"常规","短款","中长款"};
              int num1= (int)(Math.random()*3);
              length=skirt_length[num1];
          }
          else  if(bodytype.equals("A"))
            {
                String skirt_length[] ={"中长款","常规"};
                int num1= (int)(Math.random()*2);
                length=skirt_length[num1];
            }
           else if(bodytype.equals("X"))
            {
                String skirt_length[] ={"常规","短款","中长款","常规"};
                int num1= (int)(Math.random()*4);
                length=skirt_length[num1];
            }
          else  if(bodytype.equals("O"))
            {
                String skirt_length[] ={"短款","中长款","长款","常规"};
                int num1= (int)(Math.random()*4);
                length=skirt_length[num1];
            }
           else if(bodytype.equals("H"))
            {
                String skirt_length[] ={"常规","短款","中长款"};
                int num1= (int)(Math.random()*3);
                length=skirt_length[num1];
            }
            else {
             throw new IllegalArgumentException("Sorry, the bodyshape may be illegal.");
         }
        }
        if(height>=164)
        {
            if(bodytype.equals("Y"))
            {
                String skirt_length[] ={"常规","短款","中长款","长款"};
                int num1= (int)(Math.random()*4);
                length=skirt_length[num1];
            }
            else if(bodytype.equals("A"))
            {
                String skirt_length[] ={"中长款","长款","常规"};
                int num1= (int)(Math.random()*3);
                length=skirt_length[num1];
            }
            else if(bodytype.equals("X"))
            {
                String skirt_length[] ={"常规","短款","中长款"};
                int num1= (int)(Math.random()*3);
                length=skirt_length[num1];
            }
           else if(bodytype.equals("O"))
            {
                String skirt_length[] ={"短款","中长款","长款","常规"};
                int num1= (int)(Math.random()*4);
                length=skirt_length[num1];
            }
          else  if(bodytype.equals("H"))
            {
                String skirt_length[] ={"常规","短款","中长款","长款"};
                int num1= (int)(Math.random()*4);
                length=skirt_length[num1];
            }else {
                throw new IllegalArgumentException("Sorry, the bodyshape may be illegal.");
            }
        }

        return length;
    }
    /**
  @根据天气，决定衣服的厚度
  @return String
 */
    public String GetThickness()
    {
            String thickness="";
            String pants_thickness[]={"薄款","常规","超薄","加厚"};
            if(weather>=20)
           {
               thickness += pants_thickness[2];
           }
        if(weather<20||weather>5)
        {
            int num= (int)(Math.random()*2);
            thickness += pants_thickness[num];
        }
        if(weather<=5)
        {
            thickness += pants_thickness[3];
        }
        return thickness;
    }
    /**
  @根据体型决定袖子的款型
  @return String
 */
    public String GetSleeve(String bodyshape)
    {
        String sleeve="";
        if (bodyshape.equals("Y"))
        {
            String Sleeve[] = {"直袖","无袖","落肩袖","裝袖","插肩袖","短袖","七分袖","连袖","圆裝袖"};
            int count_num3=(int)( Math.random()*9);
            sleeve = Sleeve[count_num3];
        }
        if (bodyshape.equals("X"))
        {
            String Sleeve[] = {"直袖","无袖","落肩袖","裝袖","插肩袖","短袖","七分袖","连袖","圆裝袖"};
            int count_num3=(int)( Math.random()*9);
            sleeve = Sleeve[count_num3];
        }
        if (bodyshape.equals("A"))
        {
            String Sleeve[] = {"泡泡袖 ","喇叭袖","灯笼袖"};
            int count_num3=(int)( Math.random()*3);
            sleeve = Sleeve[count_num3];
        }
        if (bodyshape.equals("H"))
        {
            String Sleeve[] = {"泡泡袖 ","喇叭袖","灯笼袖","直袖","落肩袖","裝袖","插肩袖","短袖","中袖","连袖","圆裝袖"};
            int count_num3=(int)( Math.random()*11);
            sleeve = Sleeve[count_num3];
        }
        if (bodyshape.equals("O"))
        {
            String Sleeve[] = {"泡泡袖 ","喇叭袖","灯笼袖","直袖","落肩袖","裝袖","插肩袖","短袖","中袖","连袖","圆裝袖"};
            int count_num3=(int)( Math.random()*11);
            sleeve = Sleeve[count_num3];
        }
        return sleeve;

    }
    /**
  @根据体型决定裤子的版型
  @return String
 */
    public String GetPants(String bodyshape)
    {
        String pant = "";
        if(bodyshape.equals("Y"))
        {
            String pants[] = {"锥形裤", "哈伦裤", "直筒裤", "阔腿裤"};
            int count_num2 = (int) (Math.random() * 4);
            pant = pants[count_num2];
        }else
        if(bodyshape.equals("X"))
        {
            String pants[] = {"锥形裤", "铅笔裤", "直筒裤"};
            int count_num2 = (int) (Math.random() * 3);
            pant = pants[count_num2];
        }
        else if(bodyshape.equals("A"))
        {
            String pants[] = {"喇叭裤", "微喇叭裤", "直筒裤"};
            int count_num2 = (int) (Math.random() * 3);
            pant = pants[count_num2];
        }
        else if(bodyshape.equals("H"))
        {
            String pants[] = {"锥形裤", "烟管裤", "阔腿裤", "哈伦裤", "喇叭裤", "微喇叭裤", "直筒裤"};
            int count_num2 = (int) (Math.random() * 7);
            pant = pants[count_num2];
        }
       else if(bodyshape.equals("O"))
        {
            String pants[] = {"锥形裤", "烟管裤", "阔腿裤", "哈伦裤", "喇叭裤", "微喇叭裤", "直筒裤"};
            int count_num2 = (int) (Math.random() * 7);
            pant = pants[count_num2];
        }
        else {
            throw new IllegalArgumentException("Sorry, the bodyshape may be illegal.");
        }
        return pant;
    }
    /**
  @根据体型，天气，身高，风格，脸型决定春秋季节的外套检索词
  @return String
 */
    public String GetAutumnSpringCoat(String bodyshape,String faceshape,String cloth_style,int height)
    {
        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        String coats[]={"风衣","马夹","棒球服","牛仔外套","小西装","毛衣","卫衣"};
        String coat="";
            int num = (int)(Math.random()*7);
            coat += coats[num]+" ";
        coat += GetSleeve(bodyshape)+" " +cloth_style+" "+GetCollorType(faceshape) +" "+GetShirtlength(bodyshape,height);
        return coat;
    }
    /**
  @根据体型，天气，身高，风格，脸型决定冬季的外套检索词
  @return String
 */
    public String GetWinterCoat(String bodyshape,String faceshape,String cloth_style,int height)
    {
        if(height <=0 && height>= 240)
        {
            throw new IllegalArgumentException("Sorry, the height may be illegal.");
        }
        String coats[]={"风衣","毛呢外套","羽绒服","皮草","棉衣"};
        String coat="";
        int num = (int)(Math.random()*5);
        coat += coats[num]+" ";
        coat += GetSleeve(bodyshape)+" " +cloth_style+" "+GetCollorType(faceshape) +" "+GetShirtlength(bodyshape,height);
        return coat;
    }

}
