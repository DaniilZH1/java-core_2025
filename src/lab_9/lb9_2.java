package lab_9;
import java.util.Scanner;

public class lb9_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Двоичное: 0");
        } else {
            System.out.print("Двоичное: ");
            toBinary(n);
        }
    }

    public static void toBinary(int n) {
        if (n == 0) {
            return;
        }

        toBinary(n / 2);       // рекурсивный вызов
        System.out.print(n % 2); // вывод остатка
    }
}
