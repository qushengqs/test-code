import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: senne
 * @Date: 2019/9/3 15:40
 * @Version 1.0
 */
public class Soldier implements Runnable {
    String name;
    CyclicBarrier cyclicBarrier;

    public Soldier(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("准备");
            cyclicBarrier.await();

            doWork();

            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {

        }
    }

    public void doWork() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            System.out.println(this.name + "任务完成");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
