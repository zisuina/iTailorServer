package util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by liker on 13/07/2015 0013.
 * Group iTailor.hunters.neu.edu.cn
 */
public class FetchWorld {
    public static String fetchHtml(String urlString) {
        try {
            java.net.URL url = new java.net.URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream());
            java.io.BufferedReader br = new java.io.BufferedReader(isr);

            String temp;
            StringBuffer html = new StringBuffer();
            while ((temp = br.readLine()) != null) {
                if (!temp.trim().equals("")) {
                    html.append(temp).append("\n");
                }
            }
            br.close();
            isr.close();
            return html.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("./fetch.html");
        fw.write(new FetchWorld().fetchHtml("http://www.oschina.net/"));
    }
}
