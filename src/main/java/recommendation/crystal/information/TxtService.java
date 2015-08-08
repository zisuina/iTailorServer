package recommendation.crystal.information;

import costume.*;
import enums.MyPathManager;
import hibernate.elements.Color;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import util.hibernate.HibernateSessionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liker on 07/08/2015 0007.
 * Group iTailor.hunters.neu.edu.cn
 */
public class TxtService {
    private static Logger logger = Logger.getLogger(TxtService.class);

    public boolean settleColorsIntoDB() {
        try {
            ArrayList<Color> colors = new ArrayList<>();
            File file = new File(MyPathManager.colorsPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] data = lineTxt.split(" ", 7);
//                    黑色 0 0 0 Black 1253.26 1253260
                    colors.add(new Color(data[0], data[4], Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]), data[6], data[5]));
                }
                read.close();

                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                try {
                    session.beginTransaction();
                    session.createSQLQuery("ALTER TABLE colors AUTO_INCREMENT = 1;").executeUpdate();
                    colors.forEach(session::persist);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
                logger.debug("[FILE 99.txt] settles into database successfully.");
                return true;
            } else {
                logger.debug("[FILE 99.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE 99.txt] ERROR");
//            e.printStackTrace();
        }
        return false;
    }

    public boolean settleDressesIntoDB() {
        try {
            ArrayList<Dress> dresses = new ArrayList<>();
            File file = new File(MyPathManager.dressPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] data = lineTxt.split(";", 5);
//                   圆领 直袖 瑞丽 蛋糕裙 超短裙
                    dresses.add(new Dress(data[0], data[1], data[2], data[3], data[4]));

                }
                read.close();
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                try {
                    session.beginTransaction();
                    session.createQuery("delete from Dress").executeUpdate();
                    session.createSQLQuery("ALTER TABLE dresses AUTO_INCREMENT = 1;").executeUpdate();
                    dresses.forEach(session::persist);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
                logger.debug("[FILE Dress.txt] settles into database successfully.");
                return true;
            } else {
                logger.debug("[FILE Dress.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE Dress.txt] ERROR");
            e.printStackTrace();
        }
        return false;
    }


    public boolean settleBDressesIntoDB() {
        try {
            ArrayList<HDress> dresses = new ArrayList<>();
            File file = new File(MyPathManager.B_DressPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] data = lineTxt.split(";", 4);
//                 瑞丽;蛋糕裙;超短裙;高腰
                    dresses.add(new HDress(data[3], data[0], data[1], data[2]));

                }
                read.close();
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                try {
                    session.beginTransaction();
                    session.createQuery("delete from HDress").executeUpdate();
                    session.createSQLQuery("ALTER TABLE half_body_dresses AUTO_INCREMENT = 1;").executeUpdate();
                    dresses.forEach(session::persist);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
                logger.debug("[FILE B-Dress.txt] settles into database successfully.");
                return true;
            } else {
                logger.debug("[FILE B-Dress.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE B-Dress.txt] ERROR");
            e.printStackTrace();
        }
        return false;
    }


    public boolean settleCoatsIntoDB() {
        try {
            ArrayList<Coat> coats = new ArrayList<>();
            File file = new File(MyPathManager.coatPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] data = lineTxt.split(";", 6);
//                泡泡袖;长款;薄款;V领;双排扣;嬉皮
                    coats.add(new Coat(data[0], data[1], data[2], data[3], data[4], data[5]));
                }
                read.close();
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                try {
                    session.beginTransaction();
                    session.createQuery("delete from Coat").executeUpdate();
                    session.createSQLQuery("ALTER TABLE coats AUTO_INCREMENT = 1;").executeUpdate();
                    coats.forEach(session::persist);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
                logger.debug("[FILE Coat.txt] settles into database successfully.");
                return true;
            } else {
                logger.debug("[FILE Coat.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE Coat.txt] ERROR");
            e.printStackTrace();
        }
        return false;
    }


    public boolean settlePantsIntoDB() {
        try {
            ArrayList<Pant> pants = new ArrayList<>();
            File file = new File(MyPathManager.pantPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] data = lineTxt.split(";", 5);
//                泡泡袖;长款;薄款;V领;双排扣;嬉皮
                    pants.add(new Pant(data[0], data[1], data[2], data[3], data[4]));
                }
                read.close();
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                try {
                    session.beginTransaction();
                    session.createQuery("delete from Pant ").executeUpdate();
                    session.createSQLQuery("ALTER TABLE pants AUTO_INCREMENT = 1;").executeUpdate();
                    pants.forEach(session::persist);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
                logger.debug("[FILE Pants.txt] settles into database successfully.");
                return true;
            } else {
                logger.debug("[FILE Pants.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE Pants.txt] ERROR");
            e.printStackTrace();
        }
        return false;
    }


    public boolean settleUClothIntoDB() {
        try {
            ArrayList<UCloth> uCloths = new ArrayList<>();
            File file = new File(MyPathManager.uClothPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    String[] data = lineTxt.split(";", 5);
//                泡泡袖;长款;薄款;V领;双排扣;嬉皮
                    uCloths.add(new UCloth(data[0], data[1], data[2], data[3], data[4]));
                }
                read.close();
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                try {
                    session.beginTransaction();
                    session.createQuery("delete from UCloth ").executeUpdate();
                    session.createSQLQuery("ALTER TABLE uCloths AUTO_INCREMENT = 1;").executeUpdate();
                    uCloths.forEach(session::persist);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
                logger.debug("[FILE U-Cloth.txt] settles into database successfully.");
                return true;
            } else {
                logger.debug("[FILE U-Cloth.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE U-Cloth.txt] ERROR");
            e.printStackTrace();
        }
        return false;
    }

    public boolean settleColorPrefixIntoDB() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            List<Color> colors = session.createQuery("select c from Color as c").list();
            File file = new File(MyPathManager.colorPrefixPath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                for (Color color : colors) {
                    if ((lineTxt = bufferedReader.readLine()) != null) {
                        String[] data2 = lineTxt.split(",", 12);
                        boolean[] data = new boolean[12];
                        System.out.println(data2.length);
                        for (int i = 0; i < 12; i++) {
                            if (data2[i].equals("1")) {
                                data[i] = true;
                            } else {
                                data[i] = false;
                            }
                        }
                        color.setPrefixColor(data[0], data[1], data[2], data[3], data[4], data[5],
                                data[6], data[7], data[8], data[9], data[10], data[11]
                        );
                    }
                }
                logger.debug("[FILE color-prefix.txt] settles into database successfully.");
                read.close();
                session.getTransaction().commit();
                return true;
            } else {
                logger.debug("[FILE color-prefix.txt] 404 NOT FOUND!");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            logger.debug("READ [FILE color-prefix.txt] ERROR");
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

}
