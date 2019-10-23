package thread.forkJoin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class QuickCount {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long num = 2000000000;
        System.out.println("=============== forkjoin ============ ");
        ForkJoinPool pool = new ForkJoinPool();
        Date startTime = new Date();
        Long count = pool.invoke(new SortRecursiveTask(0, num));
        Date endTime = new Date();
        Long timeDuration = endTime.getTime() - startTime.getTime();
        pool.shutdown();
        System.out.println("耗时：" + timeDuration);
        System.out.println("计算结果:" + count);

        System.out.println("=============== executor service ============ ");
        System.out.println();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        startTime = new Date();
        count = ExecutorTask.exec(executor, num);
        endTime = new Date();
        timeDuration = endTime.getTime() - startTime.getTime();
        System.out.println("耗时：" + timeDuration);
        System.out.println("计算结果:" + count);
        executor.shutdown();
    }

}

class ExecutorTask implements Callable<Long> {
    long begain;
    long end;

    public ExecutorTask(long begain, long end) {
        this.begain = begain;
        this.end = end;
    }

    public static Long exec(ExecutorService executor, long num) throws InterruptedException, ExecutionException {
        List<Callable<Long>> calls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            long begain = 0;
            long end = 0;
            long step = num / 10;
            if ( i != 0) {
                begain = i * step + 1;
            }
            end = (i + 1) * step;
            calls.add(new ExecutorTask(begain, end));
        }

        List<Future<Long>> futures = executor.invokeAll(calls);
        long total = 0;
        for (Future<Long> future : futures) {
            total += future.get();
        }
        return total;
    }

    @Override
    public Long call() throws Exception {
        long result = 0;
        for (long i = begain; i <= end; i++) {
            result += i;
        }
        return result;
    }
}

class SortRecursiveTask extends RecursiveTask<Long> {
    long begain;
    long end;

    public SortRecursiveTask(long begain, long end) {
        this.begain = begain;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long diffValue = end - begain;
        if (diffValue <= 2000000000/100) {
            long result = 0;
            for (long i = begain; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            SortRecursiveTask left = new SortRecursiveTask(begain, (end + begain) / 2);
            SortRecursiveTask right = new SortRecursiveTask((end + begain) / 2 + 1, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}
