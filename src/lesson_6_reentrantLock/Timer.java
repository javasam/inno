package lesson_6_reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Timer extends Thread {
    private SyncMonitor syncMonitor;
    private ReentrantLock lock;

    public Timer(SyncMonitor syncMonitor, ReentrantLock lock) {
        this.syncMonitor = syncMonitor;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < syncMonitor.COUNT_ITERATOR; i++) {
            lock.lock();
            try {
                Thread.sleep(1000);
                System.out.println(syncMonitor.getTime(System.currentTimeMillis()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}
