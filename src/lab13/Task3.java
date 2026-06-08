package lab13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов: ");
            int n = sc.nextInt();

            byte[] arr = new byte[n];

            int sum = 0;

            System.out.println("Введите элементы массива:");

            for (int i = 0; i < n; i++) {

                int value = sc.nextInt();

                if (value < Byte.MIN_VALUE ||
                        value > Byte.MAX_VALUE) {
                    throw new IllegalArgumentException(
                            "Число вне диапазона byte");
                }

                arr[i] = (byte) value;

                sum += arr[i];

                if (sum < Byte.MIN_VALUE ||
                        sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException(
                            "Переполнение при вычислении суммы");
                }
            }

            System.out.println("Сумма = " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не число.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
