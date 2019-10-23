package thread.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduleThreadPool = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(3);
        Task task = new Task();
        scheduleThreadPool.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 时间:" + LocalTime.now().getSecond());
        }
    }
}

