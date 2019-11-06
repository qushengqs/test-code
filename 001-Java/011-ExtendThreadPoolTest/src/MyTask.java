/**
 * @Author: senne
 * @Date: 2019/9/4 9:47
 * @Version 1.0
 */
public class MyTask implements Runnable {

    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.format("正在执行，线程id：%d，Task Name：%s", Thread.currentThread().getId(), this.name));
            Thread.sleep(100);
        } catch (InterruptedException ex) {

        }
    }
}
