package lab1;

import java.util.Scanner;

public class lab4 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите название месяца: ");
        String month = in.nextLine();

        System.out.println("Введите количество дней в месяце: ");
        int days = in.nextInt();

        System.out.printf("Месяц %s содержит %s дней \n", month, days);
    }
}