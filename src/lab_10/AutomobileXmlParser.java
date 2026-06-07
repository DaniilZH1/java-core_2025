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

public class AutomobileXmlParser {

    public static void main(String[] args) {

        try {

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

                Node node = automobileList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element automobile = (Element) node;

                    System.out.println(
                            automobile.getElementsByTagName("brand")
                                    .item(0)
                                    .getTextContent()
                                    + " "
                                    +
                                    automobile.getElementsByTagName("model")
                                            .item(0)
                                            .getTextContent()
                                    + " "
                                    +
                                    automobile.getElementsByTagName("year")
                                            .item(0)
                                            .getTextContent()
                    );
                }
            }

            // Поиск по марке

            String searchBrand = "BMW";

            System.out.println(
                    "\nПоиск автомобилей марки "
                            + searchBrand + ":");

            for (int i = 0; i < automobileList.getLength(); i++) {

                Element automobile =
                        (Element) automobileList.item(i);

                String brand =
                        automobile.getElementsByTagName("brand")
                                .item(0)
                                .getTextContent();

                if (brand.equalsIgnoreCase(searchBrand)) {

                    System.out.println(
                            brand + " "
                                    + automobile
                                    .getElementsByTagName("model")
                                    .item(0)
                                    .getTextContent()
                    );
                }
            }


            // Добавление автомобиля


            Element newCar =
                    doc.createElement("automobile");

            Element brand =
                    doc.createElement("brand");
            brand.setTextContent("Mercedes");

            Element model =
                    doc.createElement("model");
            model.setTextContent("E200");

            Element year =
                    doc.createElement("year");
            year.setTextContent("2022");

            newCar.appendChild(brand);
            newCar.appendChild(model);
            newCar.appendChild(year);

            doc.getDocumentElement()
                    .appendChild(newCar);

            System.out.println(
                    "\nДобавлен автомобиль Mercedes E200");

            // Удаление автомобиля

            String deleteModel = "Camry";

            NodeList cars =
                    doc.getElementsByTagName("automobile");

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

                    System.out.println(
                            "Удалён автомобиль: "
                                    + deleteModel);

                    break;
                }
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
