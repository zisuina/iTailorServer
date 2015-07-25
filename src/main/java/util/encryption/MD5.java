package util.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
public final class MD5 {
    public static String getMD5(String str) {
        String reStr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte ss[] = md.digest();
            reStr = bytes2String(ss);
        } catch (NoSuchAlgorithmException e) {

        }
        return reStr;
    }

    private static String bytes2String(byte[] aa) {
        String hash = "";
        for (int i = 0; i < aa.length; i++) {
            int temp;
            temp = aa[i] < 0 ? (aa[i] + 256) : aa[i];
            if (temp < 16)
                hash += "0";
            hash += Integer.toString(temp, 16);
        }
        hash = hash.toUpperCase();
        return hash;
    }
}