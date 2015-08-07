package recommendation.crystal.algorithm;


import recommendation.crystal.information.*;

import java.util.ArrayList;

/**
 * Created by crystal.liker on 2015/6/22.
 */
public class IGA {
    final static int TheMaxTypeOfCloth = 10;
    private static float RateOfStyleEffection[] = {0.2f, 0.2f, 0.4f, 0.05f, 0.15f};
    private static float RateOfStyleEffection6[] = {0.2f, 0.1f, 0.2f, 0.05f, 0.15f,0.3f};
    private static float RateOfStyleEffection4[] = {0.2f, 0.2f, 0.4f, 0.3f};
    public static final int N = 2;                            //算子
    public int gernation = 0;
    int NumberOfAdvertisementCloth = 4;                       //推荐的衣服套数
    GetScore getscore = new GetScore();
    ArrayList ID = getscore.readScore("ID");
    ArrayList ID_text = getscore.readScore("ID");             //获取数据
    int GENE = ID.size();                                    //基因数
    ArrayList score = getscore.readScore("score");           //获取分数
    String[] forstore = GetToString(ID_text);
    String[] test = GetToString(ID_text);
    String selection[] = new String[2];                       //交叉时所选择的父母基因
    float fitness[] = new float[test.length];                 //每条染色体的适应度
    int length[] = new int[TheMaxTypeOfCloth];                //记录每条染色体中每个部件的长度
    int count = 0;                                            //记录部件的数目
    float[] forstorescore = new float[ID_text.size()];
    private String best = "";                          //记录最佳染色体
    private float bestfitness;
    private String beststr;

    /**
     * @param x
     * 将 动态数组转化成String数组，以便运算
     * @return
     */
    public String[] GetToString(ArrayList x) {
        String[] test = new String[x.size()];
        for (int i = 0; i < x.size(); i++) {
            test[i] = String.valueOf(x.get(i));
             //  System.out.print(i+"i:"+test[i]+"\n");
        }
        return test;
    }

    /**
     *获得float型分数
     */
    public void GetScore() {
        for (int i = 0; i < score.size(); i++) {
            forstorescore[i] = Float.parseFloat(String.valueOf(score.get(i)));
           //  System.out.print(i+": "+forstorescore[i]+"\n");
        }
    }

