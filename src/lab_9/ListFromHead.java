package lab_9;

public class ListFromHead {
    public static void main(String[] args) {

        Node head = null;

        // создаём список с головы
        for (int i = 0; i < 10; i++) {
            head = new Node(i, head);
        }

        // вывод
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}
