package entity;

import java.util.List;
import java.util.Map;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class WatchList {
    private int userID;
    private int watchID;
    private List<WatchList> subWatchIDs;
    private Map<Account,Boolean> membersAuthorityMap;

}
