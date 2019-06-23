package entityDemo;

public class Message<T> {
    private static final int CODE_OK = 0;
    private static final int CODE_Fail = -1;

    private int code = CODE_OK;
    private String message;
    private T data;

    public Message() {

    }

    public Message(T data) {
        this.data = data;
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message ok(T data) {
        this.data = data;
        return this;
    }

    public Message error(String message) {
        this.code = CODE_Fail;
        this.message = message;
        return this;
    }

    public Message data(T data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
