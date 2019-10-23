package thread.test2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyRunnable());
        t.start();
        TimeUnit.MILLISECONDS.sleep(500);
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "主线程执行");
        lock.unlock();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "线程启动");
            System.out.println(Thread.currentThread().getName() + "  == 》 sleep 开始");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "  == 》 sleep 结束");
            lock.unlock();
        }
    }
}


