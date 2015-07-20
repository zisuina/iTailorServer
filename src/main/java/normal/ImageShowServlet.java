package normal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by liker on 28/06/2015 0028.
 * Group iTailor.hunters.neu.edu.cn
 */
public class ImageShowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        resp.setContentType("image/jpeg");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
//        File file = new File(".\\images\\Linus.jpg");
        File file = new File(".\\src\\main\\webapp\\images\\123.jpg");
        FileInputStream fips = new FileInputStream(file);
        byte[] btImg = readStream(fips);
        os.write(btImg);
        os.flush();
    }

    public byte[] readStream(InputStream inStream) {
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        try {
            while((data = inStream.read()) != -1){
                bops.write(data);
            }
            return bops.toByteArray();
        }catch(Exception e){
            return null;
        }
    }
}
