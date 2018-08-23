package lesson_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayInt = {1, 22, 45, 598, 32, 87, 54};
        System.out.print("Коллекция выглядит так: ");
        MathBox mathBox = new MathBox(arrayInt);
        System.out.println("Суммируем все элементы: " + mathBox.summator());
        System.out.println("Делим все элементы на 2: " + mathBox.split(2).toString());
        mathBox.remover(22);
    }
}
