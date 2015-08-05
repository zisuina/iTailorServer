package resource.util;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by liker on 08/07/2015 0008.
 * Group iTailor.hunters.neu.edu.cn
 */
public class testLog2 {
    public void show() {
        Logger logger = Logger.getLogger(testLog2.class);
//        ALL,TRACE,DEBUG,INFO,WARNING,ERROR,FITAL,OFF
        logger.trace("TRACE json.");
        logger.debug("DEBUG json.");
        logger.info("INFO json.");
        logger.warn("WARNING json.");
        logger.error("ERROR json.");
        logger.fatal("FATAL json");
        if(logger.isDebugEnabled()){
            logger.debug("DEBUG json when debug is enabled.");
        }
        if(logger.isEnabledFor(Level.ERROR)){
            logger.error("WARNING json when warn is enable");
        }
    }
}
