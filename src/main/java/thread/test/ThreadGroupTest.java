package thread.test;

public class ThreadGroupTest {
    public static void main(String[] args) {
        System.out.println("当前活动的线程数："+Thread.currentThread().getThreadGroup().activeCount()
        +" 线程组名称: "+Thread.currentThread().getThreadGroup().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(()-> {
            System.out.println("当前活动的线程数："+Thread.currentThread().getThreadGroup().activeCount()
                    +" 线程组名称: "+Thread.currentThread().getThreadGroup().getName());

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        System.out.println("当前活动的线程数："+Thread.currentThread().getThreadGroup().activeCount()
                +" 线程组名称: "+Thread.currentThread().getThreadGroup().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        System.out.println("当前活动的线程数："+Thread.currentThread().getThreadGroup().activeCount()
                +" 线程组名称: "+Thread.currentThread().getThreadGroup().getName());



    }
}

