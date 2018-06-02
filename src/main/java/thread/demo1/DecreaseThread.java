package thread.demo1;

public class DecreaseThread extends Thread{
    private NumberHolder numberHolder;

    public DecreaseThread(NumberHolder numberHolder){
        this.numberHolder = numberHolder;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<20;i++){
            numberHolder.decrease();
        }
    }
}
