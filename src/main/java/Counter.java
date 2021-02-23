import org.apache.log4j.Logger;

public class Counter {
    private static final Logger logger = Logger.getLogger(Counter.class);
    private static final int MIN = 0;
    private static final int MAX = 100;
    private int counter = MIN;

    public void count(String threadName) {
        while (counter < MAX) {
            logger.info(threadName + " value = " + ++counter);
        }
    }
}
