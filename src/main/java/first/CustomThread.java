package first;

class CustomThread extends Thread {
    private final Counter counter;

    public CustomThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.count(getName());
    }
}
