package lab1;

import java.util.Scanner;

public class lab3 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Текущий день недели: ");
        String dayW = in.nextLine();

        System.out.println("Название месяца: ");
        String month = in.nextLine();

        System.out.println("Дата (Номер дня в месяце): ");
        int date = in.nextInt();

        System.out.println("Сегодня " + dayW + ", " +date +" " + month);
        in.close();
    }
}
