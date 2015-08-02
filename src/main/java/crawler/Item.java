package crawler;


import hibernate.recommendation.ClothingImage;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

/**
 * Created by liker on 21/07/2015 0021.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "items")
public class Item {
    private String itemId;
    private String itemName;
    private String keyName;
    private String shopName;
    private int saleQuantityInAMonth; //Ajax


    private ItemDescription itemDescription;
    private ArrayList<SkuItem> skuItems = new ArrayList<>();
    private ArrayList<ClothingImage> clothingImages = new ArrayList<>();

    @Override
    public String toString() {
        return "Shop_name:" + shopName + "\n" +
                "Item_id_on_tmall.com:" + itemId + "\n" +
                "Item_name:" + itemName + "\n" +
                "Search_Key_name:" + keyName + "\n" +
                "Sale_quantity_in_a_month:" + saleQuantityInAMonth + "\n" +
                "ItemDescription:" + itemDescription.toString() + "\n" +
                "SkuItems Size:" + skuItems.size();
    }

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public void maintain() {
        new ItemMaintainer(this).maintain();
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

    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(ItemDescription itemDescription) {
        this.itemDescription = itemDescription;
    }

    public ArrayList<SkuItem> getSkuItems() {
        return skuItems;
    }

    public void setSkuItems(ArrayList<SkuItem> skuItems) {
        this.skuItems = skuItems;
    }

    public static void main(String[] args) {
        Item item = new Item("44787408094");
        item.maintain();
        System.out.println(item.toString());
    }

    public ArrayList<ClothingImage> getClothingImages() {
        return clothingImages;
    }

    public void setClothingImages(ArrayList<ClothingImage> clothingImages) {
        this.clothingImages = clothingImages;
    }
}
