package lock.redis;

import common.utils.JedisPoolClient;
import redis.clients.jedis.Jedis;

import java.util.Date;

public class RedisDistributedLook implements DistributedLook{

    private Jedis jedis;

    private static final String LOOK_KEY = "lockkeys";
    private static final long TIMEOUT = 100; // ms
    private static boolean hasTimeOut = false;

    public RedisDistributedLook() {
        jedis = JedisPoolClient.getJedis();
    }

    public RedisDistributedLook(Jedis jedis) {
        this.jedis = jedis;
    }

    public RedisDistributedLook(Jedis jedis,boolean hasTimeOut) {
        this.jedis = jedis;
        RedisDistributedLook.hasTimeOut = hasTimeOut;
    }

    @Override
    public boolean look(String monitor) {
        /*if (jedis.exists(monitor)) {
            return false;
        }*/
        jedis.rpush(LOOK_KEY, monitor);
        if (jedis.lindex(LOOK_KEY, 0).equals(monitor)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean look(String monitor, long timeout) {
        if (jedis.exists(monitor)) {
            return false;
        }
        //jedis.rpush(this.hashCode() + monitor,monitor,"NX","PX",timeout);
        return true;
    }

    @Override
    public boolean tryLook(String monitor, long timeout) {
        Date start = new Date();
        Date end;
        jedis.rpush(LOOK_KEY, monitor);
        while (true) {
            end = new Date();
            if (end.getTime() - start.getTime() >= timeout) {
                return false;
            }
            if (!jedis.lindex(LOOK_KEY,0).equals(monitor)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            return true;
        }
    }

    @Override
    public boolean unlook(String monitor) {
        try {
            if (!jedis.lindex(LOOK_KEY, 0).equals(monitor)) {
                throw new Exception();
            }
            jedis.lpop(LOOK_KEY);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isHasTimeOut() {
        return hasTimeOut;
    }
}