    /**
     * 将一条染色体分成多个部件的染色体，以便计算适应度。由不同的衣服进行分类
     * @param cloth_type
     */
    public void TypeOfComponent(String cloth_type) {
        ArrayList<ArrayList> ID_tatal = new ArrayList<>();
        if (cloth_type.equalsIgnoreCase("Ucloth")) {
            ReadUcloth Ucloth = new ReadUcloth();
            ArrayList ID1 = Ucloth.readUCloth("collar");
            ArrayList ID2 = Ucloth.readUCloth("sleeve");
            ArrayList ID3 = Ucloth.readUCloth("style");
            ArrayList ID4 = Ucloth.readUCloth("pattern");
            ArrayList ID5 = Ucloth.readUCloth("length");
            ID_tatal.add(ID1);
            ID_tatal.add(ID2);
            ID_tatal.add(ID3);
            ID_tatal.add(ID4);
            ID_tatal.add(ID5);
            for (int i = 0; i < ID_tatal.size(); i++) {
                int l = ID_tatal.get(i).size() - 1;
                String bl = Integer.toBinaryString(l);
                length[i] = bl.length();
                //   System.out.print(length[i]+" ");
            }
        }
        if (cloth_type.equalsIgnoreCase("Coat")) {
            ReadCoat coat = new ReadCoat();
            ArrayList ID1 = coat.readCoat("sleeve");
            ArrayList ID2 = coat.readCoat("length");
            ArrayList ID3 = coat.readCoat("thickness");
            ArrayList ID4 = coat.readCoat("collar");
            ArrayList ID5 = coat.readCoat("button");
            ArrayList ID6 = coat.readCoat("style");
            ID_tatal.add(ID1);
            ID_tatal.add(ID2);
            ID_tatal.add(ID3);
            ID_tatal.add(ID4);
            ID_tatal.add(ID5);
            ID_tatal.add(ID6);
            for (int i = 0; i < ID_tatal.size(); i++) {
                int l = ID_tatal.get(i).size() - 1;
                String bl = Integer.toBinaryString(l);
                length[i] = bl.length();
                 // System.out.print(length[i]+" ");
            }
        }
        if (cloth_type.equalsIgnoreCase("Pant")) {
            ReadPants pant = new ReadPants();
            ArrayList ID1 = pant.readPant("length");
            ArrayList ID2 = pant.readPant("shape");
            ArrayList ID3 = pant.readPant("thickness");
            ArrayList ID4 = pant.readPant("waist");
            ArrayList ID5 = pant.readPant("style");
          //  for(int i =0;i<ID1.size();i++)
          //  {
          //      System.out.println(ID1.size());
          //      System.out.println(ID1.get(i));
          //  }
            ID_tatal.add(ID1);
            ID_tatal.add(ID2);
            ID_tatal.add(ID3);
            ID_tatal.add(ID4);
            ID_tatal.add(ID5);
            for (int i = 0; i < ID_tatal.size(); i++) {
                int l = ID_tatal.get(i).size() - 1;
                String bl = Integer.toBinaryString(l);
                length[i] = bl.length();
              //     System.out.print(length[i]+" ");
            }
        }
        if (cloth_type.equalsIgnoreCase("Dress")) {
            ReadDress dress = new ReadDress();
            ArrayList ID1 = dress.readDress("collar");
            ArrayList ID2 = dress.readDress("sleeve");
            ArrayList ID3 = dress.readDress("style");
            ArrayList ID4 = dress.readDress("shape");
            ArrayList ID5 = dress.readDress("length");
            ID_tatal.add(ID1);
            ID_tatal.add(ID2);
            ID_tatal.add(ID3);
            ID_tatal.add(ID4);
            ID_tatal.add(ID5);
            for (int i = 0; i < ID_tatal.size(); i++) {
                int l = ID_tatal.get(i).size() - 1;
                String bl = Integer.toBinaryString(l);
                length[i] = bl.length();
              //     System.out.print(length[i]+" ");
            }
        }
        if (cloth_type.equalsIgnoreCase("Bdress")) {
            ReadBdress dress = new ReadBdress();
            ArrayList ID1 = dress.readBdress("style");
            ArrayList ID2 = dress.readBdress("shape");
            ArrayList ID3 = dress.readBdress("length");
            ArrayList ID4 = dress.readBdress("waist");
            ID_tatal.add(ID1);
            ID_tatal.add(ID2);
            ID_tatal.add(ID3);
            ID_tatal.add(ID4);
            for (int i = 0; i < ID_tatal.size(); i++) {
                int l = ID_tatal.get(i).size() - 1;
                String bl = Integer.toBinaryString(l);
                length[i] = bl.length();
                //  System.out.print(length[i]+" ");
            }
        }

        count = 0;
        for (int i = 0; i < TheMaxTypeOfCloth; i++) {
            if (length[i] != 0) {
                count = count + 1;
            }
        }
       // System.out.println(count);


    }

    /**
     * @param test
     * 分割每条染色体，按照部件
     * @return
     */
    public String[][] SlipIDToComponent(String[] test) {
        String ComponentID[][] = new String[test.length][count];
        for (int i = 0; i < test.length; i++) {
            int len = 0;
            for (int j = 0; j < count; j++) {
                ComponentID[i][j] = test[i].substring(len, len + length[j]);
                len = len + length[j];
            //    System.out.print(ComponentID[i][j] + " ");
            }
          //  System.out.println();
        }
        return ComponentID;
    }

    //类型待补全
    public String[] SingleSlipIDToComponent(String test) {
        String Components[] = new String[count];
        int len = 0;
        for (int j = 0; j < count; j++) {
            Components[j] = test.substring(len, len + length[j]);
            len = len + length[j];
        }
        return Components;
    }

