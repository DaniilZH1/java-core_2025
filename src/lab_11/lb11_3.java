package lab_11;
import java.util.List;
import java.util.stream.Collectors;

public class lb11_3 {
    public static void main(String[] args) {

        String text = "Это пример строки с Разными словами и Большими буквами";

        List<String> strings = List.of(text.split(" "));

        System.out.println("\nСтрока после разбиения:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> result = filterCapitalizedStrings(strings);

        System.out.println("\nСтроки с большой буквы:\n");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
