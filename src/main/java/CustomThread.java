class CustomThread extends Thread {
    @Override
    public void run() {
        Counter.counter(getName());
    }
}
