package lab_11;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class lb11_5 {
    public static void main(String[] args) {

        String text = "Java это мощный язык программирования Java используется повсюду";

        List<String> strings = List.of(text.split(" "));

        System.out.println("\nСписок строк:\n");
        for (String s : strings) {
            System.out.println(s);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите подстроку для поиска:");
        String substring = in.nextLine();

        List<String> result = filterBySubstring(strings, substring);

        System.out.println("\nРезультат:\n");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
