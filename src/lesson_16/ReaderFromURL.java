package lesson_16;

import java.io.*;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

//Input Sources[]
public class ReaderFromURL {
    private static final Logger LOGGER = Logger.getLogger(ReaderFromURL.class.getName());
    private static Pattern pattern = Pattern.compile("\\.\\.\\.|!|\\.|\\?|\n|\r");
    int count = 0;
    InputStream inputStream;

    public ReaderFromURL() {
    }

    public void readFromURLToArray(String url, String[] words, PriorityBlockingQueue<String> resultList) {
        try {
            if (url.contains("http") || (url.contains("ftp"))) { //если ссылка WEB, то URL openStream
                inputStream = new URL(url).openStream();
            } else {                                             // иначе FileInputStream
                inputStream = new FileInputStream(url);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String sentence;
            String[] sentences;
            while ((sentence = reader.readLine()) != null) {
                sentences = pattern.split(sentence);
                for (String word : words) {                                      // ищем среди предложений слово из массива words
                    for (String string : sentences) {
                        if (string.contains(word)) {                            // если находим слово в строке, то добавляем
                            resultList.add(string);                             // его в коллекцию
                            count++;
                        }
                    }
                }
            }
        } catch (UnknownHostException e) {
            LOGGER.log(Level.INFO, "Нет подключения к URL: " + url);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.INFO, "Файл не найден: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}