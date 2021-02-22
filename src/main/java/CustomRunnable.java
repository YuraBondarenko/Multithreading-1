public class CustomRunnable implements Runnable {
    private final Counter counter;

    public CustomRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.counter(Thread.currentThread().getName());
    }
}
