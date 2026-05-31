package lab_11;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class lb11_7 {
    public static void main(String[] args) {

        String text = "Это простой пример строки для проверки длины слов";

        List<String> strings = List.of(text.split(" "));

        System.out.println("\nСписок строк:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите минимальную длину:");
        int minLength = in.nextInt();

        List<String> result = filterByLength(strings, minLength);

        System.out.println("\nСтроки длиннее заданного значения:\n");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
