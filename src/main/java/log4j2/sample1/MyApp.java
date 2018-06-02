package log4j2.sample1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyApp {
    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public static void main(String[] args) {
        logger.trace("Entering application");
        Bar bar = new Bar();
        if(!bar.doIt()){
            logger.error("Don't do it");
        }
        logger.trace("Exting appication");
    }
}
