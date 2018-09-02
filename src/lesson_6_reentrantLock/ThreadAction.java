package lesson_6_reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadAction extends Thread {
    ReentrantLock lock;
    private SyncMonitor syncMonitor;
    private int frequency;

    public ThreadAction(SyncMonitor syncMonitor, int frequency, ReentrantLock lock) {
        this.syncMonitor = syncMonitor;
        this.frequency = frequency;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (!lock.isLocked()) {
            if ((syncMonitor.getTime(System.currentTimeMillis()) % frequency == 0)) {
                System.out.println("Thread " + frequency);
            }
        }
    }
}
