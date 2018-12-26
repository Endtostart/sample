package redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisClient {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.17.3.223",6379);
        jedis.auth("654321");
        String name = jedis.get("name");
        System.out.println(name);

        HashMap<String, String> hs = new HashMap<>();
        hs.put("name","kit");
        hs.put("age","22");
        hs.put("contry","china");

        jedis.hmset("info",hs);

        Map ret = jedis.hgetAll("info");
        String value = (String) ret.get("name");
        System.out.println(value);

    }
}
