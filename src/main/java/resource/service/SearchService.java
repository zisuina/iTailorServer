package resource.service;

import crawler.TmallSearch;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
public class SearchService {
     public void search(String keywords){
         TmallSearch tmallSearch = new TmallSearch();
         if(tmallSearch.search(keywords)){
             System.out.println("here you are ~~");
         }
     }

    public static void main(String[] args) {
        SearchService searchService = new SearchService();
        searchService.search("公主裙");
    }

}
