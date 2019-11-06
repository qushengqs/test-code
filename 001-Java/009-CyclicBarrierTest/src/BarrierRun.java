/**
 * @Author: senne
 * @Date: 2019/9/3 15:48
 * @Version 1.0
 */
public class BarrierRun implements Runnable {

    boolean flag;
    int N;

    public BarrierRun(boolean flag, int N) {
        this.flag = flag;
        this.N = N;
    }

    @Override
    public void run() {
        if (this.flag) {
            System.out.println("司令：【士兵 " + N + "个， 任务完成！】");
        } else {
            System.out.println("司令：【士兵 " + N + "个， 集合完毕！】");
            this.flag = true;
        }
    }
}
