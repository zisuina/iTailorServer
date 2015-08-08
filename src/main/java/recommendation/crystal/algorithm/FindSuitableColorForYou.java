//package recommendation.crystal.algorithm;
//
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by crystal.liker on 2015/8/6.
// */
//public class FindSuitableColorForYou {
//    GetColor getcolor = new GetColor();
//    float[][] allclorsRGB= getcolor.GetAllColorRGB();
//    RgbToHsl rgbToHsl = new RgbToHsl();
//    float[][] allclorHSL= rgbToHsl.GetAllHSB(allclorsRGB);
//    ArrayList names = getcolor.readColor("name");
//    public ArrayList GetHighLColor(String Type)
//    {
//        ArrayList highL =new ArrayList();
//        if(Type.equalsIgnoreCase("H"))
//        {
//        for(int i =0; i<allclorHSL.length;i++)
//        {
//            if(allclorHSL[i][2]< (1/3.0)&&allclorHSL[i][2]>=0)
//            {
//                highL.add(names.get(i));
//            }
//        }
//        }else if(Type.equalsIgnoreCase("M"))
//        {
//            for(int i =0; i<allclorHSL.length;i++)
//            {
//                if(allclorHSL[i][2]< (2/3.0)&&allclorHSL[i][2]>=(1/3.0))
//                {
//                    highL.add(names.get(i));
//                }
//            }
//        }else if(Type.equalsIgnoreCase("L"))
//        {
//            for(int i =0; i<allclorHSL.length;i++)
//            {
//                if(allclorHSL[i][2]>= (2/3.0)&&allclorHSL[i][2]<=1)
//                {
//                    highL.add(names.get(i));
//                }
//            }
//        }else
//        {
//            throw new IllegalArgumentException("There is wrong about Color's HSL");
//        }
//        return  highL;
//    }
//    public ArrayList GetColdClor()
//    {
//        ArrayList ColdColors =new ArrayList();
//        for(int i =0; i<allclorHSL.length;i++)
//        {
//            if(allclorHSL[i][0]<= 53.1&&allclorHSL[i][0]>=31.86)
//            {
//                if(allclorHSL[i][1]< 0.667&&allclorHSL[i][1]>=0)
//                    if(allclorHSL[i][2]< 0.67&&allclorHSL[i][2]>=0)
//                        ColdColors.add(names.get(i));
//            }
//            if(allclorHSL[i][0]<= 74.34&&allclorHSL[i][0]>= 53.1)
//            {
//                // if(allclorHSL[i][1]< 0.67&&allclorHSL[i][1]>=0)
//                if(allclorHSL[i][2]< 0.333&&allclorHSL[i][2]>=0)
//                    ColdColors.add(names.get(i));
//            }
//
//            if(allclorHSL[i][0]<= 95.58&&allclorHSL[i][0]>=74.34)
//            {
//                if(allclorHSL[i][1]>= 0.68&&allclorHSL[i][1]<=1)
//                    if(allclorHSL[i][2]<= 1&&allclorHSL[i][2]>=0.667)
//                        ColdColors.add(names.get(i));
//            }
//            if(allclorHSL[i][0]<= 95.58&&allclorHSL[i][0]>=74.34)
//            {
//                if(allclorHSL[i][1]>= 0&&allclorHSL[i][1]<=0.67)
//                    if(allclorHSL[i][2]<= 0.667&&allclorHSL[i][2]>=0)
//                        ColdColors.add(names.get(i));
//            }
//            if(allclorHSL[i][0]<= 180.62&&allclorHSL[i][0]>=116.87)
//            {
//                ColdColors.add(names.get(i));
//            }
//            if((allclorHSL[i][0]>=116.87) && (allclorHSL[i][0]<=138.12))
//            {
//                if(allclorHSL[i][1]>= 0.68&&allclorHSL[i][1]<=1)
//                {
//                    if(allclorHSL[i][2]>= 0.667&&allclorHSL[i][2]<=1)
//                    {
//                        continue;
//                    }else
//                    {
//                        ColdColors.add(names.get(i));
//                    }
//                }
//            }
//        }
//        for(int i=0 ;i< ColdColors.size();i++ )
//        {
//            System.out.println(ColdColors.get(i));
//        }
//        return ColdColors;
//    }
//    public Set GetWarmClor()
//    {
//        ArrayList WarmColors =new ArrayList();
//        ArrayList WarmColors_num=new ArrayList();
//        for(int i =0; i<allclorHSL.length;i++)
//        {
//            if(allclorHSL[i][0]<= 251.34&&allclorHSL[i][0]>=4244.26)
//            {
//                if(allclorHSL[i][1]<= 1&&allclorHSL[i][1]>=0.34)
//                    if(allclorHSL[i][2]< 1&&allclorHSL[i][2]>=0.337)
//                    {
//                        WarmColors.add(names.get(i));
//                        WarmColors_num.add(i);
//                    }
//            }
//            if(allclorHSL[i][0]<= 53.1&&allclorHSL[i][0]>=0)
//            {
//               if(allclorHSL[i][1]< 1&&allclorHSL[i][1]>=0.34)
//                if(allclorHSL[i][2]< 1&&allclorHSL[i][2]>=0.337)
//                {
//                    WarmColors.add(names.get(i));
//                    WarmColors_num.add(i);
//                }
//            }
//
//            if(allclorHSL[i][0]<= 31.86&&allclorHSL[i][0]>=10.62)
//            {
//                if(allclorHSL[i][1]>= 0.01&&allclorHSL[i][1]<=0.67)
//                    if(allclorHSL[i][2]<= 0.33&&allclorHSL[i][2]>0)
//                    {
//                        continue;
//                    }else
//                        {
//                            WarmColors.add(names.get(i));
//                            WarmColors_num.add(i);
//                        }
//
//            }
//            if(allclorHSL[i][0]<= 53.1&&allclorHSL[i][0]>=31.86)
//            {
//                if(allclorHSL[i][1]>= 0.68&&allclorHSL[i][1]<=1)
//                    if(allclorHSL[i][2]<= 0.33&&allclorHSL[i][2]>=0)
//                    {
//                        continue;
//                    }else
//                    {
//                        WarmColors.add(names.get(i));
//                        WarmColors_num.add(i);
//                    }
//            }
//            //
//            if(allclorHSL[i][0]<= 53.1&&allclorHSL[i][0]>=31.86)
//            {
//                if(allclorHSL[i][1]>= 0.01&&allclorHSL[i][1]<=0.67)
//                    if(allclorHSL[i][2]>= 0&&allclorHSL[i][2]<= 0.667)
//                    {
//                        continue;
//                    }else
//                    {
//                        WarmColors.add(names.get(i));
//                        WarmColors_num.add(i);
//                    }
//
//            }
//            if((allclorHSL[i][0]>=53.1) && (allclorHSL[i][0]<=74.34))
//            {
//                if(allclorHSL[i][1]>= 0.68&&allclorHSL[i][1]<=1)
//                {
//                    if(allclorHSL[i][2]>= 0.33&&allclorHSL[i][2]<=0.67)
//                    {
//                        WarmColors.add(names.get(i));
//                        WarmColors_num.add(i);
//                    }
//                }
//            }
//        }
//        int [] num = new int[WarmColors_num.size()];
//        for(int i=0 ;i< WarmColors_num.size();i++ )
//        {
//            num[i]=Integer.parseInt(String.valueOf(WarmColors_num.get(i))) ;
//        }
//        ArrayList numList = new ArrayList();
//        for (int i : num)
//            numList.add(names.get(i));
//        Set<Object> numSet = new HashSet<Object>();
//        numSet.addAll(numList);
//        System.out.println(numSet);
//        return  numSet;
//    }
//    public ArrayList GetRGBdiffClor(String Type)
//    {
//        ArrayList red_green_blueClor= new ArrayList();
//        if(Type.equalsIgnoreCase("R"))
//        {
//            for(int i =0;i<names.size();i++)
//            {
//                if(allclorHSL[i][0]<254.172&&allclorHSL[i][0]>249)
//                {
//                    red_green_blueClor.add(names.get(i));
//                }else if(allclorHSL[i][0]< 10.62&&allclorHSL[i][0]>=0)
//                {
//                    red_green_blueClor.add(names.get(i));
//                }
//            }
//        }
//        else if(Type.equalsIgnoreCase("G"))
//        {
//            for(int i =0;i<names.size();i++)
//            {
//                if(allclorHSL[i][0]<= 95.58&&allclorHSL[i][0]>=74.34)
//                {
//                    red_green_blueClor.add(names.get(i));
//                }
//            }//有问题
//        }else  if(Type.equalsIgnoreCase("b"))
//        {
//            for(int i =0;i<names.size();i++)
//            {
//                if(allclorHSL[i][0]<= 180.54&&allclorHSL[i][0]>=162.5)
//                {
//                    red_green_blueClor.add(names.get(i));
//
//                }
//            }
//        }
//        for(int i =0;i<red_green_blueClor.size();i++)
//        {
//            System.out.println(red_green_blueClor.get(i));
//        }
//         return red_green_blueClor;
//    }
//    public ArrayList GetHighSColor(String Type)
//    {
//        ArrayList highS =new ArrayList();
//        if(Type.equalsIgnoreCase("l"))
//        {
//            for(int i =0; i<allclorHSL.length;i++)
//            {
//                if(allclorHSL[i][1]< (1/3.0)&&allclorHSL[i][1]>=0)
//                {
//                    highS.add(names.get(i));
//                }
//            }
//        }else if(Type.equalsIgnoreCase("M"))
//        {
//            for(int i =0; i<allclorHSL.length;i++)
//            {
//                if(allclorHSL[i][1]< (2/3.0)&&allclorHSL[i][1]>=(1/3.0))
//                {
//                    highS.add(names.get(i));
//                }
//            }
//        }else if(Type.equalsIgnoreCase("H"))
//        {
//            for(int i =0; i<allclorHSL.length;i++)
//            {
//                if(allclorHSL[i][1]>= (2/3.0)&&allclorHSL[i][1]<=1)
//                {
//                    highS.add(names.get(i));
//                }
//            }
//        }else
//        {
//            throw new IllegalArgumentException("There is wrong about Color's HSL");
//        }
//        for(int i =0;i<highS.size();i++)
//        {
//            System.out.println(highS.get(i));
//        }
//        return  highS;
//    }
//    public String ReturnData(String name,float r,float g,float b)
//    {
//        int[] data = new int[15];
//        RgbToHsl rgb = new RgbToHsl();
//        ArrayList clodclor=GetColdClor();
//        String a="";
//        float[] hsl = rgb.rgb2hsb(r,g,b);
//        //第一个偏白人适不适合。
//        for(int i =0;i<clodclor.size();i++)
//        {
//            if(name.equalsIgnoreCase(String.valueOf(clodclor.get(i))))
//            {
//                    data [0] = 0;
//            }
//        }
//        return a;
//    }
//
//}
