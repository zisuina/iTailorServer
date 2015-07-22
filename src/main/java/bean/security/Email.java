package bean.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liker on 29/06/2015 0029.
 * Tag iTailor.hunters.neu.edu.cn
 */
public class Email {
    private String email;
    private boolean valid;

    public Email() {
        this.email = "";
        this.valid = false;
    }

    public Email(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(this.isEmail(email)){
            this.email = email;
        }
    }

    public boolean isValid() {
        return this.isEmail(this.email);
    }

    private boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        //private final static Pattern emailer = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
