package lab_9;

public class ListFromTail {

    public static void main(String[] args) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < 10; i++) {
            Node newNode = new Node(i);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // вывод
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}
