package redis.jedis;

import common.utils.JedisPoolClient;
import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolClient.getJedis();
        jedis.set("pool", "now");
        String value = jedis.get("pool");
        System.out.println(value);
        jedis.close();

    }

}