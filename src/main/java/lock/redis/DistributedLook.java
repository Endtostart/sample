package lock.redis;

public interface DistributedLook {
    boolean look(String monitor);

    boolean look(String monitor, long timeout);

    boolean tryLook(String monitor,long time);

    boolean unlook(String monitor);
}
