package lab8_3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CopyConsonantWords {
    // Русские согласные (в нижнем регистре)
    private static final String CONSONANTS = "бвгджзйклмнпрстфхцчшщ";

    public static void main(String[] args) {
        String inPath  = "E:\\text_in.txt";
        String outPath = "E:\\text_out.txt";

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(inPath), StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(outPath), StandardCharsets.UTF_8))) {

            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;

                // split() — выделяем "слова" из строки
                // Разделители: пробелы и знаки препинания/тире и т.п.
                String[] parts = line.split("[\\s\\p{Punct}«»—…]+");

                StringBuilder selected = new StringBuilder();
                int count = 0;

                for (String w : parts) {
                    if (w.isBlank()) continue;

                    // берём первую букву слова
                    char first = Character.toLowerCase(w.charAt(0));

                    // проверяем: русская согласная?
                    if (CONSONANTS.indexOf(first) >= 0) {
                        if (count > 0) selected.append(' ');
                        selected.append(w);
                        count++;
                    }
                }

                // Пишем в новый файл: номер строки + количество + слова
                // (строки без подходящих слов тоже можно писать — по требованию не запрещено)
                bw.write("Строка " + lineNo + " | слов: " + count);
                bw.newLine();
                bw.write(selected.toString());
                bw.newLine();
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
