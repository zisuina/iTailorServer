package crystal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by crystal.liker on 2015/6/15.
 */
public class HumanData {
    public int Skin_red;
    public int Skin_green;
    public int Skin_bule;
    public int Hair_red;
    public int Hair_green;
    public int Hair_bule;
    public int chest;
    public int waist;
    public int hip;
    public int weight;
    public int height;
    public int face_shape;
    public String hair_color;
    public String[] colors = {"黑色", "象牙黑", "灰色", "冷灰", "石板灰", "暖灰色", "白色", "古董白", "天蓝色", "白烟", "白杏仁", "穗丝白", "蛋壳色", "花白", "浅灰", "苍白",
            "蜜露橙", "象牙白", "亚麻色", "海白色", "旧布黄", "海贝壳色", "雪白", "红色", "砖红", "镉红", "珊瑚色", "耐火砖色", "印度红", "栗色", "粉红",
            "草莓色", "橙红色", "番茄红", "桔红", "晶红色", "黄色", "香蕉色", "镉黄", "粉橙色", "粉金色", "金黄色", "黄花色", "瓜色", "橙色", "镉橙", "胡萝卜色",
            "桔黄", "淡黄色", "棕色", "米色", "锻浓黄土色", "锻棕土色", "巧克力色", "肉色", "黄褐色", "玫瑰红", "肖贡土色", "棕土色", "乌贼墨棕", "赫色",
            "马棕色", "沙棕色", "棕褐色", "蓝色", "钴色", "道奇蓝", "暗蓝", "锰蓝", "深蓝色", "孔雀蓝", "土耳其玉色", "浅灰蓝色", "品蓝", "石板蓝", "天蓝",
            "青色", "绿土", "靛青", "碧绿色", "青绿色", "绿色", "黄绿色", "钴绿色", "翠绿色", "森林绿", "草地绿", "酸橙绿", "薄荷色", "草绿色", "暗绿色",
            "海绿色", "嫩绿色", "紫色", "紫罗兰色", "浅紫色", "湖紫色", "淡紫色", "梅红色"};
    public int[][] info_color = {{0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {41, 36, 33, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0}, {192, 192, 192, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {128, 138, 135, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {112, 128, 105, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {128, 128, 105, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 255, 255, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {250, 235, 215, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {240, 255, 255, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {245, 245, 245, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {255, 235, 205, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 248, 220, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {252, 230, 201, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 250, 240, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {220, 220, 220, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {248, 248, 255, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {240, 255, 240, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {250, 255, 240, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {250, 240, 230, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {250, 222, 173, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {253, 245, 230, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 245, 238, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 250, 250, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {255, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {156, 102, 31, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {227, 23, 13, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {255, 127, 80, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {178, 34, 34, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {176, 23, 31, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {176, 48, 98, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {255, 192, 203, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {135, 38, 87, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {250, 128, 114, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 99, 71, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 69, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
            {255, 0, 255, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {255, 255, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {227, 207, 87, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {255, 153, 18, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {235, 142, 85, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {255, 227, 132, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 215, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {218, 165, 105, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1}, {227, 168, 105, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {255, 97, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {255, 97, 3, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1}, {237, 145, 33, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1}, {255, 128, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {245, 222, 179, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1}, {128, 42, 42, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {163, 148, 128, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0}, {138, 54, 15, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {135, 51, 36, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {210, 105, 30, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0}, {255, 125, 64, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {240, 230, 140, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {188, 143, 143, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {199, 97, 20, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {115, 74, 18, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {94, 38, 18, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0},
            {160, 82, 45, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {139, 69, 19, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {244, 164, 96, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {210, 180, 180, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 255, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {61, 89, 171, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, {30, 144, 255, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {11, 23, 70, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {3, 168, 158, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {25, 25, 122, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {51, 161, 201, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {0, 199, 140, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {176, 224, 230, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {65, 105, 225, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {106, 90, 205, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {135, 206, 235, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {0, 255, 255, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {56, 94, 15, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, {8, 46, 84, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {127, 255, 212, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
            {61, 224, 208, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 255, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {127, 255, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1}, {61, 145, 64, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 201, 87, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {34, 139, 34, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {124, 252, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {50, 205, 50, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {189, 252, 201, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1}, {107, 142, 35, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {48, 128, 20, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, {46, 139, 87, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 255, 127, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1}, {160, 32, 240, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {138, 43, 226, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
            {160, 102, 211, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {153, 51, 250, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {218, 112, 214, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {221, 160, 221, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    public HumanData(int Skin_red, int Skin_green, int Skin_bule) {
        if (Skin_red >= 0 && Skin_red <= 255) {
            if (Skin_green >= 0 && Skin_green <= 255) {
                if (Skin_bule >= 0 && Skin_bule <= 255) {
                    this.Skin_red = Skin_red;
                    this.Skin_green = Skin_green;
                    this.Skin_bule = Skin_bule;
                }
            }
        }
        throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");

    }

    public HumanData(int Skin_red, int Skin_green, int Skin_bule, int chest, int waist, int hip) {
        if (Skin_red >= 0 && Skin_red <= 255) {
            if (Skin_green >= 0 && Skin_green <= 255) {
                if (Skin_bule >= 0 && Skin_bule <= 255) {
                    if (chest > 0 && waist > 0 && hip > 0) {
                        this.Skin_bule = Skin_red;
                        this.Skin_green = Skin_green;
                        this.Skin_bule = Skin_bule;
                        this.chest = chest;
                        this.hip = hip;
                        this.waist = waist;
                    } else new IllegalArgumentException("Body info must be greater than 0");
                }
            }
        }
        throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");
    }

    public HumanData(int Skin_red, int Skin_green, int Skin_bule, int chest, int waist, int hip, int weight, int height) {
        if (Skin_red >= 0 && Skin_red <= 255) {
            if (Skin_green >= 0 && Skin_green <= 255) {
                if (Skin_bule >= 0 && Skin_bule <= 255) {
                    if (chest > 0 && waist > 0 && hip > 0) {
                        if (weight > 0 && height > 0)
                            this.Skin_bule = Skin_red;
                        this.Skin_green = Skin_green;
                        this.Skin_bule = Skin_bule;
                        this.chest = chest;
                        this.hip = hip;
                        this.waist = waist;
                        this.height = height;
                        this.weight = weight;
                    } else new IllegalArgumentException("Body info must be greater than 0");
                }
            }
        }
        throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");

    }

    public HumanData() {
    }
    /*
    @ rgb
    @ return String type clor of skin   4 kinds of skins
     */

    public int GetColor(String skin_color, double weight, double height, int age, String character)

    {
        String str = "";
        int suitable_num[] = new int[100];
        //get color skin
        if (skin_color.equals("偏白")) {
            str = str + "0011";
        }
        if (skin_color.equals("偏黄")) {
            str = str + "0100";
        }
        if (skin_color.equals("偏红")) {
            str = str + "0101";
        }
        if (skin_color.equals("偏黑")) {
            str = str + "0110";
        }
        //Caculate by weight and height;

        double BMI = 0;
        BMI = weight / (height * height);
        if (BMI < 18) {
            str = str + "0111";
        }
        if (BMI >= 18 && BMI <= 25) {
            str = str + "1000";
        }
        if (BMI > 25) {
            str = str + "1001";
        }
        //get age
        if (age >= 18 && age <= 40) {
            str = str + "1010";
        }
        if (age >= 41 && age <= 65) {
            str = str + "1011";
        }
        if (age >= 66) {
            str = str + "1100";
        }
        //Get the character  introverted // extroverted
        if (character.equals("内向")) {
            str = str + "1101";
        }
        if (character.equals("外向")) {
            str = str + "1110";
        }
        /*
        analyse the string
         */
        int color_num;
        int body_num;
        int gap_num;
        int character_num;
        color_num = Integer.parseInt(str.substring(0, 4), 2);
        body_num = Integer.parseInt(str.substring(4, 8), 2);
        gap_num = Integer.parseInt(str.substring(8, 12), 2);
        character_num = Integer.parseInt(str.substring(12, 16), 2);
        for (int i = 0; i < 99; i++) {
            if (info_color[i][color_num] == 1) {
                if (info_color[i][body_num] == 1) {
                    if (info_color[i][gap_num] == 1) {
                        if (info_color[i][character_num] == 1) {
                            suitable_num[i + 1] = 1;
                        }
                    }
                }
            }
        }
        ArrayList list = new ArrayList();
        for (int i = 0; i < 99; i++) {
            if (suitable_num[i + 1] != 0) {
                list.add(i + 1);
            }
        }
        int result = (int) (Math.random() * list.size());
        return (int) (list.get(result));
    }

    /*
       @ rgb
       A rgb transmit to hsl
       @ return hsl float3
        */
    public float[] rgb2hsb(int rgbR, int rgbG, int rgbB) {
        if (Skin_red < 0 && Skin_red > 255) {
            if (Skin_green < 0 && Skin_green > 255) {
                if (Skin_bule < 0 && Skin_bule > 255) {
                    throw new IllegalArgumentException("RGB value  must be greater than or equal to 0 and less than 255 or equal to 255");
                }
            }
        }
        assert 0 <= rgbR && rgbR <= 255;
        assert 0 <= rgbG && rgbG <= 255;
        assert 0 <= rgbB && rgbB <= 255;
        int[] rgb = new int[]{rgbR, rgbG, rgbB};
        Arrays.sort(rgb);
        int max = rgb[2];
        int min = rgb[0];
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
        hsb[0] = hsbH;
        hsb[1] = hsbS;
        hsb[2] = hsbB;
        return hsb;
    }

    /*
     Change all rgb  to hsl  99
     @ return hsl float[99][3]
      */
    public float[][] GetAllHSB() {
        HumanData test = new HumanData();
        float[][] hsb = new float[99][3];
        for (int i = 0; i < 99; i++) {
            hsb[i][0] = test.rgb2hsb(info_color[i][0], info_color[i][1], info_color[i][2])[0];
            hsb[i][1] = test.rgb2hsb(info_color[i][0], info_color[i][1], info_color[i][2])[1];
            hsb[i][2] = test.rgb2hsb(info_color[i][0], info_color[i][1], info_color[i][2])[2];
            // System.out.print( hsb[i][0]+" "+ hsb[i][1]+" "+ hsb[i][2]+"\n");
        }
        return hsb;

    }

    /*
   @ Input the first clor of cloth
    @ return suitable clor of next cloth
     */
    public String GetStuitableColor(int corlor_unm) {
        if (corlor_unm <= 0 && corlor_unm > 99) {
            throw new IllegalArgumentException("There are only 99 colors");
        }
        //
        int[] stuitable_color_num_h = new int[100];
        int[] stuitable_color_num_s = new int[100];
        int[] stuitable_color_num_b = new int[100];
        HumanData test = new HumanData();
        float[][] hsb_test = test.GetAllHSB();
        //       for(int i =0;i<99;i++) {
        //        System.out.print( hsb_test[i][0]+" ");
        //          System.out.print( hsb_test[i][1]+" ");
        //         System.out.print( hsb_test[i][2]+"\n");

        //    }
//ɫ����ɫ
        for (int i = 1; i < 100; i++) {
            if (hsb_test[corlor_unm - 1][0] <= 345 && hsb_test[corlor_unm - 1][0] >= 15) {
                if ((hsb_test[i - 1][0] < (hsb_test[corlor_unm - 1][0]) + 15) && ((hsb_test[i - 1][0]) > (hsb_test[corlor_unm - 1][0] - 15))) {
                    stuitable_color_num_h[i] = i;
                }
            } else if ((hsb_test[corlor_unm - 1][0] > 345 && hsb_test[corlor_unm - 1][0] <= 360) || (hsb_test[corlor_unm - 1][0] < 15 && hsb_test[corlor_unm - 1][0] >= 0)) {
                if ((hsb_test[i - 1][0] < 15 && hsb_test[i - 1][0] >= 0) || (hsb_test[i - 1][0] > 345 && hsb_test[i - 1][0] <= 360)) {
                    stuitable_color_num_h[i] = i;
                }
            }
        }
        ArrayList suit_num = new ArrayList();

        for (int i = 1; i < 100; i++) {
            if (stuitable_color_num_h[i] != 0)
                suit_num.add(i);
        }

        //���Ͷ���ɫ
        for (int i = 1; i < 100; i++) {
            if (hsb_test[corlor_unm - 1][1] <= 0.95 && hsb_test[corlor_unm - 1][1] >= 0.05) {
                if ((hsb_test[i - 1][1] < (hsb_test[corlor_unm - 1][1]) + 0.05) && ((hsb_test[i - 1][1]) > (hsb_test[corlor_unm - 1][1] - 0.05))) {
                    stuitable_color_num_b[i] = i;
                }
            } else if ((hsb_test[corlor_unm - 1][1] > 0.95 && hsb_test[corlor_unm - 1][1] <= 1) || (hsb_test[corlor_unm - 1][1] < 0.05 && hsb_test[corlor_unm - 1][1] >= 0)) {
                if ((hsb_test[i - 1][1] < 0.05 && hsb_test[i - 1][1] >= 0) || (hsb_test[i - 1][1] > 0.95 && hsb_test[i - 1][1] <= 1)) {
                    stuitable_color_num_b[i] = i;
                }
            }
        }

        for (int i = 1; i < 100; i++) {
            if (stuitable_color_num_b[i] != 0)
                suit_num.add(i);
        }

        //������ɫ
        for (int i = 1; i < 100; i++) {
            if (hsb_test[corlor_unm - 1][2] <= 0.95 && hsb_test[corlor_unm - 1][2] >= 0.05) {
                if ((hsb_test[i - 1][2] < (hsb_test[corlor_unm - 1][2]) + 0.05) && ((hsb_test[i - 1][2]) > (hsb_test[corlor_unm - 1][2] - 0.05))) {
                    stuitable_color_num_s[i] = i;
                }
            } else if ((hsb_test[corlor_unm - 1][2] > 0.95 && hsb_test[corlor_unm - 1][2] <= 1) || (hsb_test[corlor_unm - 1][2] < 0.05 && hsb_test[corlor_unm - 1][2] >= 0)) {
                if ((hsb_test[i - 1][2] < 0.05 && hsb_test[i - 1][2] >= 0) || (hsb_test[i - 1][2] > 0.95 && hsb_test[i - 1][2] <= 1)) {
                    stuitable_color_num_s[i] = i;
                }
            }
        }
        for (int i = 1; i < 100; i++) {
            if (stuitable_color_num_s[i] != 0)
                suit_num.add(i);
        }
        int result = (int) (Math.random() * suit_num.size());
        String str = colors[(int) suit_num.get(result) - 1];
        return str;
    }

    /*
  @ Input height and weight
  @ return clothSize like S M L XL XXL
   */
    public String GetClothSize(int weight, int height) {
        if (weight <= 0 && height <= 0) {
            throw new IllegalArgumentException("Body's info must be greater than 0");
        }
        String S = "S";
        String M = "M";
        String L = "L";
        String XL = "XL";
        String XXL = "XXL";
        if (height <= 175 && height > 155 && weight <= 100) {
            return S;
        }
        if ((height <= 175 && height > 155 && weight <= 140 && weight > 130)
                || (height <= 175 && height > 165 && weight <= 160 && weight > 140)) {
            return XXL;
        }
        if ((height <= 175 && height > 155 && weight <= 130 && weight > 120)) {
            return XL;
        }
        if ((height <= 175 && height > 165 && weight <= 110 && weight > 100)
                || (height <= 175 && height >= 155 && weight < 120 && weight > 110)) {
            return L;
        }
        if (height <= 165 && height > 155 && weight < 110 && weight > 100) {
            return M;
        } else
            return "Sorry";

    }

}
