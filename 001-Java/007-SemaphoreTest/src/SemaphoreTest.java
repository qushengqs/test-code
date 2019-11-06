import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest implements Runnable {

    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getId() + " done!");
            semaphore.release();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ExecutorService es = Executors.newFixedThreadPool(20);
        final SemaphoreTest test = new SemaphoreTest();
        for (int i = 0; i < 20; i++) {
            es.execute(test);
        }
    }
}
