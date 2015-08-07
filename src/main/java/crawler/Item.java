package crawler;


import hibernate.recommendation.ClothingImage;
import util.BaseDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 21/07/2015 0021.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemServerID;

    private String itemId;
    private String itemName;
    private String keyName;
    private String shopName;
    private int saleQuantityInAMonth; //Ajax

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemServerID_FK")
    private List<Property> properties = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemServerID_FK")
    private List<SkuItem> skuItems = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "itemServerID_FK")
    private List<ClothingImage> clothingImages = new ArrayList<>();

    public Item() {
    }

    @Override
    public String toString() {
        return "Shop_name:" + shopName + "\n" +
                "Item_id_on_tmall.com:" + itemId + "\n" +
                "Item_name:" + itemName + "\n" +
                "Search_Key_name:" + keyName + "\n" +
                "Sale_quantity_in_a_month:" + saleQuantityInAMonth + "\n" +
                "ItemDescription:" + properties.toString() + "\n" +
                "SkuItems Size:" + skuItems.size();
    }

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public void maintain() {
        new ItemMaintainer(this).maintain();
        new BaseDAO<Item>().create(this);
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getSaleQuantityInAMonth() {
        return saleQuantityInAMonth;
    }

    public void setSaleQuantityInAMonth(int saleQuantityInAMonth) {
        this.saleQuantityInAMonth = saleQuantityInAMonth;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<SkuItem> getSkuItems() {
        return skuItems;
    }

    public void setSkuItems(List<SkuItem> skuItems) {
        this.skuItems = skuItems;
    }

    public void setClothingImages(List<ClothingImage> clothingImages) {
        this.clothingImages = clothingImages;
    }

    public void setSkuItems(ArrayList<SkuItem> skuItems) {
        this.skuItems = skuItems;
    }

    public List<ClothingImage> getClothingImages() {
        return clothingImages;
    }

    public void setClothingImages(ArrayList<ClothingImage> clothingImages) {
        this.clothingImages = clothingImages;
    }

    public int getItemServerID() {
        return itemServerID;
    }

    public void setItemServerID(int itemServerID) {
        this.itemServerID = itemServerID;
    }
}
