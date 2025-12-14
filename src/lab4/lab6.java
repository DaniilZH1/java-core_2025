package lab4;
import java.util.Random;
public class lab6 {
    public static void main(String[] args) {

        int rows = 5;
        int cols = 5;
        int[][] array = new int[rows][cols];

        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Исходный массив:");
        printArray(array);

        int rowToRemove = random.nextInt(rows);
        int colToRemove = random.nextInt(cols);

        System.out.println("\nУдаляем строку " + rowToRemove + " и столбец " + colToRemove);


        int[][] newArray = new int[rows-1][cols-1];
        int newRow = 0;
        for (int i = 0; i < rows; i++) {
            if (i == rowToRemove) continue;

            int newCol = 0;
            for (int j = 0; j < cols; j++) {
                if (j == colToRemove) continue;
                newArray[newRow][newCol] = array[i][j];
                newCol++;
            }
            newRow++;
        }

        System.out.println("\nРезультирующий массив:");
        printArray(newArray);
    }

    // Метод для вывода массива
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }
}
