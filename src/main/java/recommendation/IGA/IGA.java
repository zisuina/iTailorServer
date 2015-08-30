//package recommendation.IGA;
//
//import information.*;
//
//import java.util.ArrayList;
//
///**
// * Created by crystal.liker on 2015/6/22.
// */
//public class IGA {
//
//
//    public static void main(String[] args) {
//    }

package recommendation.IGA;

import costume.EnCodeService;
import recommendation.userSimilarity.ClothBinaryString;
import recommendation.userSimilarity.ClothComponent;
import util.QickSort;

import java.util.*;

/**
 * Created by crystal.liker on 2015/6/22.
 */
public class IGA {

    float[] RateOfStyleEffection;
    final static int TheMaxTypeOfCloth = 10;
    public static final int N = 2;                            //算子
    public int gernation = 0;
    int NumberOfAdvertisementCloth = 1;                       //推荐的衣服套数
    GetFakeSocre getscore = new GetFakeSocre();
    ArrayList ID = getscore.readScore("ID");
    ArrayList ID_text = getscore.readScore("ID");             //获取数据
    String selection[] = new String[2];                       //交叉时所选择的父母基因
    float fitness[];                                          //每条染色体的适应度
    int count = 0;                                            //记录部件的数目
    private String best = "";                                 //记录最佳染色体
    private float bestfitness;
    private String beststr;

    public List<String> recommend(Map<ClothBinaryString, Integer> clothScoreMap) {

        List<String> result = new ArrayList<>();
        Iterator<ClothBinaryString> iterator = clothScoreMap.keySet().iterator();
        if (iterator.hasNext()) {
            ClothBinaryString one = iterator.next();
            RateOfStyleEffection = new float[one.getComponents().size()];
            for (int i = 0; i < one.getComponents().size(); i++) {
                RateOfStyleEffection[i] = one.getComponents().get(i).getEffect();
            }
        }
        int[] score = GetScore(clothScoreMap);
        //clothScoreMap.keySet().size();
        int numberOfChromosome = clothScoreMap.size();
        count = GetCount(clothScoreMap);
        int GENE = 0;
        Set set = clothScoreMap.entrySet();
        Iterator it = set.iterator();
        if (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            GENE = me.getKey().toString().length();
            // System.out.println(me.getKey().toString().length());
        }//
        //   CalculateFitness(clothScoreMap);
        String[] test = GetCode(clothScoreMap);
//        for (int i = 0; i < test.length; i++) {
//            System.out.println("tttt "+test[i]);
//        }
        float fitness[] = new float[numberOfChromosome];
        int[] Score = GetScore(clothScoreMap);
        GetLength(clothScoreMap);

        for (int i = 0; i < 400; i++) {
            fitness = CalculateFitness(test, Score, numberOfChromosome, count);
            select(test, fitness);
            test = cross(test, GENE);
//                for (int j = 0; j < test.length; j++) {
//                    System.out.println("ccccc "+test[j]);
//                }
            test = mutation(test, GENE);
            //gernation = i;
            //TODO 把最高适应度衣服加到收敛矩阵
            //TODO 判断收敛矩阵是否收敛
            // while (true) {
            //TODO 根据初始种群的数量选择联盟算子N，随机挑N件，最高值做父辈
            //TODO 选择交叉算子，对父母染色体组件进行交换
            //TODO 选择变异算子，对孩子染色体进行变异(变异率如何控制)
            //TODO 对两条新孩子染色体计算适应度
            //TODO 初始种群排序
            //TODO 替换排序完的最差两个后代
            //(思考：为什么不多制造后代替换初始种群)
            //TODO 把新种群最高值加入收敛矩阵(如果放入平均值值得考虑)
            //(思考：只需要比较两个新后代与初始矩阵最高值即可，因为我们只care收敛性)
            //TODO 如果跑了500次收敛矩阵还不收敛，直接跳出
            //  }
            //TODO 随机选出收敛矩阵中的一件衣服进行二进制解码(取出一件还是多件值得考虑)
        }
        //CalculatSimilarity();
        String[] fianlAdvertiseCloth = CalculatChromosomeSimilarity(test, count);
        for (int i = 0; i < fianlAdvertiseCloth.length; i++) {
            System.out.println(fianlAdvertiseCloth[i]);
        }
        for (String temp : fianlAdvertiseCloth) {
            result.add(becomeToWordsFromBinary(temp));

        }
        return result;
    }

