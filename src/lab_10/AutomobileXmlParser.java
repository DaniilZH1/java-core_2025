package lab_10;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.Scanner;

public class AutomobileXmlParser {

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            File xmlFile = new File("src/lab_10/automobile.xml");

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: "
                    + doc.getDocumentElement().getNodeName());

            // Вывод всех автомобилей

            NodeList automobileList =
                    doc.getElementsByTagName("automobile");

            System.out.println("\nСписок автомобилей:");

            for (int i = 0; i < automobileList.getLength(); i++) {

                Element automobile =
                        (Element) automobileList.item(i);

                String brand =
                        automobile.getElementsByTagName("brand")
                                .item(0)
                                .getTextContent();

                String model =
                        automobile.getElementsByTagName("model")
                                .item(0)
                                .getTextContent();

                String year =
                        automobile.getElementsByTagName("year")
                                .item(0)
                                .getTextContent();

                System.out.println(
                        "Марка: " + brand +
                                ", Модель: " + model +
                                ", Год: " + year
                );
            }

            // Добавление автомобиля

            System.out.println("\nДобавление нового автомобиля");

            System.out.print("Введите марку: ");
            String newBrand = scanner.nextLine();

            System.out.print("Введите модель: ");
            String newModel = scanner.nextLine();

            System.out.print("Введите год выпуска: ");
            String newYear = scanner.nextLine();

            Element newCar =
                    doc.createElement("automobile");

            Element brand =
                    doc.createElement("brand");
            brand.setTextContent(newBrand);

            Element model =
                    doc.createElement("model");
            model.setTextContent(newModel);

            Element year =
                    doc.createElement("year");
            year.setTextContent(newYear);

            newCar.appendChild(brand);
            newCar.appendChild(model);
            newCar.appendChild(year);

            doc.getDocumentElement()
                    .appendChild(newCar);

            System.out.println(
                    "Автомобиль успешно добавлен.");

            // Поиск по марке

            System.out.print(
                    "\nВведите марку для поиска: ");

            String searchBrand =
                    scanner.nextLine();

            boolean found = false;

            System.out.println(
                    "\nРезультаты поиска:");

            NodeList searchList =
                    doc.getElementsByTagName("automobile");

            for (int i = 0; i < searchList.getLength(); i++) {

                Element automobile =
                        (Element) searchList.item(i);

                String currentBrand =
                        automobile.getElementsByTagName("brand")
                                .item(0)
                                .getTextContent();

                if (currentBrand.equalsIgnoreCase(searchBrand)) {

                    found = true;

                    System.out.println(
                            "Модель: "
                                    + automobile
                                    .getElementsByTagName("model")
                                    .item(0)
                                    .getTextContent()
                                    + ", Год: "
                                    + automobile
                                    .getElementsByTagName("year")
                                    .item(0)
                                    .getTextContent()
                    );
                }
            }

            if (!found) {
                System.out.println(
                        "Автомобили не найдены.");
            }

            // Поиск по году выпуска

            System.out.print(
                    "\nВведите год выпуска для поиска: ");

            String searchYear =
                    scanner.nextLine();

            found = false;

            System.out.println(
                    "\nАвтомобили за указанный год:");

            for (int i = 0; i < searchList.getLength(); i++) {

                Element automobile =
                        (Element) searchList.item(i);

                String currentYear =
                        automobile.getElementsByTagName("year")
                                .item(0)
                                .getTextContent();

                if (currentYear.equals(searchYear)) {

                    found = true;

                    System.out.println(
                            "Марка: "
                                    + automobile
                                    .getElementsByTagName("brand")
                                    .item(0)
                                    .getTextContent()
                                    + ", Модель: "
                                    + automobile
                                    .getElementsByTagName("model")
                                    .item(0)
                                    .getTextContent()
                    );
                }
            }

            if (!found) {
                System.out.println(
                        "Автомобили не найдены.");
            }

            // Удаление автомобиля по модели

            System.out.print(
                    "\nВведите модель автомобиля для удаления: ");

            String deleteModel =
                    scanner.nextLine();

            NodeList cars =
                    doc.getElementsByTagName("automobile");

            boolean deleted = false;

            for (int i = 0; i < cars.getLength(); i++) {

                Element automobile =
                        (Element) cars.item(i);

                String currentModel =
                        automobile.getElementsByTagName("model")
                                .item(0)
                                .getTextContent();

                if (currentModel.equalsIgnoreCase(deleteModel)) {

                    automobile.getParentNode()
                            .removeChild(automobile);

                    deleted = true;

                    System.out.println(
                            "Автомобиль удалён.");

                    break;
                }
            }

            if (!deleted) {
                System.out.println(
                        "Модель не найдена.");
            }

            // Сохранение XML

            Transformer transformer =
                    TransformerFactory
                            .newInstance()
                            .newTransformer();

            transformer.setOutputProperty(
                    OutputKeys.INDENT,
                    "yes");

            transformer.setOutputProperty(
                    OutputKeys.ENCODING,
                    "UTF-8");

            transformer.transform(
                    new DOMSource(doc),
                    new StreamResult(xmlFile)
            );

            System.out.println(
                    "\nИзменения сохранены в XML-файл.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}