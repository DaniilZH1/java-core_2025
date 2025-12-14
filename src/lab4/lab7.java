package lab4;

public class lab7 {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 5;
        int[][] matrix = new int[rows][cols];

        fillSnakeMatrix(matrix, rows, cols);
        printMatrix(matrix, rows, cols);
    }

    // Метод для заполнения матрицы
    public static void fillSnakeMatrix(int[][] matrix, int rows, int cols) {
        int number = 1; // начальное значение
        boolean leftToRight = true; // направление заполнения строки

        for (int i = 0; i < rows; i++) {
            if (leftToRight) {
                // Заполняем строку слева направо
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = number++;
                }
                leftToRight = false; // меняем направление
            } else {
                // Заполняем строку справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = number++;
                }
                leftToRight = true; // меняем направление
            }
        }
    }

    // Метод для вывода матрицы
    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
