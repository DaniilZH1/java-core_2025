package lab13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Количество строк: ");
            int rows = sc.nextInt();

            System.out.print("Количество столбцов: ");
            int cols = sc.nextInt();

            int[][] matrix = new int[rows][cols];

            System.out.println("Введите элементы матрицы:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.print("Введите номер столбца: ");
            int column = sc.nextInt();

            System.out.println("Столбец:");

            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][column]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не число.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: столбца с таким номером нет.");
        } finally {
            System.out.println("Программа завершена.");
        }
    }
}
