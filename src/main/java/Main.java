public class Main {
    public static void main(String[] args) {
        CustomThread thread = new CustomThread();
        Thread runnable = new Thread(new CustomRunnable());

        thread.start();
        runnable.start();
    }

    private static class CustomThread extends Thread {
        @Override
        public void run() {
            Counter.counter(getName());
        }
    }

    private static class CustomRunnable implements Runnable {
        @Override
        public void run() {
            Counter.counter(Thread.currentThread().getName());
        }
    }
}
