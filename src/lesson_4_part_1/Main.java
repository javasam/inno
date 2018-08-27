package lesson_4_part_1;

public class Main {
    public static void main(String[] args) throws WrongArgumentException {
        ObjectBox objectBox = new ObjectBox();
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
