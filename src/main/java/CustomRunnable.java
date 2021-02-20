public class CustomRunnable implements Runnable {
    @Override
    public void run() {
        Counter.counter(Thread.currentThread().getName());
    }
}
