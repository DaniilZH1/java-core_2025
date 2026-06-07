package lab12;

public class lab12_5 {
    public static int findMax(int[] array) throws InterruptedException {

        int numThreads = Runtime.getRuntime().availableProcessors();
        int[] localMax = new int[numThreads];
        Thread[] threads = new Thread[numThreads];

        int chunkSize = (int) Math.ceil((double) array.length / numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);

            threads[i] = new Thread(() -> {
                if (start < array.length) {
                    localMax[index] = array[start];

                    for (int j = start + 1; j < end; j++) {
                        if (array[j] > localMax[index]) {
                            localMax[index] = array[j];
                        }
                    }
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int max = localMax[0];
        for (int i = 1; i < localMax.length; i++) {
            if (localMax[i] > max) {
                max = localMax[i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws InterruptedException {

        int[] array = {12, 45, 7, 89, 34, 100, 56, 23, 78, 91};

        int max = findMax(array);

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Количество потоков: "
                + Runtime.getRuntime().availableProcessors());
    }
}
