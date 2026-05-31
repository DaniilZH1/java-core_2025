package lab_11;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
public class lb11_4 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\nСписок до:\n");

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(20));
            System.out.println(numbers.get(i));
        }

        List<Integer> result = squareList(numbers);

        System.out.println("\nСписок после возведения в квадрат:\n");

        for (Integer n : result) {
            System.out.println(n);
        }
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}
