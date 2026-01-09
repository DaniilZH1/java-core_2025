package lab8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Buf_RW_2_1 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("E:\\MyFile1.txt"), "cp1251"));
             PrintWriter out = new PrintWriter("E:\\MyFile2.txt", "cp1251")) {

            int lineCount = 0;
            String s;

            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

