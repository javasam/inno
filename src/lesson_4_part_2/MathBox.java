package lesson_4_part_2;

import java.util.Iterator;
import java.util.TreeSet;

public class MathBox extends ObjectBox {
    TreeSet<Object> treeSetDivided = new TreeSet<>();

    MathBox() {
    }

    Integer summator() {
        Iterator<Object> iterator = treeSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += (int) iterator.next();
        }
        return sum;
    }

    TreeSet split(int delimiter) {
        Iterator<Object> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            treeSetDivided.add((int) iterator.next() / delimiter);
        }
        return treeSetDivided;
    }

    void remover(Integer integer) {
        if (integer != null) {
            treeSet.remove(integer);

            System.out.print("Объект " + integer.toString() + " удален!");
            System.out.println(treeSet);
        }
    }

    void dump() {
        for (Object object : treeSet) {
            System.out.print(object + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "" + treeSet;
    }
}
