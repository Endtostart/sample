package thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        AtomicDemo demo = new AtomicDemo();
        System.out.println("============== 开始：" +demo.num+" =================");
        ExecutorService executors = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executors.submit(new AtomicAction());
        }
        executors.shutdown();

        while (!executors.isTerminated()) {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("============== 结束：" +demo.num+" =================");
    }

    static class AtomicAction implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + num.addAndGet(1));
            }
        }
    }
}
