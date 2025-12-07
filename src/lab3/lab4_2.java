package lab3;
import java.util.Scanner;
public class lab4_2 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
    int a = scanner.nextInt();

        System.out.print("Введите второе число: ");
    int b = scanner.nextInt();

    int current = Math.min(a, b);
    int end = Math.max(a, b);

        while (current <= end) {
        System.out.println(current);
        current++;
    }
        }
    }
