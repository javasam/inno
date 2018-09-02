package lesson_6;

public class Timer extends Thread {
    private SyncMonitor syncMonitor;

    public Timer(SyncMonitor syncMonitor) {
        this.syncMonitor = syncMonitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < syncMonitor.COUNT_ITERATOR; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(syncMonitor.getTime(System.currentTimeMillis()));
                synchronized (syncMonitor) {
                    syncMonitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
