package hibernate.services;

import exception.HibernateFailException;
import hibernate.elements.Color;
import util.BaseDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 30/07/2015 0030.
 * Group iTailor.hunters.neu.edu.cn
 */
public class PickColorService {
    private List<Color> colors = new ArrayList<>();

    public PickColorService() {

    }

    HibernateServiceInterface hibernateService = (session) -> {
        session.createSQLQuery("delete from colors").executeUpdate();
        this.loadColorsFromFile(".\\src\\main\\resources\\colors.txt");
        System.out.println("SIZE:" + colors.size());
        colors.forEach((Color color) -> session.persist(color));
    };


    public void settleIntoDB() throws HibernateFailException {
        if (!this.hibernateService.doHibernate())
            throw new HibernateFailException();
    }

    public boolean loadColorsFromFile(String url) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(url), "UTF-8"));
            String str = null;
            while ((str = br.readLine()) != null) {
                String[] temp = str.split("\t", 5);
                Color color = new Color();
                color.setName_ch(temp[0]);
                color.setRed(Integer.parseInt(temp[1]));
                color.setGreen(Integer.parseInt(temp[2]));
                color.setBlue(Integer.parseInt(temp[3]));
                color.setName_en(temp[4]);
                colors.add(color);
            }
            br.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Color whichColorIsTheClosestFor(int red, int green, int blue) throws HibernateFailException {
        Color one = new Color(red, green, blue);
        colors = new BaseDAO<Color>().list("select c from Color as c");
        if (colors.isEmpty()) {
            this.settleIntoDB();
            colors = new BaseDAO<Color>().list("select c from Color as c");
        }
        Color temp = null;
        double record = 195075.0;
        double distance;
        for (Color color : colors) {
            distance = color.getColorDistance(one);
            if (distance <= record) {
                record = distance;
                temp = color;
            }
        }
        return temp;
    }
}
