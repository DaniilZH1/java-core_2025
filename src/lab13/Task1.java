package lab13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            System.out.println("Введите элементы массива:");

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int sum = 0;
            int count = 0;

            for (int x : arr) {
                if (x > 0) {
                    sum += x;
                    count++;
                }
            }

            if (count == 0) {
                throw new ArithmeticException(
                        "Положительные элементы отсутствуют");
            }

            double average = (double) sum / count;

            System.out.println("Среднее = " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
