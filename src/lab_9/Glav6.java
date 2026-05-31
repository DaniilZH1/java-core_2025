import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Glav6 {
    private static final int N = 7_000_000;
    private static final int INDEX = N / 2;

    public static void main(String[] args) {
        System.out.println("Количество элементов: " + N);
        System.out.println("Коллекции: ArrayDeque, ArrayList, LinkedList");
        System.out.println();
        System.out.println("Коллекция;Добавление в начало;Добавление в середину;Добавление в конец;"
                + "Удаление в начале;Удаление в середине;Удаление в конце;Получение по индексу");

        testArrayDeque();
        testArrayList();
        testLinkedList();
    }

    private static void testArrayDeque() {
        ArrayDeque<Integer> addFirstDeque = createDeque();
        long addFirst = getRunningTime(() -> addFirstDeque.addFirst(-1));

        ArrayDeque<Integer> addMiddleDeque = createDeque();
        long addMiddle = getRunningTime(() -> addMiddle(addMiddleDeque));

        ArrayDeque<Integer> addLastDeque = createDeque();
        long addLast = getRunningTime(() -> addLastDeque.addLast(-1));

        ArrayDeque<Integer> removeFirstDeque = createDeque();
        long removeFirst = getRunningTime(removeFirstDeque::removeFirst);

        ArrayDeque<Integer> removeMiddleDeque = createDeque();
        long removeMiddle = getRunningTime(() -> removeMiddle(removeMiddleDeque));

        ArrayDeque<Integer> removeLastDeque = createDeque();
        long removeLast = getRunningTime(removeLastDeque::removeLast);

        ArrayDeque<Integer> getDeque = createDeque();
        long getByIndex = getRunningTime(() -> blackhole(getByIteration(getDeque, INDEX)));

        printResult("ArrayDeque", addFirst, addMiddle, addLast,
                removeFirst, removeMiddle, removeLast, getByIndex);
    }

    private static void testArrayList() {
        ArrayList<Integer> addFirstList = createArrayList();
        long addFirst = getRunningTime(() -> addFirstList.add(0, -1));

        ArrayList<Integer> addMiddleList = createArrayList();
        long addMiddle = getRunningTime(() -> addMiddleList.add(INDEX, -1));

        ArrayList<Integer> addLastList = createArrayList();
        long addLast = getRunningTime(() -> addLastList.add(-1));

        ArrayList<Integer> removeFirstList = createArrayList();
        long removeFirst = getRunningTime(() -> removeFirstList.remove(0));

        ArrayList<Integer> removeMiddleList = createArrayList();
        long removeMiddle = getRunningTime(() -> removeMiddleList.remove(INDEX));

        ArrayList<Integer> removeLastList = createArrayList();
        long removeLast = getRunningTime(() -> removeLastList.remove(removeLastList.size() - 1));

        ArrayList<Integer> getList = createArrayList();
        long getByIndex = getRunningTime(() -> blackhole(getList.get(INDEX)));

        printResult("ArrayList", addFirst, addMiddle, addLast,
                removeFirst, removeMiddle, removeLast, getByIndex);
    }

    private static void testLinkedList() {
        LinkedList<Integer> addFirstList = createLinkedList();
        long addFirst = getRunningTime(() -> addFirstList.addFirst(-1));

        LinkedList<Integer> addMiddleList = createLinkedList();
        long addMiddle = getRunningTime(() -> addMiddleList.add(INDEX, -1));

        LinkedList<Integer> addLastList = createLinkedList();
        long addLast = getRunningTime(() -> addLastList.addLast(-1));

        LinkedList<Integer> removeFirstList = createLinkedList();
        long removeFirst = getRunningTime(removeFirstList::removeFirst);

        LinkedList<Integer> removeMiddleList = createLinkedList();
        long removeMiddle = getRunningTime(() -> removeMiddleList.remove(INDEX));

        LinkedList<Integer> removeLastList = createLinkedList();
        long removeLast = getRunningTime(removeLastList::removeLast);

        LinkedList<Integer> getList = createLinkedList();
        long getByIndex = getRunningTime(() -> blackhole(getList.get(INDEX)));

        printResult("LinkedList", addFirst, addMiddle, addLast,
                removeFirst, removeMiddle, removeLast, getByIndex);
    }

    private static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> list = new ArrayList<>(N + 1);
        fillList(list);
        return list;
    }

    private static LinkedList<Integer> createLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        fillList(list);
        return list;
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
    }

    private static ArrayDeque<Integer> createDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>(N + 1);
        for (int i = 0; i < N; i++) {
            deque.addLast(i);
        }
        return deque;
    }

    private static void addMiddle(ArrayDeque<Integer> deque) {
        ArrayDeque<Integer> temp = new ArrayDeque<>(INDEX);
        for (int i = 0; i < INDEX; i++) {
            temp.addLast(deque.removeFirst());
        }
        deque.addFirst(-1);
        while (!temp.isEmpty()) {
            deque.addFirst(temp.removeLast());
        }
    }

    private static void removeMiddle(ArrayDeque<Integer> deque) {
        ArrayDeque<Integer> temp = new ArrayDeque<>(INDEX);
        for (int i = 0; i < INDEX; i++) {
            temp.addLast(deque.removeFirst());
        }
        deque.removeFirst();
        while (!temp.isEmpty()) {
            deque.addFirst(temp.removeLast());
        }
    }

    private static int getByIteration(ArrayDeque<Integer> deque, int index) {
        int currentIndex = 0;
        for (Integer value : deque) {
            if (currentIndex == index) {
                return value;
            }
            currentIndex++;
        }
        throw new IndexOutOfBoundsException(index);
    }

    private static long getRunningTime(Runnable action) {
        System.gc();
        long start = System.nanoTime();
        action.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    private static volatile int sink;

    private static void blackhole(int value) {
        sink = value;
    }

    private static void printResult(String collection, long addFirst, long addMiddle, long addLast,
                                    long removeFirst, long removeMiddle, long removeLast,
                                    long getByIndex) {
        System.out.printf("%s;%d мс;%d мс;%d мс;%d мс;%d мс;%d мс;%d мс%n",
                collection, addFirst, addMiddle, addLast,
                removeFirst, removeMiddle, removeLast, getByIndex);
    }
}
