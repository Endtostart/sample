package pattern.singleton;

public class Singleton {
    static {
        System.out.println("Singleton class init");
    }

    private Singleton(){
        System.out.println("init");
    }

    private final static class SingletonHandler{
        static {
            System.out.println("SingletonHandler class init");
        }
        final static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return SingletonHandler.singleton;
    }

    public static void trigger(){
        System.out.println("trogger");
    }
}
