package MyWebMagic;

/**
 * Created by liker on 22/07/2015 0022.
 * Group iTailor.hunters.neu.edu.cn
 */
public class SkuItem {
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
}
