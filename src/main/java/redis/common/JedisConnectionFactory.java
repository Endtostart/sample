package redis.common;


import common.utils.JedisPoolClient;
import redis.clients.jedis.Jedis;

public class JedisConnectionFactory implements RedisConnectionFactory {
    private static JedisPoolClient pool;

    public JedisConnectionFactory(JedisPoolClient pool) {
        this.pool = pool;
    }

    @Override
    public Jedis getConnection() {
        return pool.getJedis();
    }
}
