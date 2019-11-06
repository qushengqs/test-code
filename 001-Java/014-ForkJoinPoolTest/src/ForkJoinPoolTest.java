import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Long sum = 0L;
        for (long i = 0; i <= 200000; i++) {
            sum += i;
        }
        System.out.println(sum);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0L, 200000L);

        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            System.out.println("sum = " + result.get());
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