    private String becomeToWordsFromBinary(String temp) {
        //TODO for liker
        return "";
    }

    //TODO 上下衣如何推荐


    public String[] GetCode(Map<ClothBinaryString, Integer> clothScoreMap) {
        int j = 0;
        String test[] = new String[clothScoreMap.size()];
        for (ClothBinaryString key : clothScoreMap.keySet()) {
            test[j] = key.toString();

            j++;
        }
//        for (int i = 0; i < test.length; i++) {
//            System.out.println(test[i]+" ");
//        }
        return test;
    }

    public int[] GetScore(Map<ClothBinaryString, Integer> clothScoreMap) {
        int i = 0;
        int score[] = new int[clothScoreMap.size()];
        for (Integer v : clothScoreMap.values()) {
            score[i] = v;
            //  System.out.println(score[i]);
            i++;
        }
        return score;
    }

    int length[] = new int[TheMaxTypeOfCloth];

    public void GetLength(Map<ClothBinaryString, Integer> clothScoreMap) {

        for (ClothBinaryString key : clothScoreMap.keySet()) {
            List<ClothComponent> components = key.getComponents();
            count = 0;
            for (int i = 0; i < components.size(); i++) {
                // System.out.println(components.get(i));
                length[i] = components.get(i).getComponent().toString().length();
                //  System.out.println(length[i]);
                count++;
            }
        }
    }

    public int[] GetArrayLength(Map<ClothBinaryString, Integer> clothScoreMap) {

        for (ClothBinaryString key : clothScoreMap.keySet()) {
            List<ClothComponent> components = key.getComponents();
            count = 0;
            for (int i = 0; i < components.size(); i++) {
                // System.out.println(components.get(i));
                length[i] = components.get(i).getComponent().toString().length();
                // System.out.println(length[i]);

            }
        }
        return length;
    }

    public String[][] Slip(Map<ClothBinaryString, Integer> clothScoreMap) {
        String[][] component = new String[clothScoreMap.size()][];
        for (ClothBinaryString key : clothScoreMap.keySet()) {
            List<ClothComponent> components = key.getComponents();
            component = new String[clothScoreMap.size()][components.size()];
            for (int j = 0; j < clothScoreMap.size(); j++) {
                for (int i = 0; i < components.size(); i++) {
                    // System.out.println(components.get(i));
                    component[j][i] = components.get(i).getComponent().toString();
                    // System.out.println(length[i]);

                }
            }
        }
        return component;
    }

    public int GetCount(Map<ClothBinaryString, Integer> clothScoreMap) {
        for (ClothBinaryString key : clothScoreMap.keySet()) {
            List<ClothComponent> components = key.getComponents();
            count = 0;
            for (int i = 0; i < components.size(); i++) {
                count++;
            }
        }
        return count;
    }

    public String[][] SlipIDToComponent(Map<ClothBinaryString, Integer> clothScoreMap) {
        GetLength(clothScoreMap);
        length = GetArrayLength(clothScoreMap);
        String[] test = GetCode(clothScoreMap);
//        for (int i = 0; i < length.length; i++) {
//            System.out.println(count);
//        }

        String ComponentID[][] = new String[test.length][count];
        for (int i = 0; i < test.length; i++) {
            int len = 0;
            for (int j = 0; j < count; j++) {
                ComponentID[i][j] = test[i].substring(len, len + length[j]);
                len = len + length[j];
                //System.out.print(ComponentID[i][j] + " ");
            }
            //System.out.println();
        }
        return ComponentID;
    }

    //
    public String[][] SlipIDToComponent(String[] test, int count) {

        String ComponentID[][] = new String[test.length][count];
        // System.out.println(count);
        //      System.out.println("test[1].length()： "+test[1].length());
        for (int i = 0; i < test.length; i++) {
            int len = 0;
            for (int j = 0; j < count; j++) {
                ComponentID[i][j] = test[i].substring(len, len + length[j]);
                len = len + length[j];
                // System.out.print(len + " ");

            }
            // System.out.println();
        }
        return ComponentID;
    }

