package lab12;

public class lab12_2 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);

                try {
                    Thread.sleep(1000); // задержка 1 секунда
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        try {
            thread.join(); // ожидание завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток завершил работу.");
    }
}
