package lab_11;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
public class bl11_8 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\nСписок чисел:\n");

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
            System.out.println(numbers.get(i));
        }

        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите число (порог):");
        int threshold = in.nextInt();

        List<Integer> result = filterGreaterThan(numbers, threshold);

        System.out.println("\nЧисла больше заданного значения:\n");

        for (Integer n : result) {
            System.out.println(n);
        }
    }

    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x > threshold)
                .collect(Collectors.toList());
    }
}
