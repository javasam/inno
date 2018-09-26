package lesson_16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static String[] getFIleNames() {
        File folder = new File("d:\\temp\\testset1");
        File[] listOfFiles = folder.listFiles();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                results.add("d:/temp/testset1/" + listOfFiles[i].getName());
            }
        }
        return results.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] urls = getFIleNames();

        String[] words = {"мама"};

        PriorityBlockingQueue<String> resultList = new PriorityBlockingQueue<>();

        List<Future<?>> futures = new ArrayList<>();

        ExecutorService service =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1); //create worker threads in Thread Pool

        long time = System.currentTimeMillis();
        for (String url : urls) {
            futures.add(service.submit(new ThreadPool(url, words, resultList)));
        }
        service.shutdown();
        Thread thread = new Thread(() -> {
            String path = "C:\\projects\\inno\\src\\lesson_16\\res.txt";
            File file;
            try (FileWriter fileWr = new FileWriter(path);
                 BufferedWriter bw = new BufferedWriter(fileWr)) {
                file = new File(path);
                if (!file.exists()) {
                    file.createNewFile();
                }
                while (!service.isTerminated()) {
                    String take = resultList.take();
                    bw.write(take);
                    bw.write(System.lineSeparator());
                }
                LOGGER.log(Level.INFO, "Write done!");
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        thread.start();
        LOGGER.log(Level.INFO, "Всего потрачено миллисекунд: " + (System.currentTimeMillis() - time));
    }
}
