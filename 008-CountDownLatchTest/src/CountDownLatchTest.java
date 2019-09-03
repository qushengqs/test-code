import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest implements Runnable {

    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchTest test = new CountDownLatchTest();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");

            end.countDown();
        } catch (InterruptedException ex) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            es.execute(test);
        }

        end.await();

        System.out.println("Fire");

        es.shutdown();
    }
}
