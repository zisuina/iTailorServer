package recommendation.userSimilarity;

import recommendation.User;
import recommendation.userSimilarity.util.CalculateUserDataSimilarity;
import recommendation.userSimilarity.util.CalculateUserRecordSimilarity;

/**
 * Created by liker on 09/08/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class CalculateSimilarity {
    //相似度由两部分组成，一是用户的基础信息，二是用户的收藏浏览信息。
    final static float BodyData_coefficient = 0.57f;
    final static float UserRecording_coefficient = 1 - BodyData_coefficient;

    public static float GetFinalSimilarity(User user1, User user2) {
        float final_similarity = 0f;
        CalculateUserRecordSimilarity calculateUserRecordSimilarity = new CalculateUserRecordSimilarity();
        CalculateUserDataSimilarity calculateUserDataSimilarity = new CalculateUserDataSimilarity();
        final_similarity = calculateUserRecordSimilarity.UserRecordSimilarity(user1.getViewRecord(), user2.getViewRecord())
                + calculateUserDataSimilarity.CalculateAllValueSimilarity(user1, user2);
        return final_similarity;
    }

    public static User getMostSimilarityUser(User user, Users users) {
        //TODO 获取相似度最高的用户
        if (users.getUsers().isEmpty()) {
            return null;
        }
        float a = 0f;
        User res = user;
        for (User one : users.getUsers()) {
            float b = GetFinalSimilarity(user, one);
            if (a <= b) {
                a = b;
                res = one;
            }
        }
        return res;
    }

}
