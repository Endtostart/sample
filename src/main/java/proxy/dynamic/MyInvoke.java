package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoke implements InvocationHandler{
    Object target;
    public MyInvoke(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName() == "say") {
            System.out.println("begain say()");
        }
        if (method.getName() == "play") {
            System.out.println("begain play()");
        }
        Object res = method.invoke(target, args);
        if (method.getName() == "say") {
            System.out.println("end say()");
        }
        if (method.getName() == "play") {
            System.out.println("end play()");
        }
        return res;
    }
}