    /**
     * @param x 将 动态数组转化成String数组，以便运算
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
     * 计算染色体适应度
     */
    public float[] CalculateFitness(String[] test, int[] Score, int numberOfChromosome, int count) {

        int forstorescore[] = Score;
        String forstore[] = test;
        String[][] has_score_compoment = SlipIDToComponent(forstore, count);
        String[][] test_component = SlipIDToComponent(test, count);
//        for (int i = 0; i <has_score_compoment.length ; i++) {
//            System.out.println("sss "+has_score_compoment[i]);
//        }
        float average = 0.0f;
        float sum = 0.0f;
        float count1 = 0.0f;
        fitness = new float[numberOfChromosome];
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
                    component_score[i][j] = total_score * RateOfStyleEffection[j];

                } else {
                    component_score[i][j] = (total_score / count1) * RateOfStyleEffection[j];

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
        return fitness;
    }

    /**
     * 联盟算子，染色体进行选择
     */
    public void select(String[] test, float fitness[]) {
        int count1;
        int count2;
        int place[] = new int[2];
        for (int i = 0; i < test.length; i++) {
            if ("".equals(best)) {
                best = "ok";
                bestfitness = fitness[i];
                beststr = test[i];

            } else {
                if (fitness[i] > bestfitness) {
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
    public String[] cross(String[] test, int GENE) {
        String temp_a = "";
        String temp_b = "";
        Valid:
        for (int y = 0; y < test.length; y++) {
            if (Math.random() < 0.25) {
                int pos = (int) (Math.random() * GENE);
                temp_a = selection[0].substring(0, pos)
                        + selection[1].substring(pos);
                temp_b = selection[1].substring(0, pos)
                        + selection[0].substring(pos);
                test[y] = temp_a;
                test[(y + 1) / test.length] = temp_b;
            }
        }
        return test;
    }

    /**
     * 基因突变操作 1%基因变异
     * 对所有种群ID_text，有一定几率变异
     * 添加检测循环，如果有没有定义的编号出现，再次交叉
     */
    public String[] mutation(String[] test, int GENE) {
        int[] countfornewcode;
        int m = 0;
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * GENE * test.length + 1);
            int chromosomeNum = (int) (num / GENE) + 1; // 染色体号
            int mutationNum = num - (chromosomeNum - 1) * GENE; // 基因号
            if (mutationNum == 0)
                mutationNum = 1;
            chromosomeNum = chromosomeNum - 1;
            if (chromosomeNum >= test.length)
                chromosomeNum = test.length - 1;
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
                test[chromosomeNum] = temp;
            }

        }
        return test;
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

    public void getTopCodes(String[] test) {
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


    public String[] CalculatChromosomeSimilarity(String[] test, int count) {
        String fianlAdvertiseCloth[] = new String[NumberOfAdvertisementCloth];
        getTopCodes(test);
        GetFakeDataBase data = new GetFakeDataBase();
        ArrayList allCode = data.readData();
        String slip[][] = SlipIDToComponent(topfourCode, count);
//        for (int i = 0; i < allCode.size(); i++) {
//
//            System.out.println(allCode.get(i));
//        }
        //allCode 数据库里的所有衣服
        String allStringCode[][] = SlipIDToComponent(GetToString(allCode), count);

        float similarities[] = new float[allCode.size()];
        float slipedsimilarity[][] = new float[allCode.size()][count];
        for (int y = 0; y < count; y++) {
            for (int i = 0; i < slip.length; i++) {
                for (int j = 0; j < allStringCode.length; j++) {
                    if (allStringCode[j][y].equals(slip[i][y])) {
                        ///////////////////////////////////////
                        slipedsimilarity[j][y] = topfourscore[i] * RateOfStyleEffection[y];
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
            for (int j = 0; j < NumberOfAdvertisementCloth; j++) {
                if (similarities[similarities.length - j - 1] == similarities_copy[i]) {
                    fianlAdvertiseCloth[j] = String.valueOf(allCode.get(i));
                    // System.out.println(allCode.get(i));
                }
            }
        }
        return fianlAdvertiseCloth;
    }


}

