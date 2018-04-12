package pattern.chainOfResponsibility;

public class LoggingDemo {
    static String desc = "Chain of Responsibility design pattern";

    public static void main(String[] args){
        System.out.println(desc);
        Logging log = new StdLogging("Std out.").setNext(new EmailLogging("Email send.")
        .setNext(new ErrLogging("Error exception")));

        log.sendMessage();
    }
}
