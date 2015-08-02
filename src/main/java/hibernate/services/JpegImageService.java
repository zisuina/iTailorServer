package hibernate.services;

import hibernate.recommendation.ClothingImage;
import org.apache.log4j.Logger;
import util.BaseDAO;

import java.util.List;

/**
 * Created by liker on 01/08/2015 0001.
 * Group iTailor.hunters.neu.edu.cn
 */
public class JpegImageService {
    private static Logger logger = Logger.getLogger(JpegImageService.class);
    private static List<ClothingImage> accountArrayList = new BaseDAO<ClothingImage>().list("select a from ClothingImage as a");



}
