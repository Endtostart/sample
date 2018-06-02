package spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Boot {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        FooService fooService = (FooService) context.getBean("fooService");
        FooService fooService2 = new DefaultFooService();
        fooService.insertFoo(new Foo());
    }
}
