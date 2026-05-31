package lab_9;

public class lb9_1 {
    static int depth = 0;

    public static void main(String[] args) {
        int result = fact(5);
        System.out.println("Result: " + result);
    }

    public static int fact(int n) {
        printIndent();
        System.out.println("Enter fact(" + n + ")");
        depth++;

        int result;

        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fact(n - 2) + fact(n - 1);
        }

        depth--;
        printIndent();
        System.out.println("Exit fact(" + n + ") = " + result);

        return result;
    }

    private static void printIndent() {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }
}

