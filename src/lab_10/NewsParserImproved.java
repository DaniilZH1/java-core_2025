package lab_10;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NewsParserImproved {

    public static void main(String[] args) {

        String url = "http://fat.urfu.ru/index.html";

        int attempts = 3;

        while (attempts > 0) {

            try {

                Document doc = Jsoup.connect(url).get();

                Elements newsParent = doc.select(
                        "body > table > tbody > tr > td > div > table > " +
                                "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                                "tr > td:nth-child(1)");

                FileWriter writer =
                        new FileWriter("news.txt");

                for (int i = 3; i < 20; i++) {

                    if (i % 2 != 0) {

                        List<Node> nodes =
                                newsParent.get(0).childNodes();

                        String title =
                                ((Element) nodes.get(i))
                                        .getElementsByClass("blocktitle")
                                        .get(0)
                                        .text();

                        String date =
                                ((Element) nodes.get(i))
                                        .getElementsByClass("blockdate")
                                        .get(0)
                                        .text();

                        String news =
                                "Тема: " + title +
                                        "\nДата: " + date + "\n";

                        System.out.println(news);

                        writer.write(news + "\n");
                    }
                }

                writer.close();

                System.out.println(
                        "Новости сохранены в файл news.txt");

                break;

            } catch (IOException e) {

                attempts--;

                System.out.println(
                        "Ошибка подключения. Осталось попыток: "
                                + attempts);

                if (attempts == 0) {
                    System.out.println(
                            "Не удалось подключиться к сайту.");
                }
            }
        }
    }
}