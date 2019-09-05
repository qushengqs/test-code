import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: senne
 * @Date: 2019/9/5 13:31
 * @Version 1.0
 */
public class CountTask extends RecursiveTask<Long> {

    private static int THRESHOLD = 10000;

    private Long start;
    private Long end;

    public CountTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long compute() {
        long sum = 0;

        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        long step = (end - start) / 100;
        ArrayList<CountTask> countTasks = new ArrayList<>();
        long pos = start;
        for (long i = 0; i < 100; i++) {
            long lastOne = pos + step;
            if (lastOne > end) {
                lastOne = end;
            }

            CountTask countTask = new CountTask(pos, lastOne);
            countTasks.add(countTask);
            countTask.fork();
            pos += step + 1;
        }

        for (CountTask countTask : countTasks) {
            sum += countTask.join();
        }
        return sum;
    }
}
