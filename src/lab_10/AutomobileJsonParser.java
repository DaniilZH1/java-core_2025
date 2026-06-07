package lab_10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class AutomobileJsonParser {

    public static void main(String[] args) {

        try {
            JSONParser parser = new JSONParser();

            JSONObject jsonObject =
                    (JSONObject) parser.parse(
                            new FileReader("src/lab_10/automobile.json"));

            JSONArray automobiles =
                    (JSONArray) jsonObject.get("automobiles");

            // Поиск автомобилей по марке
            String searchBrand = "BMW";

            System.out.println("Поиск автомобилей марки: "
                    + searchBrand);

            System.out.println("Поиск автомобилей марки: " + searchBrand);

            for (Object obj : automobiles) {
                JSONObject car = (JSONObject) obj;

                if (searchBrand.equalsIgnoreCase((String) car.get("brand"))) {
                    System.out.println(
                            car.get("brand") + " "
                                    + car.get("model") + " ("
                                    + car.get("year") + ")");
                }
            }

            // Добавление нового автомобиля
            JSONObject newCar = new JSONObject();
            newCar.put("brand", "Mercedes");
            newCar.put("model", "E200");
            newCar.put("year", 2022);

            automobiles.add(newCar);

            System.out.println("\nАвтомобиль добавлен.");

            // Удаление автомобиля по модели
            String deleteModel = "Camry";

            Iterator iterator = automobiles.iterator();

            while (iterator.hasNext()) {
                JSONObject car = (JSONObject) iterator.next();

                if (deleteModel.equals(car.get("model"))) {
                    iterator.remove();
                    System.out.println(
                            "Автомобиль удалён: "
                                    + deleteModel);
                }
            }

            System.out.println("\nИтоговый список:");

            for (Object obj : automobiles) {
                JSONObject car = (JSONObject) obj;

                System.out.println(
                        car.get("brand") + " "
                                + car.get("model") + " "
                                + car.get("year"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}