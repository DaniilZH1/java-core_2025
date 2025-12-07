package lab3;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class lab9 {
    static void main(String[] args) {

        int size = 10;
        int[] numbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        System.out.println("Сгенерированный массив:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        if (numbers.length == 0) {
            System.out.println("Массив пуст.");
        }

        int minValue = numbers[0];
        List<Integer> minIndices = new ArrayList<>();

        for (int num : numbers) {
            if (num < minValue) {
                minValue = num;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == minValue) {
                minIndices.add(i);
            }
        }

        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Индексы минимального элемента (или элементов): " + minIndices);
    }
}
