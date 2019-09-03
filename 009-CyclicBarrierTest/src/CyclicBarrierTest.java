import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        final int n = 10;
        Thread[] allSoldier = new Thread[n];
        boolean flag = false;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrierRun(false, n));

        System.out.println("集合队伍");
        for (int i = 0; i < n; i++) {
            System.out.println("士兵" + i + "报道");
            allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allSoldier[i].start();
        }
    }
}
