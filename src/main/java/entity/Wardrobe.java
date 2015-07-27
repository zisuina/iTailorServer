package entity;

import crawler.Item;

import java.util.List;

/**
 * Created by liker on 27/07/2015 0027.
 * Group iTailor.hunters.neu.edu.cn
 */
public class Wardrobe {
    private int userID;
    private String name;
    private int wardrobeID;
    private int subWardrobeID;
    private boolean isOpen;
    private List<Item> items;
}
