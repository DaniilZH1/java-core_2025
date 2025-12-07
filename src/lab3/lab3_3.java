package lab3;

public class lab3_3 {
     static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        int count = 0;
        int a = 1, b = 1;
        System.out.print("Последовательность: " + a);

        do {
            System.out.print(" " + b);
            int next = a + b;
            a = b;
            b = next;
            count++;
        } while (count < n - 1);
    }
}
