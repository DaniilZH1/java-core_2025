package lab6;

public class lb3 {
    private static class Example2{

        private static void calcMax(int ... array){
            int max = array[0];
            for (int i =0; i<array.length; i++) {
                max = Math.max(max, array[i]);
            }
            System.out.println("Maximum array[] = "+max);
        }

        private static void calcMin(int ... array){
            int min = array[0];
            for (int i =0; i<array.length; i++) {
                min = Math.min(min, array[i]);
            }
            System.out.println("Minimum array[] = "+min);
        }

        private static void calcAvg(int ... array){
            int sum = 0;
            for (int i =0; i<array.length; i++) {
                sum = array[i]+sum;
            }
            double avg = (double)sum/array.length;
            System.out.println("Average array[] = "+avg);
        }
    }
    public static void main(String[] args) {
        Example2.calcMax(1,5,-9,5,25,-1034);
        Example2.calcMin(3,0,50,-2,335,-5,6,170);
        Example2.calcAvg(3,6,50,0,33,-5,60,17);
    }
}
