package lab3;
import java.util.Scanner;
public class lab5_1 {
     static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int count = scanner.nextInt();

        int current = 0;
        int sum = 0;
        int found = 0;

        System.out.println("Числа в сумме:");

        while (found < count) {
            if (current % 5 == 2 || current % 3 == 1) {
                sum += current;
                System.out.print(current + " ");
                found++;
            }
            current++;
        }

        System.out.println("\nСумма: " + sum);
    }
}
