import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtendThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");

        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>()) {
            @Override
            public void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行，Task Name：" + ((MyTask) r).getName());
            }

            @Override
            public void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成，Task Name：" + ((MyTask) r).getName());
            }

            @Override
            public void terminated() {
                System.out.println("线程池推出");
            }
        };

        for (int i = 0; i < 10; i++) {
            MyTask myTask = new MyTask("TASK-" + i);
            executorService.execute(myTask);
            Thread.sleep(10);
        }

        executorService.shutdown();
    }
}
