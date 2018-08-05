package thread.test;

/**
 * 重写start方法,执行start方法,只是简单的方法调用,并没有真正的启动线程
 */
public class OverrideStart extends Thread {
    @Override
    public void start(){
        System.out.println("override function start run");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" : this thread is running");
    }

    public static void main(String[] args) {
        OverrideStart os = new OverrideStart();
        System.out.println("function is begain");
        os.start();
        System.out.println("function is end");
    }
}
