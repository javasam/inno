package lesson_7;

import java.util.*;

@Logged
public class MathBox implements MathBoxInterface {
    private TreeSet<Integer> treeSet = new TreeSet<>();
    private List<Integer> arrayListDivided = new ArrayList<>();

    MathBox(Integer massive[]) {
        for (int i = 0; i <= massive.length - 1; i++) {
            treeSet.add(massive[i]);
        }
        System.out.println(treeSet.toString());
    }

    public MathBox() {
    }

    @Override
    public Integer summator() {
        Iterator<Integer> iterator = treeSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    List split(int delimiter) {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            arrayListDivided.add(iterator.next() / delimiter);
        }
        return arrayListDivided;
    }

    @ClearData
    @Override
    public boolean setArray() {
        List arrayList = new ArrayList();
        arrayList.addAll(arrayListDivided);
        return arrayList != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox math = (MathBox) o;
        return Objects.equals(treeSet, math.treeSet) &&
                Objects.equals(arrayListDivided, math.arrayListDivided);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeSet, arrayListDivided);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "treeSet=" + treeSet +
                ", arrayListDivided=" + arrayListDivided +
                '}';
    }
}
