package lesson_4_part_2;

public class Main {
    public static void main(String[] args) throws WrongArgumentException {
        MathBox objectBox = new MathBox();
        objectBox.addObjectToCollection(22);
        objectBox.addObjectToCollection(1);
        objectBox.addObjectToCollection(45);
        objectBox.addObjectToCollection(3);
        System.out.println("коллекция заполнена: " + objectBox);
        objectBox.dump();
        System.out.println("Сумма элементов в коллекции: " + objectBox.summator());
        System.out.println("Все элементы коллекции поделены на 2: " + objectBox.split(2));
        objectBox.remover(22);
    }
}