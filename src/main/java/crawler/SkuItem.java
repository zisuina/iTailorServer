package crawler;

import javax.persistence.*;

/**
 * Created by liker on 22/07/2015 0022.
 * Group iTailor.hunters.neu.edu.cn
 */
@Entity
@Table(name = "skuItems")
public class SkuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountID;
    private String skuid;
    private String size;
    private String color;
    private int stock;
    private int saleQuantity;
    private float price;

    public SkuItem(String skuid, String size, String color, int stock, int saleQuantity, float price) {
        this.skuid = skuid;
        this.size = size;
        this.color = color;
        this.stock = stock;
        this.saleQuantity = saleQuantity;
        this.price = price;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
