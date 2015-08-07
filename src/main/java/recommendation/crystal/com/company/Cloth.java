package recommendation.crystal.com.company;

/**
 * Created by crystal.liker on 2015/7/26.
 */
public class Cloth {
    double price;
    String name;
    String style;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    int times;
    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String color;
    public Cloth()
    {}
    public Cloth(String name,double price)
    {
        this.name=name;
        this.price=price;
    }
    public Cloth(String name,double price,String style)
    {
        this.name=name;
        this.price=price;
        this.style=style;
    }
    public Cloth(String name,double price,String style,String color,int score)
    {
        this.name=name;
        this.price=price;
        this.style=style;
        this.color=color;
        this.score= score;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setType(String style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean equals(Object other) {
        if(other instanceof Cloth) {
            Cloth otherCloth = (Cloth)other;
            return this.getName().equals(otherCloth.getName()) && this.getPrice() == otherCloth.getPrice()&&
                    this.getStyle().equals(otherCloth.getStyle());
        } else {
            return false;
        }
    }
}
