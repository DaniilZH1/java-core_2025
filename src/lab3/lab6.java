package lab3;
import java.util.Arrays;
import java.util.Scanner;
public class lab6 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        // Обработка ввода размера массива
        while (true) {
            try {
                System.out.print("Введите размер массива (положительное целое число): ");
                int size = Integer.parseInt(scanner.nextLine());

                if (size <= 0) {
                    throw new IllegalArgumentException("Размер должен быть положительным числом");
                }

                array = new int[size];
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите корректное целое число.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // Заполнение массива числами с остатком 2 при делении на 5
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 + i * 5;
        }

        // Вывод результата
        System.out.println("Полученный массив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