    /**
     * 计算染色体适应度
     */
    public void CalculateFitness() {
        String[][] has_score_compoment = SlipIDToComponent(forstore);
        String[][] test_component = SlipIDToComponent(test);
        float average = 0.0f;
        float sum = 0.0f;
        float count1 = 0.0f;
        // System.out.print("bbbbbbbbb"+test_component.length+"aaaaa"+test_component[1].length);
        float[][] component_score = new float[test.length][count];
        //求和
        for (int i = 0; i < test.length; i++) {
            //  System.out.print("lalal "+fitness[i]);
            sum = forstorescore[i] + sum;
            count1 = count1 + 1;
        }
        average = sum / count1;
        // System.out.print("lalal "+average);
        //遍历每件以评价的衣服的每个部件，求适应度
        for (int j = 0; j < count; j++) {
            for (int i = 0; i < test.length; i++) {
                float total_score = 0;
                count1 = 0.0f;
                //计算每个部件的适应度
                for (int x = 0; x < test.length; x++) {
                    if (test_component[i][j].equals(has_score_compoment[x][j])) {
                        total_score = total_score + forstorescore[x];
                        count1 = count1 + 1;
                    }
                }
                if (count1 == 0) {
                    total_score = average;
                    if(count == 5)
                    component_score[i][j] = total_score * RateOfStyleEffection[j];
                    if(count == 6)
                        component_score[i][j] = total_score * RateOfStyleEffection6[j];
                } else {
                    if(count == 5)
                    component_score[i][j] = (total_score / count1) * RateOfStyleEffection[j];
                    if(count == 6)
                        component_score[i][j] = (total_score / count1) * RateOfStyleEffection6[j];
                }
            }
        }
        float fitness_middle[] = new float[fitness.length];
        for (int i = 0; i < fitness.length; i++) {
            for (int j = 0; j < count; j++) {
                //System.out.print(component_score[i][j] + " ");
                fitness_middle[i] += component_score[i][j];
                // System.out.print(fitness[i]+" ");
            }
            fitness[i] = fitness_middle[i];
            // System.out.print(fitness[i]+" ");
        }
        // System.out.print("\n");
    }

    /**
     * 联盟算子，染色体进行选择
     */
    public void select() {
        int count1;
        int count2;
        int place[] = new int[2];
        for (int i = 0; i < ID_text.size(); i++) {
            if ("".equals(best)) {
                best = "ok";
                bestfitness = fitness[i];
                beststr = test[i];

            } else {
                if (fitness[i] > bestfitness)
                {
                    bestfitness = fitness[i];
                    beststr = test[i];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            count1 = (int) (Math.random() * fitness.length);
            count2 = (int) (Math.random() * fitness.length);
            if (fitness[count1] > fitness[count2]) {
                place[i] = count1;
            } else {
                place[i] = count2;
            }
        }
        selection[0] = test[place[0]];
        selection[1] = test[place[1]];
    }

    public int[] StringToIntByBianry(String[] mp) {
        int countformp[] = new int[mp.length];
        for (int i = 0; i < mp.length; i++) {
            countformp[i] = Integer.parseInt(mp[i], 2);
        }
        return countformp;
    }
    //Partially Matching Crossover， PMX

    /**
     * 交叉操作 交叉率为25%，平均为25%的染色体进行交叉
     * 对ID_text添加孩子
     * 同时把对应的分数改为0
     * 添加检测循环，如果有没有定义的编号出现，再次交叉
     */
    public void cross() {
        String temp_a = "";
        String temp_b = "";
        Valid:
        for (int y = 0; y < ID.size(); y++) {
            if (Math.random() < 0.25) {
                int pos = (int) (Math.random() * GENE);
                temp_a = selection[0].substring(0, pos)
                        + selection[1].substring(pos);
                temp_b = selection[1].substring(0, pos)
                        + selection[0].substring(pos);
                test[y] = temp_a;
                test[(y + 1) / ID.size()] = temp_b;
            }
        }

    }

    /**
     * 基因突变操作 1%基因变异
     * 对所有种群ID_text，有一定几率变异
     * 添加检测循环，如果有没有定义的编号出现，再次交叉
     */
    public void mutation() {
        int[] countfornewcode;
        int m = 0;
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * GENE * ID.size() + 1);
            int chromosomeNum = (int) (num / GENE) + 1; // 染色体号
            int mutationNum = num - (chromosomeNum - 1) * GENE; // 基因号
            if (mutationNum == 0)
                mutationNum = 1;
            chromosomeNum = chromosomeNum - 1;
            if (chromosomeNum >= ID.size())
                chromosomeNum = ID.size() - 1;
            String temp;
            if (test[chromosomeNum].charAt(mutationNum - 1) == '0') {
                if (mutationNum == 1) {
                    temp = "1" + test[chromosomeNum].substring

                            (mutationNum);
                } else {
                    if (mutationNum != GENE) {
                        temp = test[chromosomeNum].substring(0, mutationNum -

                                1) + "1" + test[chromosomeNum].substring(mutationNum);
                    } else {
                        temp = test[chromosomeNum]
                                .substring(0, mutationNum - 1)
                                + "1";
                    }
                }
            } else {
                if (mutationNum == 1) {
                    temp = "0" + test[chromosomeNum].substring

                            (mutationNum);
                } else {
                    if (mutationNum != GENE) {
                        temp = test[chromosomeNum].substring(0, mutationNum -

                                1) + "0" + test[chromosomeNum].substring(mutationNum);
                    } else {
                        temp = test[chromosomeNum]
                                .substring(0, mutationNum - 1)
                                + "1";
                    }
                }
            }

        }

        // for(int i = 0; i<test.length;i++)
        // {
        //      System.out.print(fitness[i]+" ");
        //  }

    }


