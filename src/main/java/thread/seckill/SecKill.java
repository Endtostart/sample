package thread.seckill;

import common.utils.JedisPoolClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecKill extends Thread {
    private static String watchKey = "goods";
    private static String succ_key = "success";
    private static String fail_key = "fail";

    @Override
    public void run() {
        Jedis jedis = JedisPoolClient.getJedis();
        try {
            jedis.watch(watchKey);
            int count = Integer.parseInt(jedis.get(watchKey));
            String userInfo = UUID.randomUUID().toString();
            if (count < 10) {
                Transaction tx = jedis.multi();
                tx.incr(watchKey);
                List<Object> list = tx.exec();
                if (list != null) {
                    System.out.println(userInfo+":抢购成功");
                    jedis.sadd(succ_key, userInfo);
                }else {
                    //System.out.println(userInfo+":抢购失败");
                    jedis.sadd(fail_key, userInfo);
                }
            }else {
                //System.out.println(userInfo+":抢购失败");
                jedis.sadd(fail_key, userInfo);
                return;
            }
        }finally {
            jedis.close();
        }

        
    }

    public static void main(String[] args) {
        Jedis jedis = JedisPoolClient.getJedis();
        jedis.set(watchKey,"0");
        jedis.del(succ_key);
        jedis.del(fail_key);
        jedis.close();
        System.out.println("开始抢购,当前抢购成功的人数：0");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new SecKill());
        }
        executor.shutdown();
        if (Thread.activeCount() < 2){
            System.out.println("抢购结束");
        }
    }
}
