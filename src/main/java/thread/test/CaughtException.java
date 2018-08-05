package thread.test;

/**
 * 用uncaughtExceptionHandler捕获处理异常
 */
public class CaughtException{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {int a = 10/0;});
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("异常信息: thread : "+t.getName()+ "捕获的异常:"+e);
            }
        });
        thread.start();
    }

}
