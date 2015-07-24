package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liker on 23/07/2015 0023.
 * Group iTailor.hunters.neu.edu.cn
 */
public class EmailVerification {
    public static boolean isValid(String email) {
        if (null == email || "".equals(email)) return false;
        String[] emailFormat = new String[]{
                "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*",
                "[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+",
                "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"
        };
        Pattern p = Pattern.compile(emailFormat[0]);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
