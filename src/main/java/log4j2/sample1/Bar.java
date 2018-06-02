package log4j2.sample1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bar {
    static final Logger logger = LogManager.getLogger(Bar.class.getName());
    public boolean doIt(){
        logger.entry();
        logger.error("Do it again");
        return logger.exit(false);
    }
}
