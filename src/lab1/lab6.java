package lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class lab6 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);



        {
            int cYear = LocalDate.now().getYear();

            System.out.println("Введите имя:");
            String name = in.nextLine();

            System.out.println("Введите год вашего рождения:");
            int bYear = in.nextInt();

            int age = cYear - bYear;

            System.out.printf(" %s ваш возраст %d лет \n", name, age);
        }
    }
}

