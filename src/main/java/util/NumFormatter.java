package util;

/**
 * Created by liker on 08/08/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class NumFormatter {
    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }
}
