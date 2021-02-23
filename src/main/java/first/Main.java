package first;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        CustomThread thread = new CustomThread(counter);
        Thread runnable = new Thread(new CustomRunnable(counter));

        thread.start();
        runnable.start();
    }
}
