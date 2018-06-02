package pattern.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("caller Singleton");
        //Singleton singleton = Singleton.getSingleton();
        Singleton.trigger();
    }
}
