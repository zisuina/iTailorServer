package recommendation.colorTable;

import hibernate.elements.Color;
import util.BaseDAO;
import util.QickSort;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/29.
 */
public class calcultaTables {
    int allcolorsNum = 99;
    String[] AllcolorStringName = new String[allcolorsNum];               //  存储颜色名字
    ArrayList selectionColor = new ArrayList();                                      // 被选择一定概率的颜色
    ArrayList selectionColorPossibility = new ArrayList();
    GetColorScore getColorScore = new GetColorScore();                              // 获取被点赞图片的每个颜色的像素数目
    ArrayList<String> saynicecolor = getColorScore.readCoat("color");                       // 被点赞的图片所包含的颜色
    ArrayList<String> coccurpixel = getColorScore.readCoat("pixel");                         //被点赞的图片每次每个颜色所包含的像素值
    String[][] nice_color = new String[(int) ((saynicecolor.size() - 1) / 3.0)][EachClothColorNumber];
    final static int EachClothColorNumber = 3;
    final static float PossibilityWillBeSlection = 0.008f;
    final static float PossibilityWillBeSlection2 = 0.003f;
    float[][] nice_color_pixel = new float[(int) ((saynicecolor.size() - 1) / 3.0)][EachClothColorNumber];
    int[] coloraddress = new int[saynicecolor.size() - 1];
    float color_possibility[] = new float[99];
    final static int best_times = 2;
    DecimalFormat df = new DecimalFormat("0.000");
    int USERBestClorNumber = -1;
    //黑色灰色白色天蓝色浅灰  红色粉红桔红黄色蓝色 深蓝色天蓝青色绿色紫色酸橙绿
    int num[][] = {{8, 2, 8, 4, 0, 1, 2, 0,0, 0, 0, 0, 3, 4, 5, 0, 0},
            {6, 4, 8, 2, 0, 0, 5, 0, 0, 0,0, 0, 5, 1, 3, 0, 0},
            {5, 1, 13, 2, 0, 0, 1, 0, 0, 0,0, 0, 1, 2, 1, 0, 0},
            {1, 4, 4, 8, 0, 0, 3, 0, 0, 0,0, 0, 3, 4, 3, 0, 0},
            {1, 4, 7, 0, 8, 0, 0, 0, 0, 0, 0,1, 1, 2, 3, 0, 0},
            {0, 0, 4, 1, 4, 7, 0, 0, 0, 0, 0,1, 3, 0, 1, 0, 0},
            {1, 1, 7, 0, 0, 2, 10, 0, 0, 0,0, 1, 1, 2, 0, 3, 0},
            {0, 0, 4, 0, 0, 1, 1, 6, 0, 2, 0,0, 3, 0, 0, 0, 2},
            {0, 0, 6, 2, 0, 0, 0, 2, 5, 0,0, 0, 5, 1, 2, 0, 2},
            {2, 0, 3, 0, 0, 0, 0, 0, 1, 2,0, 3, 0, 0, 0, 0, 0},
            {1, 2, 4, 0, 0, 0, 0, 0, 0, 0,0, 0, 1, 2, 0, 0, 0},
            {3, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0,0, 1, 2, 0, 0, 0},
            {2, 0, 4, 1, 2, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0,},
            {1, 6, 4, 15, 0, 0, 0, 0, 0, 0,0, 2, 1, 2, 0, 0, 0},
            {4, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0,0, 6, 0, 0, 3, 0,},
            {1, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0,0, 3, 2, 0, 0, 1}
            ,{1, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0,0, 3, 2, 0, 0, 1}};
    float eachClorPosiibilitt[][] = new float[num.length][num.length];//表二

