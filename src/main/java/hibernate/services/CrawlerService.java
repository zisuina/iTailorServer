package hibernate.services;


import crawler.TmallSearch;
import recommendation.userSimilarity.Item;
import java.util.ArrayList;

/**
 * Created by liker on 02/08/2015 0002.
 * Group iTailor.hunters.neu.edu.cn
 */
public class CrawlerService {
    private TmallSearch tmallSearch = new TmallSearch();
    private ArrayList<Item> items = new ArrayList<>();
    public void onLineSearch(String searchKeys) {
        tmallSearch.search(searchKeys);
      //TODO  items = tmallSearch.getItems();
    }

    public void filtrationAfterSearch(){
        //TO DO
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
