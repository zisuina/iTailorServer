package recommendation.crystal.com.company;

/**
 * Created by crystal.liker on 2015/7/26.
 */
public class Dresses extends Clothes{
    private  String collar_type;
    private  String sleeve_type;
    private String style;
    private  String shape;
    private  String dress_length;
    Dresses()
    {
    }
    Dresses(String collar_type ,  String sleeve_type , String style ,  String shape ,  String dress_length)
    {
        this.collar_type=collar_type;
        this.sleeve_type=sleeve_type;
        this.style=style;
        this.shape=shape;
        this.dress_length=dress_length;
    }
    public String getCollar_type() {
        return collar_type;
    }

    public void setCollar_type(String collar_type) {
        this.collar_type = collar_type;
    }

    public String getSleeve_type() {
        return sleeve_type;
    }

    public void setSleeve_type(String sleeve_type) {
        this.sleeve_type = sleeve_type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getDress_length() {
        return dress_length;
    }

    public void setDress_length(String dress_length) {
        this.dress_length = dress_length;
    }




}
