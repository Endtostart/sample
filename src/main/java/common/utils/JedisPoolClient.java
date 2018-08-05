package common.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolClient {
    static String host;
    static String port;
    static String passwd;
    static JedisPool jedisPool = null;

    static {
        init();
    }

    private static void init(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(40);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000 * 100);
        host = ConstansInfo.getRedisHost();
        port = ConstansInfo.getRedisPort();
        passwd = ConstansInfo.getRedisPasswd();
        jedisPool = new JedisPool(config,host, Integer.parseInt(port));
    }
    public JedisPoolClient(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public static Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        jedis.auth(passwd);
        return jedis;
    }

}
