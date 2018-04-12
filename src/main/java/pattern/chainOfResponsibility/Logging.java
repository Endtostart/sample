package pattern.chainOfResponsibility;

public abstract class Logging {
    public String mask;
    protected Logging next;

    public Logging setNext(Logging next){
        if(this.next == null){
            this.next = next;
        }
        return this;
    }
    public abstract void sendMessage();
}

class EmailLogging extends Logging {
    public String mask;
    public EmailLogging(String mask){
        this.mask = mask;
    }
    public void sendMessage() {
        System.out.println("EmailLogging:"+mask);
        if(next != null){
            next.sendMessage();
        }
    }
}


class StdLogging extends Logging {
    public String mask;
    public StdLogging(String mask){
        this.mask = mask;
    }
    public void sendMessage() {
        System.out.println("StdLoggin:"+mask);
        if(next != null){
            next.sendMessage();
        }
    }
}

class ErrLogging extends Logging {
    public String mask;
    public ErrLogging(String mask){
        this.mask = mask;
    }
    public void sendMessage() {
        System.out.println("ErrLoggin:"+mask);
        if(next != null){
            next.sendMessage();
        }
    }
}
