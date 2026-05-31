package lab_11;
import java.util.List;
import java.util.stream.Collectors;
public class lb11_9 {
    public static void main(String[] args) {

        String text = "Hello world 123 Java_17 чистоСлово test! пример";

        List<String> strings = List.of(text.split(" "));

        System.out.println("\nСписок строк:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> result = filterOnlyLetters(strings);

        System.out.println("\nТолько строки из букв:\n");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-ЯёЁ]+"))
                .collect(Collectors.toList());
    }
}
