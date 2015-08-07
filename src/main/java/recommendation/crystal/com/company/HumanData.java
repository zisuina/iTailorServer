package recommendation.crystal.com.company;

/**
 * Created by crystal.liker on 2015/6/15.
 */
public class HumanData {
    private int Skin_red;
    private int Skin_green;
    private int Skin_bule;
    private int chest;
    private int waist;
    private int hip;
    private int weight ;
    private int height;
    private int face_shape;
    private String body_type;
    private String skin_color;
    private String hair_color;
    private String personality;

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public int getSinTimes() {
        return sinTimes;
    }

    public void setSinTimes(int sinTimes) {
        this.sinTimes = sinTimes;
    }

    public int sinTimes;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int age;
    public int getSkin_red() {
        return Skin_red;
    }

    public void setSkin_red(int skin_red) {
        Skin_red = skin_red;
    }

    public int getSkin_green() {
        return Skin_green;
    }

    public void setSkin_green(int skin_green) {
        Skin_green = skin_green;
    }

    public int getSkin_bule() {
        return Skin_bule;
    }

    public void setSkin_bule(int skin_bule) {
        Skin_bule = skin_bule;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHip() {
        return hip;
    }

    public void setHip(int hip) {
        this.hip = hip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFace_shape() {
        return face_shape;
    }

    public void setFace_shape(int face_shape) {
        this.face_shape = face_shape;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public HumanData (int Skin_red,int Skin_green,int Skin_bule)
    {
        if(Skin_red>=0&&Skin_red<=255)
        {
            if(Skin_green>=0&&Skin_green<=255)
            {
                if(Skin_bule>=0&&Skin_bule<=255)
                {
                    this.Skin_red = Skin_red ;
                    this.Skin_green = Skin_green ;
                    this.Skin_bule = Skin_bule  ;
                }
            }
        } throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");

    }
    public HumanData(int Skin_red,int Skin_green,int Skin_bule,int chest,int waist,int hip)
    {
        if(Skin_red>=0&&Skin_red<=255)
        {
            if(Skin_green>=0&&Skin_green<=255)
            {
                if(Skin_bule>=0&&Skin_bule<=255)
                {
                    if(chest>0 && waist>0 &&  hip>0)
                    {
                        this.Skin_bule = Skin_red ;
                        this.Skin_green = Skin_green ;
                        this.Skin_bule = Skin_bule  ;
                        this.chest = chest;
                        this.hip = hip;
                        this.waist = waist;
                    }
                    else  new IllegalArgumentException("Body info must be greater than 0");
                }
            }
        } throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");
    }
    public HumanData(int Skin_red,int Skin_green,int Skin_bule,int chest,int waist,int hip,int weight ,int height)
    {
        if(Skin_red>=0&&Skin_red<=255)
        {
            if(Skin_green>=0&&Skin_green<=255)
            {
                if(Skin_bule>=0&&Skin_bule<=255)
                {
                    if(chest>0 && waist>0 &&  hip>0)
                    {
                        if(weight>0 && height>0 )
                        this.Skin_bule = Skin_red ;
                        this.Skin_green = Skin_green ;
                        this.Skin_bule = Skin_bule  ;
                        this.chest = chest;
                        this.hip = hip;
                        this.waist = waist;
                        this.height = height;
                        this.weight = weight;
                    }
                    else  new IllegalArgumentException("Body info must be greater than 0");
                }
            }
        } throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");

    }
    public HumanData() {
    }
    public Cloth SayNice(Cloth cloth)
    {
        int t =cloth.getTimes();
        cloth.times=t+1;
        return cloth;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public Cloth MarkCloth(Cloth cloth,int score)
    {
       cloth.score=score;
        return cloth;
    }
    public String toString() {
        return  this.getAge() + " " + this.getFace_shape() + " " + this.getHair_color()+ " " +
                this.getPersonality()+ " " + this.getBody_type();
    }
}
