package log4j2.sample0;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest0 {
    public static void main(String[] args) {
        //Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME); // 默认logger
        Logger logger = LogManager.getLogger("mylog"); //自定义lagger
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }
}
