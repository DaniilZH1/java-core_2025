package lab3;

public class lab8 {
     static void main(String[] args) {

         int i = 10;
         char[] consonants = new char [i];

        int index = 0;

        for (char c = 'A'; c <= 'Z'; c++) {

            if (c != 'A' && c != 'E' && c != 'I') {

                consonants[index] = c;
                index++;


                if (index == i) {
                    break;
                }
            }
        }

        System.out.println("Содержимое массива:");
        for (char letter : consonants) {
            System.out.print(letter + " ");
        }
    }
}
