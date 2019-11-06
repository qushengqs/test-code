/**
 * @Author: senne
 * @Date: 2019/9/24 13:44
 * @Version 1.0
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> threadLocal = new ThreadLocal<>();

    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance performance = new MethodPerformance(method);
        threadLocal.set(performance);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance performance = threadLocal.get();
        performance.printPerformance();
    }
}
