package lab4;
import java.util.Scanner;
public class lab8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalText = "";
        String encryptedText = "";
        int key = 0;


        System.out.println("Введите текст для шифрования");
        originalText = scanner.nextLine();


        System.out.println("Введите ключ");

        while (!scanner.hasNextInt()) {
            System.out.println("Введите корректный ключ (целое число):");
            scanner.next();
        }
        key = scanner.nextInt();
        scanner.nextLine();


        encryptedText = transformText(originalText, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("y")) {

                String decryptedText = transformText(encryptedText, -key);
                System.out.println("Текст после обратного преобразования: " + decryptedText);
                break;
            } else if (choice.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        scanner.close();
    }

    public static String transformText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {

            char transformedChar = (char) (character + key);
            result.append(transformedChar);
        }
        return result.toString();
    }

}
