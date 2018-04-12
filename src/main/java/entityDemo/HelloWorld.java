package entityDemo;

public class HelloWorld {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return "print:"+message;
    }

    public void init(){
        System.out.println("Bean init");
    }

    public void destory(){
        System.out.println("Bean destory");
    }
}
