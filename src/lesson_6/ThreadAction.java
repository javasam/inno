package lesson_6;

public class ThreadAction extends Thread {
    SyncMonitor syncMonitor;
    private int frequency;

    public ThreadAction(SyncMonitor syncMonitor, int frequency) {
        this.syncMonitor = syncMonitor;
        this.frequency = frequency;
    }

    @Override
    public void run() {
        for (int i = 0; i < syncMonitor.COUNT_ITERATOR; i++) {
            synchronized (syncMonitor) {
                try {
                    syncMonitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((syncMonitor.getTime(System.currentTimeMillis()) % frequency == 0)) {
                    System.out.println("Thread " + frequency);
                }
            }
        }
    }
}
