//package recommendation.colorTable;
//
//import hibernate.elements.Color;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by crystal.liker on 2015/8/29.
// */
//public class CalculateTable2 {
//    int num[][] ={{8,2,8,4,0,1,2,0,0,0,   0,3,4,5,0,0},
//            {6,4,8,2,0,0,5,0,0,0,      0,5,1,3,0,0},
//            {5,4,13,2,0,0,4,0,0,0,     0,2,2,2,0,0},
//            {1,4,4,8,0,0,3,0,0,0,      0,3,4,3,0,0},
//            {1,4,2,0,8,0,0,0,0,0,      1,1,2,3,0,0},
//            {0,0,4,1,4,7,0,0,0,0,      1,3,0,1,0,0},
//            {1,1,7,0,0,2,10,0,0,0,     1,1,2,0,3,0},
//            {0,0,4,0,0,1,1,6,0,2,      0,3,0,0,0,2},
//            {0,0,6,2,0,0,0,2,5,0,      0,5,1,2,0,2},
//            {2,0,3,0,0,0,0,0,1,2,      3,0,0,0,0,0},
//            {1,2,4,0,0,0,0,0,0,0,      0,1,2,0,0,0},
//            {3,1,2,0,0,0,0,0,0,0,      0,1,2,0,0,0},
//            {2,0,4,1,2,0,0,0,0,0,      0,0,0,0,0,0,},
//            {1,6,4,15,0,0,0,0,0,       0,2,1,2,0,0,0},
//            {4,1,4,0,0,0,0,0,0,0,      0,6,0,0,3,0,},
//            {1,1,7,0,0,0,0,0,0,0,      0,3,2,0,0,1}};
//    float eachClorPosiibilitt[][] = new float[num.length][num.length];//表二
//    int ColorNum = num.length;
//    final static float PossibilityWillBeSlection = 0.008f;
//    final static float PossibilityWillBeSlection2 = 0.003f;
//    GetColorScore getColorScore= new GetColorScore();                              // 获取被点赞图片的每个颜色的像素数目
//    ArrayList<String> saynicecolor = getColorScore.readCoat("color");                       // 被点赞的图片所包含的颜色
//    ArrayList<String> coccurpixel= getColorScore.readCoat("pixel");
//    int allcolornum = 99;
//    /**
//     * 获取概率大于一定值的颜色和在评价体系中出现的颜色
//     * 获得表一   possibility
//     */
//    public ArrayList GetSlectionColor() {
//        CalculateTable1 calculateTable1 = new CalculateTable1();
//        PeopleFavorColorTable peopleFavorColorTable=calculateTable1.CalculateTable1();
//        List<ColorProbability> colorProbabilities =peopleFavorColorTable.getColorProbabilities();
//
//        //表二
//        List<ChooseColorWhileFavorColorTable> listOfChooseColorWhileFavorColorTable= new ArrayList<>();
//        ArrayList<Color> selectionColor = new ArrayList<>();
//        int[][] coloraddress = new int[saynicecolor.size()-1][saynicecolor.size()-1];
//        for (int j = 0; j < num.length; j++) {
//            ChooseColorWhileFavorColorTable chooseColorWhileFavorColorTable = new ChooseColorWhileFavorColorTable();
//            List<ColorProbability> colorProbabilitys = new ArrayList<>();
//
//        for (int i = 0; i < colorProbabilities.size(); i++) {
//            float mid = 0f;
//            if (colorProbabilities.get(i).getProbability() >= PossibilityWillBeSlection)
//            {
//                ColorProbability color_possibility = new ColorProbability();
//                color_possibility.setColor(colorProbabilities.get(i).getColor());
//                color_possibility.setProbability(colorProbabilities.get(i).getProbability());
//                colorProbabilities.add(color_possibility);
//                coloraddress[j][j]= i;
//            }
//            //放入表二的集合
//            chooseColorWhileFavorColorTable.setColorProbabilityID(i);
//            chooseColorWhileFavorColorTable.setChooseColor(colorProbabilities.get(i).getColor());
//            chooseColorWhileFavorColorTable.setColorProbabilities(colorProbabilities);
//            listOfChooseColorWhileFavorColorTable.add(chooseColorWhileFavorColorTable);
//        }
//
//        }
//        ChooseColorWhileFavorColorTables chooseColorWhileFavorColorTables=
//                new ChooseColorWhileFavorColorTables(listOfChooseColorWhileFavorColorTable);
//        //  System.out.println("size: "+selectionColorPossibility.size());
//        //如果所点赞的颜色不在被选择的颜色里，添加被点赞的颜色
//        ArrayList possibility = GetPossiblity();
//        float[] color_possibility = ArraylistTofloat();
//        int n = 0;
//        int c = 0;
//        ArrayList diff = new ArrayList();
//        boolean same = false;
//        do {
//            same = false;
//            for (int j = 0; j < selectionColor.size(); j++) {
//                if (saynicecolor.get(c).equals(selectionColor.get(j)))
//                {
//                    same = true;
//                    //            System.out.println(saynicecolor.get(c)+"=" + selectionColor.get(j));
//                    possibility.add(color_possibility[coloraddress[c]]);
//                }
//            }
//            if (!same) {
//                diff.add(saynicecolor.get(c));
//                selectionColorPossibility.add(color_possibility[coloraddress[c]]);
//                //   System.out.println("size: "+selectionColorPossibility.size());
//            }
//            n++;
//            c++;
//        } while (c < saynicecolor.size()-1);
//        for(int j = 0; j < diff.size(); j++) {
//            selectionColor.add(diff.get(j));
//        }
//        return selectionColor;
//        //    for(int j = 0; j <  selectionColor.size(); j++) {
//        //    System.out.println(selectionColor.get(j));
//        //  }
//        //
//        //  System.out.println("Size: " +   selectionColor.size());
//    }
//
//    public float[] ArraylistTofloat()
//    {
//
//        ArrayList possibility = GetPossiblity();
//        float[] color_possibility = new float[possibility.size()];
//        for (int i = 0; i < possibility.size(); i++) {
//            color_possibility[i]= Float.parseFloat(String.valueOf(possibility.get(i)));
//        }
//        return color_possibility;
//    }
//    //获得所有颜色的概率
//    public ArrayList GetPossiblity()
//    {
//        ArrayList possibility = new ArrayList();
//        CalculateTable1 calculateTable1 = new CalculateTable1();
//        List<ColorProbability >clorProbability = calculateTable1.CalculateTable1().getColorProbabilities();
//        for (int i = 0; i < clorProbability.size(); i++) {
//            possibility.add(clorProbability.get(i).getProbability());
//        }
//        return possibility;
//    }
//
//    float[] EachClorTotalPixel = new float[allcolornum];
//
//    ArrayList possibility = new ArrayList();
//    /**
//     * 获取每个颜色在多次后的点赞总的像素值，作为用户对颜色偏好的参数
//     */
//
//    public float[] GetEachClorTotalPixel()
//    {
//        float selection_clor_each_pixel[]=new float[selectionColor.size()];
//        // System.out.println("YYYYY: "+selectionColor.size());
//        //   for(int i =0 ;i<nice_color_pixel.length;i++)
//        //   {
//        //       for(int j =0 ;j<nice_color_pixel[0].length;j++)
//        // System.out.println("selection: "+nice_color_pixel[i][j]);
//
//        //  } // System.out.println("aaa"+selection_clor_each_pixel.length);
//        for(int i =0 ;i<saynicecolor.size()-1;i++)
//        {
//            for(int j =0 ;j<selectionColor.size();j++)
//            {
//                if(selectionColor.get(j).equals(saynicecolor.get(i)) )
//                {
//                    int a = (int)(i/(float)EachClothColorNumber);
//                    int  b = i%EachClothColorNumber;
//                    //  System.out.println("test"+" a = "+a+"  b="+b);
//                    // System.out.println( selection_clor_each_pixel.length);
//                    selection_clor_each_pixel[j] += nice_color_pixel[a][b];
//                }
//            }
//        }
//        //  for(int i =0 ;i<selectionColor.size();i++)
//        //   {
//        //     System.out.println("selection_clor_each_pixel: "+i+ ": "+selection_clor_each_pixel[i]);
//        // }
//        return selection_clor_each_pixel;
//    }
//
//    /**
//    /**
//     * 点赞后，每个颜色所占的像素值的概率
//     */
//
//    public float[] GetEachClorPossibilityByPixel()
//    {
//        float selection_clor_each_pixel[]= GetEachClorTotalPixel();
//        //  System.out.print("selection_clor_each_pixel.length: "+selection_clor_each_pixel.length+"\n");
//        float total = 0f;
//
//        for(int i = 0; i<num.length;i++)
//        {
//            total+=selection_clor_each_pixel[i];
//        }
//        for(int i = 0; i<num.length;i++)
//        {
//            selection_clor_each_pixel[i]=selection_clor_each_pixel[i]/total;
//            //  System.out.println( selection_clor_each_pixel[i]);
//        }
//        return  selection_clor_each_pixel;
//
//    }
//
//
//    /**
//     * 获得表二
//     */
//    public void CalculateEachClorPossibility ()
//    {
//        int sum[]=new int[ColorNum];
//        for(int i = 0; i<num.length;i++)
//        {
//            for(int j =0; j<num[0].length;j++)
//            {
//                sum[i] += num[i][j];
//            }
//        }
//        //      System.out.println("Table2");
//        for(int i = 0; i<num.length;i++)
//        {
//            for(int j =0; j<num[0].length;j++)
//            {
//                eachClorPosiibilitt[i][j] = num[i][j]/(float)(sum[i]);
//                //       System.out.print(df.format(eachClorPosiibilitt[i][j])+" ");
//            }
//            //     System.out.println();
//        }
//        for(int i = 0; i<num.length;i++)
//        {
//            ArrayList<ChooseColorWhileFavorColorTable>  chooseColorWhileFavorColorTables
//                    = new ArrayList<ChooseColorWhileFavorColorTable>();
//            ChooseColorWhileFavorColorTable chooseColorWhileFavorColorTable = new ChooseColorWhileFavorColorTable();
//            chooseColorWhileFavorColorTable.setChooseColor();
//
//        }
//    }
//
//
//}
