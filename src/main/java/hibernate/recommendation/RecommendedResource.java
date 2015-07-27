package hibernate.recommendation;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class RecommendedResource extends Resource {
    private int userID;
    private boolean isTwoAsOne;
    private int clothID;
    private int pantsID;
    private String recommendReason;
    private float matchingRatio;
}
