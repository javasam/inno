package lesson_3;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class MathBox {
    TreeSet<Integer> treeSet = new TreeSet<>();
    TreeSet<Integer> treeSetDivided = new TreeSet<>();
    MathBox(){}

    MathBox(Integer massive[]) {
        for (int i = 0; i <= massive.length - 1; i++) {
            treeSet.add(massive[i]);
        }
        System.out.println(treeSet.toString());
    }

    Integer summator(){
        Iterator<Integer> iterator = treeSet.iterator();
        int sum = 0;
        while(iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    TreeSet split (int delimiter) {
        Iterator<Integer> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            treeSetDivided.add(iterator.next()/delimiter);
        }
        return treeSetDivided;
    }

    void remover (Integer integer) {
        treeSet.remove(integer);
        System.out.print("Объект " + integer.toString() + " удален!");
        System.out.println(treeSet);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(treeSet, mathBox.treeSet) &&
                Objects.equals(treeSetDivided, mathBox.treeSetDivided);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeSet, treeSetDivided);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "treeSet=" + treeSet +
                ", treeSetDivided=" + treeSetDivided +
                '}';
    }
}
