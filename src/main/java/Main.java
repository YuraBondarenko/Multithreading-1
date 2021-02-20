public class Main {
    public static void main(String[] args) {
        CustomThread thread = new CustomThread();
        Thread runnable = new Thread(new CustomRunnable());

        thread.start();
        runnable.start();
    }
}
