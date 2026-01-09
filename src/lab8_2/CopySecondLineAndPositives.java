package lab8_2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CopySecondLineAndPositives {
    public static void main(String[] args) {
        File src = new File("E:\\src.bin");
        File dst = new File("E:\\dst.bin");

        // 1) Создаём исходный файл программно:
        //    2 строки UTF-8 + 5 чисел double (в бинарном виде)
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(src))) {

            out.writeUTF("Первая строка");
            out.writeUTF("Вторая строка");

            out.writeDouble(-10.5);
            out.writeDouble(0.0);
            out.writeDouble(3.14);
            out.writeDouble(-2.0);
            out.writeDouble(7.0);

        } catch (IOException e) {
            System.out.println("Ошибка создания исходного файла: " + e.getMessage());
            return;
        }

        // 2) Читаем исходный файл и пишем в результирующий:
        //    переписываем вторую строку и только положительные числа
        try (DataInputStream in = new DataInputStream(new FileInputStream(src));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(dst))) {

            String line1 = in.readUTF();      // первая строка (просто читаем)
            String line2 = in.readUTF();      // вторая строка (её надо переписать)

            out.writeUTF(line2);

            for (int i = 0; i < 5; i++) {
                double x = in.readDouble();
                if (x > 0) {
                    out.writeDouble(x);
                }
            }

            // (не обязательно) покажем, что прочитали
            System.out.println("Исходная 1-я строка: " + line1);
            System.out.println("Переписали 2-ю строку: " + line2);
            System.out.println("Готово. Результат: " + dst.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Ошибка переписывания: " + e.getMessage());
        }

        // 3) (опционально) Проверка: вывод содержимого результирующего файла
        try (DataInputStream in = new DataInputStream(new FileInputStream(dst))) {
            System.out.println("\n--- Проверка dst ---");
            System.out.println("Строка: " + in.readUTF());
            while (true) { // читаем doubles до конца файла
                try {
                    System.out.println("Положительное число: " + in.readDouble());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка проверки: " + e.getMessage());
        }
    }
}
