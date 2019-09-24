/**
 * @Author: senne
 * @Date: 2019/9/24 13:45
 * @Version 1.0
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        this.end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(this.serviceMethod + "花费" + elapse + "毫秒.");
    }
}
