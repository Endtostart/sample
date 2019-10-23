package mq.demo;

import mq.demo.message.Message;

public interface TopicListener {
    public boolean notification(Message message);
}
