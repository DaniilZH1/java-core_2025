package lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class lab7 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cYear = LocalDate.now().getYear();

        System.out.println("Введите ваш возраст:");
        int bYear = in.nextInt();

        {
            int age = cYear - bYear;

            System.out.printf("Ваш год рождения %d  \n", age);
        }
    }
}

