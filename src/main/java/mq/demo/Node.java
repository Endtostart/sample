package mq.demo;

import java.util.List;

public abstract class Node {
    List<Topic> topics;

    public abstract Topic addTopic(Topic topic);

    public abstract Topic removeTopic(Topic topic);




}
