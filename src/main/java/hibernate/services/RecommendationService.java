package hibernate.services;


import hibernate.recommendation.User;
import org.apache.log4j.Logger;
import recommendation.userSimilarity.Item;
import util.BaseDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class RecommendationService {
    private static Logger logger = Logger.getLogger(RecommendationService.class);

    public void applyForEveryUser() {
        List<User> users = new BaseDAO<User>().list("select u from User as u");
        users.forEach((User user) -> {
            ArrayList<Item> items = perfectlyCalculate(user);
//            tobe.setItemRecommendedToday(items.size() < 4 ? items : items.subList(0, 2));
            logger.debug("Reset OR Init RecommendationService For USER:" + user.getUser() + "?" + user.getNickname());
            new BaseDAO<User>().update(user);
        });
    }

    public ArrayList<Item> perfectlyCalculate(User user) {
        CrawlerService crawlerService = new CrawlerService();
        do {
            String keywords = resource.service.RecommendationService.makeRecommendation(user);
            crawlerService.onLineSearch(keywords);
        } while (crawlerService.getItems().isEmpty());
        logger.debug("RecommendationService Calculation for USER:" + user.getUser() + "?" + user.getNickname());
        return crawlerService.getItems();
    }


}
