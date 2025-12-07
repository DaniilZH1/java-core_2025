package lab3;
import java.util.Arrays;
import java.util.Random;
public class lab10 {
     static void main(String[] args) {

        int i1 = 10;
        int[] array = new int[i1];


        Random random = new Random();


        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }


        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));


        Arrays.sort(array);

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }


        System.out.println("Отсортированный массив (по убыванию):");
        System.out.println(Arrays.toString(array));
    }
}
