package lab6;

public class lb4 {
    public static void main(String[] args) {
        DoubleFactorial f = new DoubleFactorial();
        int number = 6;
        System.out.println("Рекурсивный метод");
        int fact = f.fact(number);
        System.out.println("Вычисление двойного факториала числа "+number+"!! = "+fact);
        System.out.println("Метод без рекурсии");
        int fact2 = f.fact2(number);
        System.out.println("Вычисление двойного факториала числа "+number+"!! = "+fact2);
    }
    private static class DoubleFactorial {
        private int fact(int n) {
            //это рекурсивный метод
            int result;
            System.out.println("*" + n);
            if (n == 1) return 1;
            if (n == 2) return 2;
            result = fact(n - 2) * n;
            return result;
        }

        private int fact2(int n) {
            //это метод без рекурсии

            int result = n;
            int j = n;
            for(int i=n; i>2;i=i-2){
                System.out.println("*" + j);
                j=j-2;
                result *= j;
            }
            return result;
        }
    }
}
