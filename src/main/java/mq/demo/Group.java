package mq.demo;

import java.util.List;

public abstract class Group {
    List<TopicListener> members;

    public abstract TopicListener luckyDog();

    public abstract TopicListener remove(TopicListener listener);

    public abstract int add(TopicListener listener);
}
