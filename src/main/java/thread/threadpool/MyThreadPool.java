package thread.threadpool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MyThreadPool {
    private final int NEW = 0;
    private final int RUNNING = 1;
    private final int CANCAL = 2;
    private final int DONE = 3;

    private final boolean ISSHUTDOWN = false;

    private final Object lock = new Object();

    private AtomicInteger count = new AtomicInteger();

    private int corePoolSize = 1;
    private LinkedBlockingQueue<Runnable> taskQueue;
    private List<WorkThread> workQueue;

    public MyThreadPool() {
        workQueue = new ArrayList();
        taskQueue = new LinkedBlockingQueue<>();
    }

    public MyThreadPool(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        workQueue = new ArrayList();
        taskQueue = new LinkedBlockingQueue<>();
    }


    public void submit(Runnable runnable) {
        if (ISSHUTDOWN) {
            return;
        }
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int workCount = getStat();
        //System.out.println("当先工作中线程数：" + workCount + ",线程数:" + workQueue.size());
        if (workQueue.size() < corePoolSize) {
            addWordThread();
        } else {
            synchronized (lock) {
                lock.notifyAll();
            }
        }
    }

    public void submit(Collection<Runnable> runnables) {
        for (Runnable runnable : runnables) {
            submit(runnable);
        }
    }

    public void shutdown() {
        while (!taskQueue.isEmpty()) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        workQueue.stream().forEach(e -> {
            e.leave();
        });

    }

    public boolean isAlive() {
        return count.intValue() > 0;
    }

    private void addWordThread() {
        WorkThread workThread = new WorkThread();
        workThread.start();
        workQueue.add(workThread);
    }


    private int getStat() {
        return count.intValue();
    }

    protected Runnable getTask() {
        return taskQueue.poll();
    }


    class WorkThread extends Thread {
        private int stat;
        public WorkThread() {
            stat = NEW;
        }

        public void leave() {
            stat = DONE;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" : ==> 启动");
            while (stat != DONE) {
                Runnable task = getTask();
                if (task == null) {
                    stat = NEW;
                    synchronized (lock) {
                        try {
                            lock.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    continue;
                }
                count.incrementAndGet();
                try {
                    task.run();
                } finally {
                    count.decrementAndGet();
                }
            }
            System.out.println(Thread.currentThread().getName()+" : ==> 结束");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicInteger execCount = new AtomicInteger();
        MyThreadPool pool = new MyThreadPool(5);
        List<Runnable> runnables = new ArrayList<>();
        Stream.iterate(0, n -> n + 1).limit(100).forEach(e->{
            runnables.add(()->{
                System.out.println("》》》》》》》》》执行：" + Thread.currentThread().getName());
                execCount.incrementAndGet();
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            });
        });
        pool.submit(runnables);

        TimeUnit.MILLISECONDS.sleep(500);
        pool.shutdown();
        while (pool.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("执行结束：\n存活线程：" + pool.workQueue.size() + "\n剩余任务数:"+pool.count+"\n执行总次数:" + execCount.intValue());


    }

}