    /**
     * 将数据转换成数组形式，以便于计算
     * 以点赞颜色的转化，所有颜色名字的颜色
     */
    public void ArrayToStringandFloat() {
        ArrayList<String> allcolornames = new ArrayList();
        allcolornames = new CalculateTable1().GetNamesArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < saynicecolor.size() - 1; i++) {
            // System.out.println(saynicecolor.size()-1);
            a = (int) (i / (float) EachClothColorNumber);
            b = i % EachClothColorNumber;
            nice_color[a][b] = String.valueOf(saynicecolor.get(i));
            nice_color_pixel[a][b] = Float.parseFloat(String.valueOf(coccurpixel.get(i)));
            // System.out.println(saynicecolor.get(i));
            //  System.out.println(nice_color_pixel[a][b]);
        }
        for (int i = 0; i < allcolornames.size(); i++) {
            AllcolorStringName[i] = String.valueOf(allcolornames.get(i));
        }
    }

    /**
     * 将任意动态数组转换成一维字符串数组
     *
     * @param m
     * @return
     */
    public String[] ArrayToString(ArrayList m) {
        String te[] = new String[m.size()];
        for (int i = 0; i < m.size(); i++) {
            te[i] = String.valueOf(m.get(i));
        }
        return te;
    }


    /**
     * 将点赞的颜色的地址记录下来
     */
    public void ColorAddress() {
        ArrayList<String> allcolornames = new ArrayList();
        allcolornames = new CalculateTable1().GetNamesArray();
        for (int i = 0; i < allcolorsNum; i++) {
            for (int j = 0; j < saynicecolor.size() - 1; j++) {
                if (saynicecolor.get(j).equals(allcolornames.get(i))) {
                    // int a = (int)(j/(float)EachClothColorNumber);
                    // int  b = j%EachClothColorNumber;
                    coloraddress[j] = i;
                    // System.out.println(j+" : "+coloraddress[j]);
                }

            }
        }
        //      for(int i =0;i<coloraddress.length;i++)
        //    {
        //        System.out.println(i+" : "+coloraddress[i]);
        //    }
      /*  for(int i =0;i<coloraddress.length;i++)
        {
            for(int j =0 ; j<coloraddress[0].length;j++)
            {
                System.out.print(coloraddress[i][j]+" ");
            }
            System.out.println();
        }*/
    }

    /**
     * 对以投票的衣服的像素进行马尔科夫链的计算，来弱化以前数据对用户的影响。
     */
    public void CoefficientEffectColorPixelByTimes() {
        double[] coefficients = new double[nice_color.length];
        for (int i = 0; i < (int) ((saynicecolor.size() - 1) / (float) EachClothColorNumber) / (float) best_times; i++) {
            coefficients[i] = GetCoefficientByTimes(i + 1);
            //  System.out.println(coefficients[i]);
        }
        for (int i = 0; i < (int) ((saynicecolor.size() - 1) / (float) EachClothColorNumber) / (float) best_times; i++) {
            for (int j = 0; j < EachClothColorNumber; j++) {
                for (int x = 0; x < best_times; x++) {
                    //  System.out.println(nice_color_pixel[i+x][j]);
                    nice_color_pixel[best_times * i + x][j] = (float) (nice_color_pixel[best_times * i + x][j] * coefficients[i]);
                }
            }
        }
        //   for(int i =0;i<(int)(saynicecolor.size()/(float)EachClothColorNumber);i++)
        //     {
        //      for(int j =0 ;j<EachClothColorNumber;j++)
        //      {
        //         System.out.print(nice_color_pixel[i][j]+" ");
        //    }
        //    System.out.println();
        // }
    }

    ArrayList possibility = new ArrayList();

    /**
     * 获取每个颜色在多次后的点赞总的像素值，作为用户对颜色偏好的参数
     */

    public float[] GetEachClorTotalPixel() {

        // System.out.println("YYYYY: "+selectionColor.size());
        //   for(int i =0 ;i<nice_color_pixel.length;i++)
        //   {
        //       for(int j =0 ;j<nice_color_pixel[0].length;j++)
        // System.out.println("selection: "+nice_color_pixel[i][j]);

        //  } // System.out.println("aaa"+selection_clor_each_pixel.length);
        selectionColor = GetSlectionColor();
        float selection_clor_each_pixel[] = new float[selectionColor.size()];
        for (int i = 0; i < saynicecolor.size() - 1; i++) {
            for (int j = 0; j < selectionColor.size(); j++) {
                if (selectionColor.get(j).equals(saynicecolor.get(i))) {
                    int a = (int) (i / (float) EachClothColorNumber);
                    int b = i % EachClothColorNumber;
                    //  System.out.println("test"+" a = "+a+"  b="+b);
                    // System.out.println( selection_clor_each_pixel.length);
                    selection_clor_each_pixel[j] += nice_color_pixel[a][b];
                }
            }
        }
        //  for(int i =0 ;i<selectionColor.size();i++)
        //   {
        //     System.out.println("selection_clor_each_pixel: "+i+ ": "+selection_clor_each_pixel[i]);
        // }
        return selection_clor_each_pixel;
    }

    /**
     * 获取概率大于一定值的颜色和在评价体系中出现的颜色
     * 获得表一   possibility
     */
    public ArrayList GetSlectionColor() {
        GetEachColorPossibility();
        ArrayList<String> allcolornames = new ArrayList();
        allcolornames = new CalculateTable1().GetNamesArray();
        for (int i = 0; i < allcolorsNum; i++) {
            if (color_possibility[i] >= PossibilityWillBeSlection) {
                selectionColor.add(allcolornames.get(i));
                selectionColorPossibility.add(color_possibility[i]);
            }
        }
        //  System.out.println("size: "+selectionColorPossibility.size());
        //如果所点赞的颜色不在被选择的颜色里，添加被点赞的颜色
        int n = 0;
        int c = 0;
        ArrayList diff = new ArrayList();
        boolean same = false;
        do {
            same = false;
            for (int j = 0; j < selectionColor.size(); j++) {
                if (saynicecolor.get(c).equals(selectionColor.get(j))) {
                    same = true;
                    //            System.out.println(saynicecolor.get(c)+"=" + selectionColor.get(j));
                    possibility.add(color_possibility[coloraddress[c]]);
                }
            }
            if (!same) {
                diff.add(saynicecolor.get(c));
                selectionColorPossibility.add(color_possibility[coloraddress[c]]);
                //   System.out.println("size: "+selectionColorPossibility.size());
            }
            n++;
            c++;
        } while (c < saynicecolor.size() - 1);
        for (int j = 0; j < diff.size(); j++) {
            selectionColor.add(diff.get(j));
        }
        return selectionColor;
        //    for(int j = 0; j <  selectionColor.size(); j++) {
        //    System.out.println(selectionColor.get(j));
        //  }
        //
        //  System.out.println("Size: " +   selectionColor.size());
    }

    /**
     * 获取概率大于一定值的颜色和在评价体系中出现的颜色
     * 为搭配夏装时使用
     */
    public ArrayList GetSlectionColor2() {
        GetEachColorPossibility();
        ArrayList<String> allcolornames = new ArrayList();
        allcolornames = new CalculateTable1().GetNamesArray();
        for (int i = 0; i < allcolorsNum; i++) {
            if (color_possibility[i] >= PossibilityWillBeSlection2) {
                selectionColor.add(allcolornames.get(i));
                selectionColorPossibility.add(color_possibility[i]);
            }
        }
        //  System.out.println("size: "+selectionColorPossibility.size());
        //如果所点赞的颜色不在被选择的颜色里，添加被点赞的颜色
        int n = 0;
        int c = 0;
        ArrayList diff = new ArrayList();
        boolean same = false;
        do {
            same = false;
            for (int j = 0; j < selectionColor.size(); j++) {
                if (saynicecolor.get(c).equals(selectionColor.get(j))) {
                    same = true;
                    //            System.out.println(saynicecolor.get(c)+"=" + selectionColor.get(j));
                    possibility.add(color_possibility[coloraddress[c]]);
                }
            }
            if (!same) {
                diff.add(saynicecolor.get(c));
                selectionColorPossibility.add(color_possibility[coloraddress[c]]);
                //   System.out.println("size: "+selectionColorPossibility.size());
            }
            n++;
            c++;
        } while (c < saynicecolor.size() - 1);
        for (int j = 0; j < diff.size(); j++) {
            selectionColor.add(diff.get(j));
        }
        return selectionColor;
        //    for(int j = 0; j <  selectionColor.size(); j++) {
        //    System.out.println(selectionColor.get(j));
        //  }
        //
        //  System.out.println("Size: " +   selectionColor.size());
    }

    float[] EachClorTotalPixel = new float[allcolorsNum];

    /**
     * 点赞后，每个颜色所占的像素值的概率
     */
    public float[] GetEachClorPossibilityByPixel() {
        float selection_clor_each_pixel[] = GetEachClorTotalPixel();
        //  System.out.print("selection_clor_each_pixel.length: "+selection_clor_each_pixel.length+"\n");

        float total = 0f;
        for (int i = 0; i < selectionColor.size(); i++) {
            total += selection_clor_each_pixel[i];
        }
        for (int i = 0; i < selectionColor.size(); i++) {
            selection_clor_each_pixel[i] = selection_clor_each_pixel[i] / total;
            //  System.out.println( selection_clor_each_pixel[i]);
        }
        return selection_clor_each_pixel;

    }

    public int ChangeTable2() {
        float EachClorPossibilityByPixel[] = GetEachClorTotalPixel();
        float copyClorPossibilityByPixel[] = GetEachClorTotalPixel();
        float selection_clor_each_pixel[] = GetEachClorPossibilityByPixel();
        QickSort quicksort = new QickSort();
        quicksort.quick(EachClorPossibilityByPixel);
        for (int i = 0; i < EachClorPossibilityByPixel.length; i++) {
            if (EachClorPossibilityByPixel[EachClorPossibilityByPixel.length - 1] == copyClorPossibilityByPixel[i]) {
                //  System.out.println( selectionColor.get(i));
                for (int j = 0; j < eachClorPosiibilitt[0].length; j++) {
                    //  System.out.println("\n"+"changed table2");
                    USERBestClorNumber = i;
                    {
                        eachClorPosiibilitt[i][j] = selection_clor_each_pixel[j];
                    }
                    //   System.out.print(df.format(eachClorPosiibilitt[i][j])+"");}

                }
            }
        }
        return USERBestClorNumber;
    }

    /**
     * 所有颜色的出现概率由销量决定
     */
    public void GetEachColorPossibility() {
        CalculateTable1 calculateTable1 = new CalculateTable1();
        color_possibility = calculateTable1.CalculateTableArray();

    }

    /**
     * 获得表二
     */
    public void CalculateEachClorPossibility() {
        int sum[] = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                sum[i] += num[i][j];
            }
        }
        //      System.out.println("Table2");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                eachClorPosiibilitt[i][j] = num[i][j] / (float) (sum[i]);
                //       System.out.print(df.format(eachClorPosiibilitt[i][j])+" ");
            }
            //     System.out.println();
        }
    }

    /**
     * 计算获得表三
     *
     * @return
     */
    public float[] CalculateTable3() {

        CalculateEachClorPossibility();
        ArrayList list = GetSlectionColor();
        float selectionClorPossibiltiyfloat[] = new float[selectionColorPossibility.size()];
        float table3[] = new float[num.length];
        //  System.out.println(selectionColorPossibility.size()+" ");
        for (int i = 0; i < selectionClorPossibiltiyfloat.length; i++) {
            selectionClorPossibiltiyfloat[i] = Float.parseFloat(String.valueOf(selectionColorPossibility.get(i)));
        }
        //   System.out.println(selectionClorPossibiltiyfloat.length+" "+eachClorPosiibilitt.length+" "+eachClorPosiibilitt[1].length);
        for (int i = 0; i < table3.length; i++) {
            for (int j = 0; j < num.length; j++) {
                table3[i] += selectionClorPossibiltiyfloat[j] * eachClorPosiibilitt[j][i];
            }
            //   System.out.print(" " + i + " :" + df.format(table3[i]));
        }
        return table3;
    }

    /**
     * 计算表四
     */
    public float[] CalculateFinalTable() {
        ArrayToStringandFloat();
        ColorAddress();
        CoefficientEffectColorPixelByTimes();
        USERBestClorNumber=ChangeTable2();
        float table3[] = CalculateTable3();
        float table4[] = new float[table3.length];
        float selectionClorPossibiltiyfloat[] = new float[selectionColorPossibility.size()];
        //  System.out.println(selectionColorPossibility.size()+" ");
        for (int i = 0; i < eachClorPosiibilitt.length; i++) {
            selectionClorPossibiltiyfloat[i] = Float.parseFloat(String.valueOf(selectionColorPossibility.get(i)));
        }
//        System.out.println(eachClorPosiibilitt.length+" "+eachClorPosiibilitt[0].length);
//
//        for (int i = 0; i <eachClorPosiibilitt.length; i++) {
//            System.out.println(selectionClorPossibiltiyfloat[i]);
//            System.out.println("eachClorPosiibilitt " + i + " : " + eachClorPosiibilitt[i][i]);
//        }
        float sim=0f;
        for (int i = 0; i < table3.length; i++) {
            table4[i] = selectionClorPossibiltiyfloat[i] * eachClorPosiibilitt[i][USERBestClorNumber] / table3[USERBestClorNumber];
            sim += table4[i];
               System.out.print("  第" + i + ": " + table4[i]);
        }
      //  System.out.println( " sim :"+sim);
        return table4;
    }

    public double GetCoefficientByTimes(int times) {
        double Coefficient = 1;
        for (int i = 0; i < times; i++) {
            Coefficient = Coefficient / 2;
        }
        return Coefficient;
    }

}
