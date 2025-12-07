package lab3;
import java.util.Scanner;
public class lab4_3 {
     static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        int start = Math.max(a, b);
        int end = Math.min(a, b);

        for (int i = start; i >= end; i--) {
            System.out.println(i);
        }
    }
}
