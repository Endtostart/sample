package thread.demo1;

public class NumberDemo {
    public static void main(String[] args) {
        NumberHolder numberHolder = new NumberHolder();
        Runnable runnable = new IncreaseThread(numberHolder);
        Thread increase = new Thread(runnable);
        Thread decrease = new DecreaseThread(numberHolder);
        Thread increase2 = new Thread(runnable);
        Thread decrease2 = new DecreaseThread(numberHolder);

        System.out.println("begain:"+Thread.currentThread().getName());
        increase.start();
        decrease.start();
        increase2.start();
        decrease2.start();
        try {
            increase.join();
            decrease.join();
            increase2.join();
            decrease2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
