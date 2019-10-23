package thread.waitnotify;

import thread.threadpool.MyThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyDemo {
    static Lock customLock = new ReentrantLock();
    static Lock productLock = new ReentrantLock();
    static Condition custom = customLock.newCondition();
    static Condition product = productLock.newCondition();
    static int goods = 0;
    static final int capacity = 20;

    static Warehouse<Integer> warehouses = new Warehouse<>();

    public static void main(String[] args) throws InterruptedException {
//        goods = 10;
//        System.out.println("当前商品数：" + goods);
//        List<Runnable> task = new ArrayList<>();
//        task.add(new Customer());
//        task.add(new Customer());
//        task.add(new Product());
//        task.add(new Product());
//        task.add(new Customer());
//        task.add(new Customer());
//        task.add(new Product());
//        task.add(new Product());
//
//        MyThreadPool pool = new MyThreadPool(4);
//        pool.submit(task);
//        pool.shutdown();
//        TimeUnit.MILLISECONDS.sleep(2000);
//        while (pool.isAlive()) {
//            TimeUnit.MILLISECONDS.sleep(500);
//        }
//        System.out.println("当前商品数：" + goods);

        List<Runnable> task = new ArrayList<>();
        task.add(new Customer());
        task.add(new Customer());
        task.add(new Product());
        task.add(new Product());
        task.add(new Customer());
        task.add(new Customer());
        task.add(new Product());
        task.add(new Product());
        System.out.println("开始 ==》 当前商品说：" + warehouses.getCount());
        MyThreadPool pool = new MyThreadPool(4);
        pool.submit(task);
        pool.shutdown();

        while (pool.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("结束 ==》 当前商品数：" + warehouses.getCount());
    }

    static class Customer implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                warehouses.take();
                System.out.println(Thread.currentThread().getName() + ": 消费商品  ==》 当前商品数： " + warehouses.getCount());
            }

        }
    }

    static class Product implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                warehouses.put(new Integer(i));
                System.out.println(Thread.currentThread().getName() + ": 生产商品  ==》 当前商品数： " + warehouses.getCount());
            }
        }
    }

    static class Warehouse<T> {
        private LinkedList<T> nodes = new LinkedList<>();

        public synchronized T take() {
            if (nodes.isEmpty()) {
                try {
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T t = nodes.poll();
            return t;
        }

        public synchronized void put(T t) {
            nodes.add(t);
            notifyAll();
        }

        public int getCount() {
            return nodes.size();
        }
    }

}

