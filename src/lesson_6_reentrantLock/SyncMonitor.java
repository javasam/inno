package lesson_6_reentrantLock;

public class SyncMonitor {
    public int COUNT_ITERATOR = 20;
    private long START_TIME = System.currentTimeMillis();

    public synchronized int getTime(long timeFromThread) {
        return (int) (timeFromThread - START_TIME) / 1000;
    }
}