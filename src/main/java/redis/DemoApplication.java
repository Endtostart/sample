package redis;

import common.utils.JedisPoolClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class DemoApplication {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolClient.getJedis();


    }
}
