import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        LinkedBlockingQueue queue = new LinkedBlockingQueue(1024);

        for (int i = 0; i < 5; i++) {
            final int number = i;
            new Thread(() -> {
                try {
                    for (int j = 0; ; j++) {
                        queue.put(number + "号线程的" + j + "号商品");
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException ex) {

                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    for (; ; ) {
                        System.out.println("消费了" + queue.take());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {

                }
            }).start();
        }
    }
}
