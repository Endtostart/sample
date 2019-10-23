package redis.jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisClient {
    static Jedis jedis = new Jedis("172.17.0.246",6379);

    public static void main(String[] args) {

//        String name = jedis.get("name");
//        System.out.println(name);

//        HashMap<String, String> hs = new HashMap<>();
//        hs.put("name","kit");
//        hs.put("age","22");
//        hs.put("contry","china");
//
//        jedis.hmset("info",hs);
//
//        Map ret = jedis.hgetAll("info");
//        String value = (String) ret.get("name");
//        System.out.println(value);

        jedis.auth("123321");
        Long errorCount = check();
        int time = 1;



    }

    public static void erroLogin() {

    }



    public static Long check() {
//        String key = "111_tro";
//        Long count = jedi;
//        System.out.println("当前错误次数:" + count);
//        return count;
        return null;
    }

}
