package lab4;

public class lb4 {
    public static void main(String[] args) {

        int size = 5;

        char[][] triangle;
        triangle = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = '*';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (triangle[i][j] == 0) {
                    System.out.print(' ');
                } else {
                    System.out.print(triangle[i][j]);
                }
            }
            System.out.println();
        }
    }
}
