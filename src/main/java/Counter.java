public class Counter {
    private static int i = 0;

    public static void counter(String threadName) {
        for (; i < 100; i++) {
            System.out.println(threadName + " value = " + i);
        }
    }
}
