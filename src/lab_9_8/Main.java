package lab_9_8;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Введите элементы (0 - конец):");
        list.createTail();

        System.out.println("Список: " + list.toString());

        list.AddFirst(10);
        list.AddLast(20);
        System.out.println("После добавления: " + list.toString());

        list.Insert(1, 99);
        System.out.println("После вставки: " + list.toString());

        list.RemoveFirst();
        list.RemoveLast();
        list.Remove(1);
        System.out.println("После удаления: " + list.toString());

        System.out.println("Рекурсивный вывод: " + list.toStringRec());
    }
}
