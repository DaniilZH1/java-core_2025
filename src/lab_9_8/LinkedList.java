package lab_9_8;

import java.util.Scanner;

public class LinkedList {
    private Node head;


    // а) Цикл

    public void createHead() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        while (x != 0) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            x = sc.nextInt();
        }
    }

    public void createTail() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Node tail = null;

        while (x != 0) {
            Node newNode = new Node(x);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            x = sc.nextInt();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }

        return sb.toString();
    }

    public void AddFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void AddLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void Insert(int index, int value) {
        if (index == 0) {
            AddFirst(value);
            return;
        }

        Node current = head;
        int i = 0;

        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }

        if (current == null) return;

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void RemoveFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void RemoveLast() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    public void Remove(int index) {
        if (head == null) return;

        if (index == 0) {
            RemoveFirst();
            return;
        }

        Node current = head;
        int i = 0;

        while (current.next != null && i < index - 1) {
            current = current.next;
            i++;
        }

        if (current.next == null) return;

        current.next = current.next.next;
    }


    // б) Рекурсия

    public void createHeadRec() {
        Scanner sc = new Scanner(System.in);
        head = createHeadRecHelper(sc);
    }

    private Node createHeadRecHelper(Scanner sc) {
        int x = sc.nextInt();
        if (x == 0) return null;

        Node newNode = new Node(x);
        newNode.next = createHeadRecHelper(sc);
        return newNode;
    }

    public void createTailRec() {
        Scanner sc = new Scanner(System.in);
        head = createTailRecHelper(sc);
    }

    private Node createTailRecHelper(Scanner sc) {
        int x = sc.nextInt();
        if (x == 0) return null;

        Node newNode = new Node(x);
        newNode.next = createTailRecHelper(sc);
        return newNode;
    }

    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.data + " " + toStringRecHelper(node.next);
    }
}