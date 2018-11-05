package spring.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.getMethod().getName().equals("say")) {
            System.out.println("method:" + invocation.getMethod().getName());
        }
        invocation.proceed();
        return null;
    }
}
