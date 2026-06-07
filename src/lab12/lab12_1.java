package lab12;

import java.time.LocalTime;

public class lab12_1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            long endTime = System.currentTimeMillis() + 10_000;

            while (System.currentTimeMillis() < endTime) {
                System.out.println(
                        Thread.currentThread().getName() +
                                " : " + LocalTime.now()
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            long endTime = System.currentTimeMillis() + 10_000;

            while (System.currentTimeMillis() < endTime) {
                System.out.println(
                        Thread.currentThread().getName() +
                                " : " + LocalTime.now()
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Работа потоков завершена.");
    }
}
