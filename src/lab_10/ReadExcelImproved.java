package lab_10;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelImproved {

    public static void main(String[] args) {

        String filePath = "src/lab_10/example.xlsx";

        try {

            File file = new File(filePath);

            if (!file.exists()) {
                throw new IOException(
                        "Файл не найден: " + filePath);
            }

            FileInputStream inputStream =
                    new FileInputStream(file);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(inputStream);

            XSSFSheet sheet =
                    workbook.getSheet("Товары");

            if (sheet == null) {
                throw new IOException(
                        "Лист 'Товары' отсутствует.");
            }

            for (Row row : sheet) {

                for (Cell cell : row) {
                    System.out.print(
                            cell.toString() + "\t");
                }

                System.out.println();
            }

            workbook.close();
            inputStream.close();

        } catch (IOException e) {

            System.out.println(
                    "Ошибка при работе с Excel:");

            System.out.println(
                    e.getMessage());

            System.out.println(
                    "Проверьте наличие файла и листа.");

        } catch (Exception e) {

            System.out.println(
                    "Неизвестная ошибка:");

            e.printStackTrace();
        }
    }
}