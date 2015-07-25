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
        logger.trace("TRACE message.");
        logger.debug("DEBUG message.");
        logger.info("INFO message.");
        logger.warn("WARNING message.");
        logger.error("ERROR message.");
        logger.fatal("FATAL message");
        if(logger.isDebugEnabled()){
            logger.debug("DEBUG message when debug is enabled.");
        }
        if(logger.isEnabledFor(Level.ERROR)){
            logger.error("WARNING message when warn is enable");
        }
    }
}
