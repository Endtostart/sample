package lock.redis;

public class LockDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Custorm custorm = new Custorm();
            custorm.doSomthing();
        });

        Thread t2 = new Thread(() -> {
            Provider provider = new Provider();
            provider.doSomthing();
        });

        t1.start();
        t2.start();

    }
}

class Custorm {
    DistributedLook look = new RedisDistributedLook();
    public void doSomthing() {
        String key = "22222";
        System.out.println("custorm key :" + key);
        if (look.tryLook(key,800)) {
            System.out.println("Custorm do Somthing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                look.unlook(key);
            }
        }else {
            System.out.println("Custorm do nothing");
        }

    }
}

class Provider {
    DistributedLook look = new RedisDistributedLook();
    public void doSomthing() {
        String key = "111111";
        System.out.println("provider key :" + key);
        if (look.tryLook(key,800)) {
            System.out.println("Provider do Somthing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                look.unlook(key);
            }
        }else {
            System.out.println("Provider do nothing");
        }
    }
}
