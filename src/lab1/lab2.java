package lab1;

import java.util.Scanner;

public class lab2 {

    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите возраст: ");
        int age = in.nextInt();

        System.out.printf("Имя: %s Возраст: %s\n", name, age);
        in.close();
    }
}

