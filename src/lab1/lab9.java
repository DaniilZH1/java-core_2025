package lab1;

import java.util.Scanner;

public class lab9 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите  число:");
        int number = in.nextInt();

        int first = number - 1;
        int second = number;
        int third = number + 1;

        int fourth = (first + second + third) * (first + second + third);

        System.out.println("Последоветельность чисел:");
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);

    }
}