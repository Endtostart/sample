package thread.demo1;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

public class NumberHolder {
    private Integer number = 0;
    private Integer mock;
    private static final Integer DEFAULT_NUM = 0;

    public NumberHolder(){
        mock = DEFAULT_NUM;
    }

    public NumberHolder(Integer mock){
        this.mock = mock;
    }

    public synchronized void increase(){
        System.out.println("thread:"+ Thread.currentThread().getName()+"== in");
        while (number != 0){
            try {
                System.out.println("thread:"+ Thread.currentThread().getName()+"== wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("thread:"+ Thread.currentThread().getName()+"== increase");
        System.out.println(number);
        notifyAll();
    }

    public synchronized void decrease(){
        System.out.println("thread:"+ Thread.currentThread().getName()+"== in");
        while (number == 0){
            try {
                System.out.println("thread:"+ Thread.currentThread().getName()+"== wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number--;
        System.out.println("thread:"+ Thread.currentThread().getName()+"== decrease");
        System.out.println(number);
        notifyAll();
    }
}
