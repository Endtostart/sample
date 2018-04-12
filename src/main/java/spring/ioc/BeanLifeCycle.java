package spring.ioc;

import common.ApplicationData;
import entityDemo.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {
    /**
     * init-method 和 destory-method
     * @param args
     */
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(ApplicationData.BEAN_XML_PATH);
        HelloWorld helloWorld = (HelloWorld) context.getBean("beanLife");
        System.out.println(helloWorld);
        context.registerShutdownHook();
    }
}
