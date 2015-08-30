package recommendation;

import crawler.SkuItem;
import enums.*;
import hibernate.elements.Color;
import hibernate.recommendation.ClothingImage;
import recommendation.IGA.IGA;
import recommendation.colorTable.CalculateTable1;
import recommendation.colorTable.ChooseColorWhileFavorColorTable;
import recommendation.colorTable.ColorProbability;
import recommendation.colorTable.PeopleFavorColorTable;
import recommendation.userSimilarity.*;
import util.BaseDAO;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.*;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class RunRecommendation {

    User user1;
    User user2;

    public void init() {
        user1 = new User(20, 162, 54, BodyShape.A, BodyFaceShape.椭圆脸, Personality.内向, new Color(254, 255, 200), Gender.FEMALE);
        user2 = new User(25, 159, 50, BodyShape.X, BodyFaceShape.圆脸, Personality.内向, new Color(200, 255, 200), Gender.FEMALE);
    }

    private int must_star_size = 10;
    private int min_similar_day = 3;
    private int push_limit = 3;
    private Timestamp today = new Timestamp(currentTimeMillis());
    List<ItemWithTimeAndScore> items = new ArrayList<>();

    private Map<ClothBinaryString, Integer> coatStringMap = new HashMap<>();
    private Map<ClothBinaryString, Integer> dressStringMap = new HashMap<>();
    private Map<ClothBinaryString, Integer> hDressStringMap = new HashMap<>();
    private Map<ClothBinaryString, Integer> pantStringMap = new HashMap<>();
    private Map<ClothBinaryString, Integer> uClothStringMap = new HashMap<>();
    private Map<ClothBinaryString, Integer> undefineStringMap = new HashMap<>();

    private Users users = new Users();

    public Map<ClothType,String> run(User user) {
        if (user.getItems().size() < must_star_size) {
            User two = CalculateSimilarity.getMostSimilarityUser(user, users);
            if (two != null) {
                List<Item> itemList = new ArrayList<>();
                for (ItemWithTimeAndScore itemWithTimeAndScore : two.getItems()) {
                    if ((itemWithTimeAndScore.getTimestamp().getTime() - today.getTime() / (1000 * 60 * 60 * 24) < min_similar_day)) {
                        itemList.add(itemWithTimeAndScore);
                    }
                }
                pushToUser(itemList.subList(0, itemList.size() > push_limit ? push_limit : itemList.size()));
            }
        } else {
            items = user.getItems();
            //TODO  转换成二进制数据ArrayList
            for (ItemWithTimeAndScore item : items) {
                if (item.getClothType().equals(ClothType.Coat)) {
                    coatStringMap.put(item.getClothBinaryString(), item.getScore());
                } else if (item.getClothType().equals(ClothType.Dress)) {
                    dressStringMap.put(item.getClothBinaryString(), item.getScore());
                } else if (item.getClothType().equals(ClothType.Hdress)) {
                    hDressStringMap.put(item.getClothBinaryString(), item.getScore());
                } else if (item.getClothType().equals(ClothType.PANT)) {
                    pantStringMap.put(item.getClothBinaryString(), item.getScore());
                } else if (item.getClothType().equals(ClothType.Ucloth)) {
                    uClothStringMap.put(item.getClothBinaryString(), item.getScore());
                } else {
                    undefineStringMap.put(item.getClothBinaryString(), item.getScore());
                }
            }
            IGA iga = new IGA();
            List<String> coats = iga.recommend(coatStringMap);
            List<String> dress = iga.recommend(dressStringMap);
            List<String> hDress = iga.recommend(hDressStringMap);
            List<String> pants = iga.recommend(pantStringMap);
            List<String> uCloth = iga.recommend(uClothStringMap);
            //TODO
            //夏天不推荐外套
            //春秋推荐【Dress】或【HDress+Ucloth】或【UCloth+Pant】或【Coat+Pant】
            //TODO 4种方式随机选3种，每种方式上下衣各自随机选一件
            //TODO 对二进制衣服解码 输出关键词
        }
        //TODO 取出用户评分衣服的图片数据数组File[]与得分数据

//        for (ItemWithTimeAndScore item : user.getItems()) {
//            for (ClothingImage clothingImage : item.getClothingImages()) {
//                List<ClothingImageVote> clothingImageVotes =
//                        analyzeImageVote(clothingImage.getName());
//            }
//        }
        //TODO 造一下评分
//        float beta;
//        ClothType clothType;
//        Color color = getForgetEffect(items,beta,clothType);
//        Color another = FindSuitableColorForYou(Color color);
        //TODO 根据ClothType，组合出关键词
        //TODO 对Cloth解析输出最终关键词.
        return new HashMap<>();
    }

    private ItemWithTimeAndScore analyzeImageVote(String name) {
        //TODO for liker
        return null;
    }


    public static void main(String args[]) {

    }

    public void pushToUser(List<Item> items) {
        //TODO for liker
    }


    //TODO 只能使用一种ClothType的Items
    public Color getForgetEffect(List<ItemWithTimeAndScore> items,float beta,ClothType clothType){
        Color finalColor = new Color();
        //计算表一
        CalculateTable1 calculateTable1 = new CalculateTable1();
        PeopleFavorColorTable peopleFavorColorTable = calculateTable1.CalculateTable1();
        //TODO 找出评论时间最大差与评论时间小
        //TODO 按照公式计算一下
        //TODO 对所有已经计算的Color分数排序并得到最高的颜色A
        //根据Color与像素比例制作成表二，ChooseColorWhileFavorColorTable（）
        ChooseColorWhileFavorColorTable t2 = new ChooseColorWhileFavorColorTable();
//            t2.setChooseColor(A);
//            t2.getColorProbabilities().add(new ColorProbability(A,0,3f));
//            t2.getColorProbabilities().add(new ColorProbability(B,0,2f));
//            t2.getColorProbabilities().add(new ColorProbability(C,0,3f));
//            t2.getColorProbabilities().add(new ColorProbability(D,0,4f));
//            t2.getColorProbabilities().add(new ColorProbability(F,0,3f));
//        PeopleFavorColorTable t1 = new PeopleFavorColorTable();
//            t1.getColorProbabilities().add(new ColorProbability(A,0,3f));
//            t1.getColorProbabilities().add(new ColorProbability(A,0,3f));
//            t1.getColorProbabilities().add(new ColorProbability(A,0,3f));
//            t1.getColorProbabilities().add(new ColorProbability(A,0,3f));
//            t1.getColorProbabilities().add(new ColorProbability(A,0,3f));
        //TODO 计算表三
        ChooseColorWhileFavorColorTable t3 = new ChooseColorWhileFavorColorTable();
//            P(A) = P<t1>(A) * t2<favor=A>(A) + P<t1>(B) * P<favor=B>(A) + ~~~~~;
//            t3.getColorProbabilities().add(new ColorProbability(A,?))
        //TODO 根据表三 随机一个数（0-1）来抛出我们这次推荐的颜色
        return finalColor;

        //TODO t3数据替换t1存储存入数据库 for liker
    }
}
