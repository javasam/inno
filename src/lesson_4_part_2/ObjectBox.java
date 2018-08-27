package lesson_4_part_2;

import java.util.TreeSet;

public class ObjectBox {
    TreeSet<Object> treeSet = new TreeSet<>();

    public void addObjectToCollection(Object object) throws WrongArgumentException {
        try {
            treeSet.add(object);
        } catch (ClassCastException c) {
            throw new WrongArgumentException("Ошибка! Введен не числовой или дробный аргумент");
        }
    }

    void remover(Integer integer) {
        if (integer != null) {
            treeSet.remove(integer);

            System.out.print("Объект " + integer.toString() + " удален!");
            System.out.println(treeSet);
        }
    }
}
