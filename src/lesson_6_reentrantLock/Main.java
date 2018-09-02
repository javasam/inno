package lesson_6_reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SyncMonitor syncMonitor = new SyncMonitor();
        ReentrantLock lock = new ReentrantLock();
        Timer timer = new Timer(syncMonitor, lock);
        ThreadAction thread1 = new ThreadAction(syncMonitor, 5, lock);
        ThreadAction thread2 = new ThreadAction(syncMonitor, 7, lock);
        timer.start();
        thread1.start();
        thread2.start();
    }
}
