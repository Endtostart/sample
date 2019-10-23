package mq.demo;

import mq.demo.message.Message;

import java.util.List;

public abstract class Topic {
    String topic;
    List<Group> listerGroups;
    StoreManage storeManage;

    public Topic(String topic) {
        this.topic = topic;
    }

    public boolean receive(Message message) {
        storeManage.store(message);
        return true;
    }

    public boolean notification() {
        int offset = concurrenOffset();
        Message message = storeManage.read(offset);
        return notifyListener(message);
    }

    public abstract int concurrenOffset();

    public abstract boolean notifyListener(Message message);

}
