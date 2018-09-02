package lesson_6;

public class Main {
    public static void main(String[] args) {
        SyncMonitor syncMonitor = new SyncMonitor();
        Timer timer = new Timer(syncMonitor);
        ThreadAction thread1 = new ThreadAction(syncMonitor, 5);
        ThreadAction thread2 = new ThreadAction(syncMonitor, 7);
        timer.start();
        thread1.start();
        thread2.start();
    }
}
