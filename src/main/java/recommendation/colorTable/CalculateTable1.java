package recommendation.colorTable;

import hibernate.elements.Color;
import recommendation.TxtService;
import util.BaseDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crystal.liker on 2015/8/29.
 */
public class CalculateTable1 {
    public PeopleFavorColorTable CalculateTable1() {

        List<Color> colors = new BaseDAO<Color>().list("select from Color");
        float[] sales = StringToInt(colors);
        float[] possibility = new float[colors.size()];
        float Sum = 0f;
        for (int i = 0; i < colors.size(); i++) {
            Sum += sales[i];
        }
        List<ColorProbability> allColorProbability = new ArrayList<>();
        for (int i = 0; i < colors.size(); i++) {
            ColorProbability colorprobability = new ColorProbability();
            colorprobability.setColor(colors.get(i));
            possibility[i] = sales[i] / Sum;
            colorprobability.setProbability(possibility[i]);
            allColorProbability.add(colorprobability);

        }
        PeopleFavorColorTable peopleFavorColorTable = new PeopleFavorColorTable(allColorProbability);
        return peopleFavorColorTable;
    }

    public float[] CalculateTableArray() {
//        new TxtService().settleColorsIntoDB();
        List<Color> colors = new BaseDAO<Color>().list("select c from Color as c");
        System.out.println("SIZE:" + colors.size());
        float[] sales = StringToInt(colors);
        float[] possibility = new float[colors.size()];
        float Sum = 0f;
        for (int i = 0; i < colors.size(); i++) {
            Sum += sales[i];
        }
        List<ColorProbability> allColorProbability = new ArrayList<>();
        for (int i = 0; i < colors.size(); i++) {
            ColorProbability colorprobability = new ColorProbability();
            colorprobability.setColor(colors.get(i));
            possibility[i] = sales[i] / Sum;
        }

        return possibility;
    }



    ArrayList<String> allnames = new ArrayList();

    public ArrayList<String> GetNamesArray() {

        List<Color> colors = new BaseDAO<Color>().list("select c from Color as c");
        float[] sales = StringToInt(colors);
        float[] possibility = new float[colors.size()];
        float Sum = 0f;
        for (int i = 0; i < colors.size(); i++) {
            allnames.add(colors.get(i).getName_ch());
            //System.out.println("allnames: "+allnames.get(i));
        }

        return allnames;
    }

    public static void main(String args[]) {
        CalculateTable1 calculateTable1 = new CalculateTable1();
        List<Color> colors = new BaseDAO<Color>().list("select c from Color as c");
        calculateTable1.StringToInt(colors);

    }

    public float[] StringToInt(List<Color> colors) {
        float[] sales = new float[colors.size()];
        for (int i = 0; i < colors.size(); i++) {
            sales[i] = Integer.valueOf(colors.get(i).getQuantityInTmall());
        }
        return sales;
    }

    public ArrayList readColor(String rgb) {
        List<Color> colors = new BaseDAO<Color>().list("select c from Color as c");
        ArrayList oneofrgb = new ArrayList();
        if (rgb.equalsIgnoreCase("r")) {
            for (int i = 0; i < colors.size(); i++) {
                oneofrgb.add(colors.get(i).getRed());
              //  System.out.println(i+" r: "+oneofrgb.get(i));
            }
        } else if (rgb.equalsIgnoreCase("g")) {
            for (int i = 0; i < colors.size(); i++) {
                oneofrgb.add(colors.get(i).getGreen());
              //  System.out.println(i+" g: "+oneofrgb.get(i));
            }
        } else if (rgb.equalsIgnoreCase("b")) {
            for (int i = 0; i < colors.size(); i++) {
                oneofrgb.add(colors.get(i).getBlue());
               // System.out.println(i+" b: "+oneofrgb.get(i));
            }
        }
        return oneofrgb;
    }

    public ArrayList readColorHSL(String hsb) {
        List<Color> colors = new BaseDAO<Color>().list("select c from Color as c");
        ArrayList oneofhsl = new ArrayList();
        if (hsb.equalsIgnoreCase("h")) {
            for (int i = 0; i < colors.size(); i++) {
                oneofhsl.add(colors.get(i).getHue());
               // System.out.println(i+" h: "+oneofhsl.get(i));
            }
        } else if (hsb.equalsIgnoreCase("s")) {
            for (int i = 0; i < colors.size(); i++) {
                oneofhsl.add(colors.get(i).getSaturation());
               // System.out.println(i+" s: "+oneofhsl.get(i));
            }
        } else if (hsb.equalsIgnoreCase("b")) {
            for (int i = 0; i < colors.size(); i++) {
                oneofhsl.add(colors.get(i).getBrightness());
              //  System.out.println(i+" b: "+oneofhsl.get(i));
            }
        }
        return oneofhsl;
    }

}
