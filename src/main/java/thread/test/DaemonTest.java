package thread.test;

import java.util.concurrent.TimeUnit;

public class DaemonTest {
    public static void main(String[] args) {
        System.out.println("main begain");
        Thread thread = new Thread(()->{
            int count = 0;
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count++);
            }
        });
        thread.setDaemon(true);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
