package lab4;
import java.util.Random;
public class lab5 {
    public static void main(String[] args) {

        int rows = 3;
        int cols = 5;
        int[][] matrix;
        matrix = new int[rows][cols];


        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); //
            }
        }

        System.out.println("Исходный массив:");
        printMatrix(matrix, rows, cols);


        int[][] transposedMatrix;
        transposedMatrix = new int[cols][rows];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }


        System.out.println("Транспонированный массив:");
        printMatrix(transposedMatrix, cols, rows);
    }


    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
