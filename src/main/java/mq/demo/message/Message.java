package mq.demo.message;

public interface Message {
    Message build(Object o);
}
