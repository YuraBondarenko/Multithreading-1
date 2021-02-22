public class Counter {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private int counter = MIN;

    public void counter(String threadName) {
        for (; counter < MAX; counter++) {
            System.out.println(threadName + " value = " + counter);
        }
    }
}
