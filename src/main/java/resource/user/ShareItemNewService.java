package resource.user;

import hibernate.community.ShareItem;
import org.apache.log4j.Logger;
import util.BaseDAO;

import java.util.List;

/**
 * Created by liker on 04/08/2015 0004.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ShareItemNewService {
    private static Logger logger = Logger.getLogger(AccountNewService.class);
    private static List<ShareItem> shareItems = new BaseDAO<ShareItem>().list("select a from ShareItem as a");

    public ShareItem getShareItemByID(int shareItemID) {
        for (ShareItem shareItem : shareItems) {
            if (shareItem.getShareItemID() == shareItemID) {
                return shareItem;
            }
        }
        return null;
    }
}
