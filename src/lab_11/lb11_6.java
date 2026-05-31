package lab_11;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class lb11_6 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\nСписок чисел:\n");

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
            System.out.println(numbers.get(i));
        }

        Scanner in = new Scanner(System.in);
        System.out.println("\nВведите число (делитель):");
        int divisor = in.nextInt();

        List<Integer> result = filterDivisible(numbers, divisor);

        System.out.println("\nЧисла, делящиеся без остатка:\n");

        for (Integer n : result) {
            System.out.println(n);
        }
    }

    public static List<Integer> filterDivisible(List<Integer> list, int divisor) {
        return list.stream()
                .filter(x -> divisor != 0 && x % divisor == 0)
                .collect(Collectors.toList());
    }
}
