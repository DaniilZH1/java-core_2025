package lab_9;

public class Recursion_5 {
    static void main(String[] args) {
        System.out.println(5);

    }

    public static int fact(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact(n - 2) + fact(n - 1);

        }
    }
}