    /**
     * 在选择交叉变异多次后，获得高分的编码,获得高分的分数（其中包括一个变异中最好的染色体）
     */
    String[] topfourCode = new String[NumberOfAdvertisementCloth];
    float[] topfourscore = new float[NumberOfAdvertisementCloth];

    public void getTopCodes() {
        QickSort quick = new QickSort();
        float[] sortscore = fitness;
        quick.quick(sortscore);
        for (int i = 0; i < NumberOfAdvertisementCloth - 1; i++) {
            topfourscore[i] = sortscore[sortscore.length - i - 1];//最高的前3个
        }
        topfourscore[NumberOfAdvertisementCloth - 1] = bestfitness;
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < NumberOfAdvertisementCloth - 1; j++)
                if (topfourscore[j] == sortscore[i]) {
                    topfourCode[j] = test[i];
                }
        }
        topfourCode[NumberOfAdvertisementCloth - 1] = beststr;
    }

    /**
     * 计算染色体相似度 GetKeyword已使用
     * 遍历数据库中所有染色体，计算他们和最好编码的染色体适应度
     * 选择最高的3套
     */
    String fianlAdvertiseCloth[] = new String[NumberOfAdvertisementCloth];

    public void CalculatSimilarity() {
        getTopCodes();
        GetData data = new GetData();
        ArrayList allCode = data.readData();
        String slip[][] = SlipIDToComponent(topfourCode);
        String allStringCode[][] = SlipIDToComponent(GetToString(allCode));
        float similarities[] = new float[allCode.size()];
        float slipedsimilarity[][] = new float[allCode.size()][count];
        for (int y = 0; y < count; y++) {
            for (int i = 0; i < slip.length; i++) {
                for (int j = 0; j < allStringCode.length; j++) {
                    if (allStringCode[j][y].equals(slip[i][y])) {
                        ///////////////////////////////////////
                        slipedsimilarity[j][y] = topfourscore[i] * RateOfStyleEffection6[y];
                    }
                }
            }
        }
        for (int i = 0; i < allCode.size(); i++) {
            for (int j = 0; j < count; j++) {
                similarities[i] += slipedsimilarity[i][j];
            }// System.out.println(similarities[i]);
        }
        float[] similarities_copy = similarities;
        QickSort quicksort = new QickSort();
        quicksort.quick(similarities);

        for (int i = 0; i < allCode.size(); i++) {
            for(int j =0 ; j <NumberOfAdvertisementCloth;j++)
            {
            if (similarities[similarities.length - j-1] == similarities_copy[i]) {
                fianlAdvertiseCloth[j] = String.valueOf(allCode.get(i));
                // System.out.println(allCode.get(i));
            }
           }
        }
    }

    public void GetKeyword(String Type) {

        String compo[][] = SlipIDToComponent(fianlAdvertiseCloth);
        int position[][] = new int[compo.length][compo[0].length];
        for (int j = 0; j < compo.length; j++) {
            for (int i = 0; i < compo[0].length; i++) {
                position[j][i] = Integer.parseInt(compo[j][i], 2);
              //    System.out.println(compo[j][i]+" ");
            }
            //  System.out.println();
        }
        String str[] = new String[compo.length];
        if (Type.equalsIgnoreCase("Ucloth")) {
            ReadUcloth read = new ReadUcloth();
            ArrayList<String> collar = read.readUCloth("collar");
            ArrayList<String> sleeve = read.readUCloth("sleeve");
            ArrayList<String> style = read.readUCloth("style");
            ArrayList<String> pattern = read.readUCloth("pattern");
            ArrayList<String> length = read.readUCloth("length");
            for (int i = 0; i < compo.length; i++) {
               // System.out.println(str[i]);
                str[i] += String.valueOf(collar.get(position[i][0])) + " " + String.valueOf(sleeve.get(position[i][1])) + " " +
                        String.valueOf(style.get(position[i][2])) + " " + String.valueOf(pattern.get(position[i][3])) + " "
                        + String.valueOf(length.get(position[i][4]));
                System.out.println(str[i]);
            }
        }
        if (Type.equalsIgnoreCase("Coat")) {
            ReadCoat read = new ReadCoat();
            ArrayList<String> sleeve = read.readCoat("collar");
            ArrayList<String> length = read.readCoat("length");
            ArrayList<String> thickness = read.readCoat("thickness");
            ArrayList<String> collar = read.readCoat("collar");
            ArrayList<String> button = read.readCoat("button");
            ArrayList<String> style = read.readCoat("style");
            for (int i = 0; i < compo.length; i++) {
               // System.out.print("aaaa"+position[i][2]);
                str[i] += String.valueOf(sleeve.get(position[i][0])) + " " + String.valueOf(length.get(position[i][1])) + " " +
                        String.valueOf(thickness.get(position[i][2])) + " " + String.valueOf(collar.get(position[i][3])) + " "
                        + String.valueOf(button.get(position[i][4])) + " "
                        + String.valueOf(style.get(position[i][5]));
                System.out.println(str[i]);
            }
        }
            if (Type.equalsIgnoreCase("Pant")) {
                ReadPants pant = new ReadPants();
                ArrayList length = pant.readPant("length");
                ArrayList shape = pant.readPant("shape");
                ArrayList thickness = pant.readPant("thickness");
                ArrayList waist = pant.readPant("waist");
                ArrayList style = pant.readPant("style");
                for (int i = 0; i < compo.length; i++) {
                  //   System.out.print("aaaa"+position[i][2]);
                    str[i] += String.valueOf(length.get(position[i][0])) + " " + String.valueOf(shape.get(position[i][1])) + " " +
                            String.valueOf(thickness.get(position[i][2])) + " " + String.valueOf(waist.get(position[i][3])) + " "
                            + String.valueOf(style.get(position[i][4]));
                    System.out.println(str[i]);
                }
            }
            if (Type.equalsIgnoreCase("dress")) {
                ReadDress dress = new ReadDress();
                ArrayList collar = dress.readDress("collar");
                ArrayList sleeve = dress.readDress("sleeve");
                ArrayList style = dress.readDress("style");
                ArrayList shape = dress.readDress("shape");
                ArrayList length = dress.readDress("length");
                for (int i = 0; i < compo.length; i++) {
                    // System.out.print("aaaa"+position[i][2]);
                    str[i] += String.valueOf(collar.get(position[i][0])) + " " + String.valueOf(sleeve.get(position[i][1])) + " " +
                            String.valueOf(style.get(position[i][2])) + " " + String.valueOf(shape.get(position[i][3])) + " "
                            + String.valueOf(length.get(position[i][4]));
                    System.out.println(str[i]);
                }
            }
            if (Type.equalsIgnoreCase("Bdress"))
            {
                ReadBdress dress = new ReadBdress();
                ArrayList style = dress.readBdress("style");
                ArrayList shape = dress.readBdress("shape");
                ArrayList length = dress.readBdress("length");
                ArrayList waist = dress.readBdress("waist");
                for (int i = 0; i < compo.length; i++) {
                    // System.out.print("aaaa"+position[i][2]);
                    str[i] += String.valueOf(style.get(position[i][0])) + " " + String.valueOf(shape.get(position[i][1])) + " " +
                            String.valueOf(length.get(position[i][2])) + " " + String.valueOf(waist.get(position[i][3])) ;
                    System.out.println(str[i]);

                }
            }
        }

}