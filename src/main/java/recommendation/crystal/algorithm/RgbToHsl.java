package recommendation.crystal.algorithm;


import recommendation.crystal.com.company.HumanData;
import recommendation.crystal.information.GetColor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by crystal.liker on 2015/7/27.
 */
public class RgbToHsl {
    GetColor getcolor = new GetColor();
    ColorPossibility colorPossibility = new ColorPossibility();
    ArrayList slectionclorformatch = colorPossibility.GetSlectionColor2();
    float[][] info_color=getcolor.GetColorRGB(slectionclorformatch);
    public  float[] rgb2hsb(float rgbR, float rgbG, float rgbB) {
        HumanData human = new HumanData();
        if(human.getSkin_red()<0&&human.getSkin_red()>255)
        {
            if(human.getSkin_green()<0&&human.getSkin_green()>255)
            {
                if(human.getSkin_bule()<0&&human.getSkin_bule()>255)
                {
                    throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");
                }
            }
        }
        assert 0 <= rgbR && rgbR <= 255;
        assert 0 <= rgbG && rgbG <= 255;
        assert 0 <= rgbB && rgbB <= 255;
        float[] rgb = new float[] { rgbR, rgbG, rgbB };
        Arrays.sort(rgb);
        float max = rgb[2];
        float min = rgb[0];
        float hsbB = max / 255.0f;
        float hsbS = max == 0 ? 0 : (max - min) / (float) max;

        float hsbH = 0;
        if (max == rgbR && rgbG >= rgbB) {
            hsbH = (rgbG - rgbB) * 60f / (max - min) + 0;
        } else if (max == rgbR && rgbG < rgbB) {
            hsbH = (rgbG - rgbB) * 60f / (max - min) + 360;
        } else if (max == rgbG) {
            hsbH = (rgbB - rgbR) * 60f / (max - min) + 120;
        } else if (max == rgbB) {
            hsbH = (rgbR - rgbG) * 60f / (max - min) + 240;
        }

        float[] hsb = new float[3];
        hsb[0]= hsbH;
        hsb[1]= hsbS;
        hsb[2]= hsbB;
        return hsb;
    }
    /**
     Change all rgb  to hsl  99
     @ return hsl float[99][3]
     */
    public float[][]  GetAllHSB(float[][] info_color)
    {
        float[][] hsb = new float[99][3];
        for(int i=0;i<info_color.length;i++)
        {
            hsb[i][0]=rgb2hsb(info_color[i][0], info_color[i][1], info_color[i][2])[0];
            hsb[i][1]=rgb2hsb(info_color[i][0], info_color[i][1], info_color[i][2])[1];
            hsb[i][2]=rgb2hsb(info_color[i][0], info_color[i][1], info_color[i][2])[2];
        }
        return  hsb;

    }
}
