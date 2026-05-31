package lab_9;
import java.util.HashMap;
import java.util.Map;
public class lab9_6 {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        // Заполняем 10 элементами
        map.put(0, "кот");
        map.put(1, "слон");
        map.put(2, "собака");
        map.put(3, "жираф");
        map.put(4, "лев");
        map.put(5, "тигр");
        map.put(6, "гиппопотам");
        map.put(7, "лиса");
        map.put(8, "крокодил");
        map.put(9, "медведь");

        // Найти строки, у которых ключ > 5
        System.out.println("Ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        //Если ключ = 0 → вывести строки через запятую
        System.out.print("\nЕсли ключ = 0: ");
        if (map.containsKey(0)) {
            String value = map.get(0);
            System.out.println(value + ",");
        }

        // Перемножить ключи, где длина строки > 5
        int product = 1;
        boolean found = false;

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }

        System.out.println("\nПроизведение ключей (длина строки > 5): " +
                (found ? product : "нет таких элементов"));
    }
}
