package lab12;

public class lab12_3 {

    public static void main(String[] args) {

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Четный поток: " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Нечетный поток: " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Работа потоков завершена.");
    }
}
