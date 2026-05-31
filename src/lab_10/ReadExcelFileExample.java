package lab_10;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class ReadExcelFileExample {
    public static void main(String[] args) throws IOException {

        // Открываем файл Excel
        String filePath = "src/lab_10/example.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаем объект книги Excel
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Получаем лист по имени
        XSSFSheet sheet = workbook.getSheet("Товары");

        // Перебираем строки и ячейки
        for (Row row : sheet) {
            for (Cell cell : row) {
                // Вывод значения ячейки
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }

        // Закрываем ресурсы
        workbook.close();
        inputStream.close();
    }
}
