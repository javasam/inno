package lesson_8_lab_1;

import java.io.*;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//Input Sources[]
public class ReaderFromURL {
    int count = 0;
    InputStream inputStream;

    public ReaderFromURL() {
    }

    public List readFromURLToArray(String url, String[] words) {
        List<String> tempResult = new ArrayList<>();
        try {
            if (url.contains("http") || (url.contains("ftp"))) { //если ссылка WEB, то URL openStream
                inputStream = new URL(url).openStream();
            } else {                                             // иначе FileInputStream
                inputStream = new FileInputStream(url);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String sentence;
            String[] sentences;
            Pattern pattern = Pattern.compile("\\.\\.\\.|!|\\.|\\?|\n|\r");
            while ((sentence = reader.readLine()) != null) {
                sentences = pattern.split(sentence);
                for (String word : words) {                                      // ищем среди предложений слово из массива words
                    for (String string : sentences) {
                        if (string.contains(word)) {                            // если находим слово в строке, то добавляем
                            tempResult.add(string);                             // его во временную коллекцию
                            count++;
                        }
                    }
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Нет подключения к URL: " + url);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempResult;
    }
}