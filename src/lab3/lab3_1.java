package lab3;

public class lab3_1 {
     static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        int a = 1, b = 1;
        System.out.print("Последовательность: " + a);

        for (int i = 1; i < n; i++) {
            System.out.print(", " + b);
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
