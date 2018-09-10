package lesson_8_lab_1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static String[] getFIleNames() {
        File folder = new File("d:\\temp\\testset");
        File[] listOfFiles = folder.listFiles();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                results.add("d:/temp/testset/" + listOfFiles[i].getName());
            }
        }
        return results.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] urls = getFIleNames();

        String[] words = {"gendfgt", "didert", "erpepc", "drer", "nonert",};

        CopyOnWriteArrayList<String> resultList = new CopyOnWriteArrayList<>();
        List<Future<?>> futures = new ArrayList<>();
        ThreadPool threadPool = new ThreadPool();

        ExecutorService service =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1); //create worker threads in Thread Pool

        for (String url : urls) {
            futures.add(service.submit(new ThreadPool(url, words, resultList)));
        }
        service.shutdown();
        for (Future future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.writeCollectionToFile(resultList);
    }
}
