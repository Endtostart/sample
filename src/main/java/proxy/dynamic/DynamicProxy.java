package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        final Target target = new TargetImp();
        InvocationHandler myInvoke = new MyInvoke(target);
        Target targetProxy = (Target) Proxy.newProxyInstance(TargetImp.class.getClassLoader(),TargetImp.class.getInterfaces(),myInvoke);

        targetProxy.say();
        targetProxy.play();

    }
}
