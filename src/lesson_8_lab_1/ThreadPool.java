package lesson_8_lab_1;

import java.io.*;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadPool implements Runnable {
    ReaderFromURL readerFromURL = new ReaderFromURL();
    CopyOnWriteArrayList<String> resultList = new CopyOnWriteArrayList<>();
    private String url;
    private String[] words;
    private static long timeAllThreads = 0;

    public ThreadPool() {
    }

    public ThreadPool(String url, String[] words, CopyOnWriteArrayList<String> resultList) {
        this.url = url;
        this.words = words;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        resultList.addAll(readerFromURL.readFromURLToArray(url, words));
        if (readerFromURL.count > 0) {
            System.out.println("Задача выполнена потоком: " + Thread.currentThread().getName());
            System.out.println("Совпадений найдено: " + readerFromURL.count);
            timeAllThreads += System.currentTimeMillis() - time;
        }
    }

    public void writeCollectionToFile(Collection collection) {
        String path = "C:\\projects\\inno\\src\\lesson_8_lab_1\\res.txt";
        File file;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWr = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWr);

            for (Object object : collection) {
                bw.write((String) object);
                bw.write(System.lineSeparator());
            }
            bw.close();
            fileWr.close();
            System.out.println("Затрачено времени всего: " + timeAllThreads);
            System.out.println("Write done!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
