package lab1;

import java.util.Scanner;

public class lab1 {
    static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String fam = in.nextLine();

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите отчество: ");
        String otch = in.nextLine();
        System.out.printf("Hello " + fam +" " +name+ " "+ otch);
        in.close();
    }
}
