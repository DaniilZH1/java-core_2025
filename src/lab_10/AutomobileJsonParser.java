package lab_10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class AutomobileJsonParser {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            JSONParser parser = new JSONParser();

            // Чтение JSON-файла
            JSONObject jsonObject = (JSONObject) parser.parse(
                    new FileReader("src/lab_10/automobile.json"));

            JSONArray automobiles =
                    (JSONArray) jsonObject.get("automobiles");

            // Поиск автомобиля по марке
            System.out.print("Введите марку для поиска: ");
            String searchBrand = scanner.nextLine();

            boolean found = false;

            System.out.println("\nНайденные автомобили:");

            for (Object obj : automobiles) {
                JSONObject car = (JSONObject) obj;

                if (searchBrand.equalsIgnoreCase(
                        (String) car.get("brand"))) {

                    System.out.println(
                            car.get("brand") + " "
                                    + car.get("model") + " ("
                                    + car.get("year") + ")");

                    found = true;
                }
            }

            if (!found) {
                System.out.println("Автомобили данной марки не найдены.");
            }

            // Добавление автомобиля
            System.out.println("\nДобавление нового автомобиля");

            System.out.print("Введите марку: ");
            String brand = scanner.nextLine();

            System.out.print("Введите модель: ");
            String model = scanner.nextLine();

            System.out.print("Введите год выпуска: ");
            long year = scanner.nextLong();
            scanner.nextLine();

            JSONObject newCar = new JSONObject();
            newCar.put("brand", brand);
            newCar.put("model", model);
            newCar.put("year", year);

            automobiles.add(newCar);

            System.out.println("Автомобиль успешно добавлен.");

            // Удаление автомобиля
            System.out.print(
                    "\nВведите модель автомобиля для удаления: ");
            String deleteModel = scanner.nextLine();

            boolean deleted = false;

            Iterator<?> iterator = automobiles.iterator();

            while (iterator.hasNext()) {
                JSONObject car = (JSONObject) iterator.next();

                if (deleteModel.equalsIgnoreCase(
                        (String) car.get("model"))) {

                    iterator.remove();
                    deleted = true;

                    System.out.println(
                            "Автомобиль удалён: "
                                    + deleteModel);
                }
            }

            if (!deleted) {
                System.out.println(
                        "Автомобиль с такой моделью не найден.");
            }

            // Сохранение изменений
            jsonObject.put("automobiles", automobiles);

            try (FileWriter file =
                         new FileWriter(
                                 "src/lab_10/automobile.json")) {

                file.write(jsonObject.toJSONString());
                file.flush();
            }

            System.out.println(
                    "\nИзменения успешно сохранены в файл.");

            // Вывод итогового списка
            System.out.println(
                    "\nИтоговый список автомобилей:");

            for (Object obj : automobiles) {
                JSONObject car = (JSONObject) obj;

                System.out.println(
                        "Марка: " + car.get("brand")
                                + ", Модель: " + car.get("model")
                                + ", Год: " + car.get("year"));
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println(
                    "Ошибка при работе с файлом:");
            e.printStackTrace();
        }
    }
}