package spring.aop.interceptor;

import org.springframework.stereotype.Component;

@Component
public class TestInterfaceImpl implements TestInterface{
    @Override
    public void say() {
        System.out.println("hello");
    }
}
