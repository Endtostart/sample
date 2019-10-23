package redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DemoApplication {

    static RedisTemplate redisTemplate;
    static final String KEY = "lock_";
    static final long lockTime = 30;
    static final long lockTCycle = 30;
    static final String USER = "root";
    static final String PWD = "123";

    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("redis.*");
        redisTemplate = applicationContext.getBean(RedisTemplate.class);

        while (true) {
            System.out.println("请输入用户名：");
            Scanner scanner = new Scanner(System.in);
            String user = scanner.next();
            System.out.println("请输入密码：");
            scanner = new Scanner(System.in);
            String pwd = scanner.next();
            login(user, pwd);
        }


    }

    public static void login(String user, String pwd) {
        if (isLock(KEY + user)) {
            System.out.println("当前用户已被锁定");
            return;
        }

        if (checkUserAndPwd(user, pwd)) {
            System.out.println("登录成功");
            return;
        }

        Long count = inc(KEY + user);
        System.out.println(MessageFormat.format("当前用户 {0} 秒内，输入错误次数：{1}", lockTCycle, count));

    }

    public static boolean checkUserAndPwd(String user, String pwd) {
        if (USER.equals(user) && PWD.equals(pwd)) {
            removeLock(KEY + user);
            return true;
        }
        return false;
    }

    public static boolean isLock(String key) {
        Integer errorCount = (Integer) redisTemplate.opsForValue().get(key);
        if (!Objects.isNull(errorCount) && errorCount == 5) {
            return true;
        }
        return false;
    }

    public static Long inc(String key) {
        Long count =  redisTemplate.opsForValue().increment(key, 1);
        if (count == 1) {
            redisTemplate.expire(key, lockTCycle, TimeUnit.SECONDS);
        }
        if (count == 5) {
            redisTemplate.expire(key, lockTime, TimeUnit.SECONDS);
        }
        return count;
    }

    public static void removeLock(String key) {
        redisTemplate.delete(key);
    }



}
