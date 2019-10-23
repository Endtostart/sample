package mq.demo;

import mq.demo.message.Message;

public interface StoreManage {
    public boolean store(Message message);

    public Message read(int offset);
}
