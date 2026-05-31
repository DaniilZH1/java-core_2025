package lab_9;
import java.util.ArrayList;


public class JosephusArrayList {
    public static void main(String[] args) {
        int N = 10;

        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;

        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }

        System.out.println("Остался: " + list.get(0));
    }
}
