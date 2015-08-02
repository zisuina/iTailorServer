package hibernate.services;

import crawler.Item;
import crawler.TmallSearch;

import java.util.ArrayList;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class CrawlerService {
    private TmallSearch tmallSearch = new TmallSearch();

    public ArrayList<Item> onLineSearch(String searchKeys) {
        tmallSearch.search(searchKeys);
        return tmallSearch.getItems();
    }

    public ArrayList<Item> offLineSearch(String searchKeys){
        return null;
    }
}
