package lab1;

import java.util.Scanner;

public class lab10 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int a = in.nextInt();

        System.out.println("Введите второе число:");
        int b = in.nextInt();

        int sum = a + b;

        int difference = a - b;

        System.out.println("Сумма = " + sum);
        System.out.println("Разность = " + difference);

    }
}