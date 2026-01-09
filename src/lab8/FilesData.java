package lab8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FilesData {
    public static void main(String[] args) {
        File f1 = new File("E:\\My\\numIsh.txt");
        File f2 = new File("E:\\My\\numRez.txt");

        try (Scanner sc = new Scanner(System.in, "cp1251")) {

            // 1) Создание исходного файла и запись float
            f1.getParentFile().mkdirs();   // на всякий случай создаём папки
            f1.createNewFile();

            System.out.println("Сколько вещественных чисел записать в файл?");
            int count = sc.nextInt();

            System.out.println("Введите числа:");
            try (DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1))) {
                for (int i = 0; i < count; i++) {
                    wr.writeFloat(sc.nextFloat());
                }
            }

            // 2) Создание результирующего файла и переписывание чисел
            f2.createNewFile();

            try (DataInputStream rd = new DataInputStream(new FileInputStream(f1));
                 DataOutputStream wr = new DataOutputStream(new FileOutputStream(f2))) {

                while (true) {
                    try {
                        float number = rd.readFloat();
                        wr.writeFloat(number);
                        System.out.println("Число " + number);
                    } catch (EOFException e) {
                        break; // конец файла
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}





