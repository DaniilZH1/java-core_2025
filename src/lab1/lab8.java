package lab1;

import java.util.Scanner;


public class lab8 {

    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int a = in.nextInt();

        System.out.println("Введите второе число:");
        int b = in.nextInt();

        System.out.println("Сумма = " + Integer.sum(a, b));


    }
}
