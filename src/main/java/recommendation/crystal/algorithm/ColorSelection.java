//package recommendation.crystal.algorithm;
//
//
//import Jama.Matrix;
//import costume.HisCloth;
//
//import java.util.ArrayList;
//
///**
// * Created by crystal.liker on 2015/7/28.
// */
//public class ColorSelection {
//    //随机算出
//    HumanData user_data1= new HumanData();
//    HumanData user_data2= new HumanData();
//    HumanData user_data3= new HumanData();
//    HisCloth cloth1= new HisCloth("衬衫",90.4,"OL","红色",30);
//    HisCloth cloth2= new HisCloth("T恤",100.5,"通勤","蓝色",40);
//    HisCloth cloth3= new HisCloth("吊带",50.4,"简约","白色",20);
//    HisCloth cloth4= new HisCloth("吊带",50.4,"简约","白色",98);
//    HisCloth cloth5= new HisCloth("T恤",100.5,"通勤","蓝色",99);
//    ArrayList<HumanData> users = new ArrayList<HumanData>();
//    ArrayList<HisCloth> clothes = new ArrayList<HisCloth>();
//    ArrayList<HisCloth> user1_maked_clothes = new ArrayList<HisCloth>();
//    ArrayList<HisCloth> user2_maked_clothes = new ArrayList<HisCloth>();
//    ArrayList<HisCloth> similar_clothes = new ArrayList<HisCloth>();
//    SimilarDegreeByCos similarity = new SimilarDegreeByCos();
//    String user1 ="偏白 正常 青年 内向 A 162";//肤色 体重 年纪 性格 体型 身
//    String user2="偏黄 正常 青年 外向 X 163";
//    String user3="偏白 偏胖 青年 外向 A 165";
//
//    int k;//K 为权重的系数
//    public float[][] InitialMatrix()
//    {
//        user1_maked_clothes.add(cloth1);
//        user1_maked_clothes.add(cloth2);
//        user1_maked_clothes.add(cloth3);
//        int total_score[] = new int[5];
//        user2_maked_clothes.add(cloth4);
//        user2_maked_clothes.add(cloth5);
//        users.add(user_data1);
//        users.add(user_data2);
//        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
//        list.add(user1_maked_clothes);
//        list.add(user2_maked_clothes);
//        //价格排序
//        //相同的衣服放入Arraylist
//        System.out.print("\n");
//        int score[] = new int[5];
//            for (int i = 0; i < list.get(0).size(); i++) {
//                for (int j = 0; j < list.get(1).size(); j++) {
//                    if (user1_maked_clothes.get(i).equals(user2_maked_clothes.get(j))) {
//                        similar_clothes.add(user1_maked_clothes.get(i));
//                        similar_clothes.add(user2_maked_clothes.get(j));
//                    }
//                }
//            }
//        float [][] m = new float[users .size()+(int)(similar_clothes.size()/2)][users .size()+(int)(similar_clothes.size()/2.0)];
//        for(int i =0; i<users.size();i++)
//        {
//            for(int j =0;j<users.size();j++)
//            {
//               if(i!=j)
//               {
//                   m[i][j]= new Float(similarity.getSimilarDegree(user1,user2));////////////////////待改
//               }
//            }
//        }
//      for(int j =0 ; j<users.size();j++)
//      {
//          for(int i =users.size() ; i<m.length;i++)
//          {
//              m[i][j]=  new Float(similar_clothes.get((i-users.size())*2+j).getScore());
//          }
//      }
//        for(int j =users.size() ; j<m.length;j++)
//        {
//            for(int i =0 ; i<users.size();i++)
//            {
//                m[i][j]= new Float(similar_clothes.get(i+(j-users.size())*2).getScore());
//            }
//        }
//       for (int i =0; i<m.length;i++)
//       {
//           for(int j=0;j<m.length;j++) {
//               System.out.print(" " + m[i][j]);
//           }
//           System.out.print("\n");
//       }
//        return  m;
//
//    }
//    /**
//     * 求矩阵的逆矩阵 为矩阵右加一个单位矩阵后进行初等行变换，当左边变成单位矩阵时，右边就是求得的逆矩阵。 矩阵的初等行变换法则
//     * （1）交换变换：交换两行 （2）倍法变换：给一行数据乘以一个非0常数 （3）消法变换：把一行所有元素的k倍加到另一行的对应元素上去
//     * 将上述规则中的行换成列同样有效 只有方阵才可能有逆矩阵！
//     *
//     * @return
//     */
//    public double[][] inverseMatrix() {
//        // 再进行初等变换，把左边部分变成单位矩阵
//        float[][] tempData =InitialMatrix() ;
//        int tempRow = tempData.length;
//        int tempCol = tempData[0].length;
//        // 对角线上数字为0时，用于交换的行号
//        int line = 0;
//        // 对角线上数字的大小
//        double bs = 0;
//        // 一个临时变量，用于交换数字时做中间结果用
//        double swap = 0;
//        for (int i = 0; i < tempRow; i++) {
//            // 将左边部分对角线上的数据等于0，与其他行进行交换
//            if (tempData[i][i] == 0) {
//                if (++line >= tempRow) {
//                    System.out.println("此矩阵没有逆矩阵！");
//                    return null;
//                }
//
//                for (int j = 0; j < tempCol; j++) {
//                    swap = tempData[i][j];
//                    tempData[i][j] = tempData[line][j];
//                    tempData[line][j] = new Float(swap);
//                }
//
//                // 当前行（第i行）与第line行进行交换后，需要重新对第i行进行处理
//                // 因此，需要将行标i减1，因为在for循环中会将i加1。
//                i--;
//                // 继续第i行处理，此时第i行的数据是原来第line行的数据。
//                continue;
//            }
//
//            // 将左边部分矩阵对角线上的数据变成1.0
//            if (tempData[i][i] != 1) {
//                bs = tempData[i][i];
//                for (int j = tempCol - 1; j >= 0; j--) {
//                    tempData[i][j] /= bs;
//                }
//                // 将左边部分矩阵变成上对角矩阵，
//                // 所谓上对角矩阵是矩阵的左下角元素全为0
//                for (int iNow = i + 1; iNow < tempRow; iNow++) {
//                    for (int j = tempCol - 1; j >= i; j--) {
//                        tempData[iNow][j] -= tempData[i][j] * tempData[iNow][i];
//                    }
//                }
//            }
//        }
//
//        // 将左边部分矩阵从上对角矩阵变成单位矩阵，即将矩阵的右上角元素也变为0
//        for (int i = 0; i < tempRow - 1; i++) {
//            for (int iNow = i; iNow < tempRow - 1; iNow++) {
//                for (int j = tempCol - 1; j >= 0; j--) {
//                    tempData[i][j] -= tempData[i][iNow + 1]
//                            * tempData[iNow + 1][j];
//                }
//            }
//        }
//
//        // 右边部分就是它的逆矩阵
//        Matrix c = null;
//        int cRow = tempRow;
//        int cColumn = tempCol / 2;
//        double[][] cData = new double[cRow][cColumn];
//        // 将右边部分的值赋给cData
//        for (int i = 0; i < cRow; i++) {
//            for (int j = 0; j < cColumn; j++) {
//                cData[i][j] = tempData[i][cColumn + j];
//            }
//        }
//        // 得到逆矩阵，返回
//        return cData;
//    }
//
//    public double[][] TransimitToCholesky(double a[][])
//    {
//        int size = a.length;
//        double  l[][]=new double[size][size];
//        double b[]= new double [size];
//        double x[]= new double [size];
//        double y[]= new double [size];
//
//
//        int n =0;
//        for(int i =0;i<a.length;i++)
//        {
//
//        }
//        for(int i =0 ; i<a.length;i++)
//        {
//            for(int j =0; j<a.length;j++)
//            {
//                if(a[i][j]==a[j][i])
//                n=n+1;
//            }
//        }
//        if(n!=a.length*a.length)
//        {
//            throw new IllegalArgumentException("此矩阵无法使用平方根法！");
//        }else
//        {
//            System.out.print("可以使用平方根法！");
//        }
//        l[0][0]=Math.sqrt(a[0][0]);
//        for(int i =0 ;i<size;i++)
//        {
//            l[i][0]=a[i][0]/l[0][0];
//        }
//        for(int i =0;i<size;i++)
//        {
//            l[i][i]=a[i][i];
//        for(k=0;k<i;k++)
//        {
//            l[i][i]=l[i][i]-l[i][k]*l[i][k];
//        }
//            l[i][i]=Math.sqrt(l[i][i]);
//            for(int j=i+1;j<size;j++)  //////
//            {
//                l[j][i]=a[j][i];
//                for(k=0;k<i;k++)
//                {
//                    l[j][i]=l[j][i]-l[j][k]*l[i][k];
//                }
//                l[j][i]=l[j][i]/l[i][i];
//            }
//        }
//        y[0]=b[0]/l[0][0];
//        for(int i=1;i<size;i++)   {
//            y[i]=b[i];
//        for(k=0;k<i;k++)
//        {
//            y[i]=y[i]-l[i][k]*y[k];
//        }
//            y[i]=y[i]/l[i][i];}
//        for(int i=0;i<size;i++)
//        {
//            for(int j=i+1;j<size;j++)
//        {
//            l[i][j]=0;
//        }
//        }
//        return l;
//    }
//}
