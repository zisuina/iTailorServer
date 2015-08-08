//package hibernate.elements;
//
//import javax.persistence.*;
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by liker on 24/07/2015 0024.
// * Group iTailor.hunters.neu.edu.cn
// */
//@Entity
//@Table(name = "colors")
//public class Colors {
//    private int id;
//    private Set<Color> colors;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int getId() {
//        return id;
//
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumns(value = {@JoinColumn(name = "color_id")})
//    public Set<Color> getColors() {
//        return colors;
//    }
//
//    public void setColors(Set<Color> colors) {
//        this.colors = colors;
//    }
//
//    public Colors() {
//        colors = new HashSet<>();
//    }
//
//    public boolean loadColorsFromFile(String url) {
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(url), "UTF-8"));
//            String str = null;
//            while ((str = br.readLine()) != null) {
//                String[] temp = str.split("\t", 5);
//                Color color = new Color();
//                color.setName_ch(temp[0]);
//                color.setRed(Integer.parseInt(temp[1]));
//                color.setGreen(Integer.parseInt(temp[2]));
//                color.setBlue(Integer.parseInt(temp[3]));
//                color.setName_en(temp[4]);
//                colors.add(color);
//            }
//            br.close();
//            System.out.println(colors.size());
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
