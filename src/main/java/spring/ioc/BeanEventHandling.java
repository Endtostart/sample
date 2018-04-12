package spring.ioc;

import common.ApplicationData;
import entityDemo.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanEventHandling {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(ApplicationData.BEAN_XML_PATH);
        context.start();
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        System.out.println(helloWorld);
        context.start();

    }
}
