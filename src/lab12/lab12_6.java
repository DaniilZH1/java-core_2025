package lab12;

public class lab12_6 {
    public static long sumArray(int[] array) throws InterruptedException {

        int numThreads = Runtime.getRuntime().availableProcessors();
        long[] partialSums = new long[numThreads];
        Thread[] threads = new Thread[numThreads];

        int chunkSize = (int) Math.ceil((double) array.length / numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);

            threads[i] = new Thread(() -> {
                long sum = 0;

                for (int j = start; j < end; j++) {
                    sum += array[j];
                }

                partialSums[index] = sum;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long totalSum = 0;
        for (long sum : partialSums) {
            totalSum += sum;
        }

        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException {

        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        long result = sumArray(array);

        System.out.println("Сумма элементов массива: " + result);
        System.out.println("Количество потоков: "
                + Runtime.getRuntime().availableProcessors());
    }
}
