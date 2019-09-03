import java.util.concurrent.Exchanger;

/**
 * @Author: senne
 * @Date: 2019/9/3 16:36
 * @Version 1.0
 */
public class Exchanger2 implements Runnable {
    private Exchanger<String> exchanger;

    public Exchanger2(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String a = "银行流水A";
            String b = exchanger.exchange(a);
            System.out.println(String.format("A和B数据是否一致：%b，A录入的是：%s，B录入的是：%s", a.equals(b), a, b));
        } catch (InterruptedException ex) {

        }
    }
}
