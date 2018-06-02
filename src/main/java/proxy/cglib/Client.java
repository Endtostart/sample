package proxy.cglib;

public class Client {
    public static void main(String[] args) {
        Target target = new Target();
        Target targetProxy = (Target) TargetCglibProxy.me(target);
        System.out.println("=================target====================");
        target.add();
        System.out.println("=================target====================");
        System.out.println("=================proxy====================");
        targetProxy.add();
        System.out.println("=================proxy====================");
    }
}
