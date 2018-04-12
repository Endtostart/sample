package spring.ioc;

import entityDemo.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScope {
    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //单例
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        System.out.println(helloWorld); //hello world
        HelloWorld helloWorld2 = (HelloWorld)context.getBean("helloWorld");
        helloWorld2.setMessage("new world");
        System.out.println(helloWorld2);    //new world
        System.out.println(helloWorld); //new world

        System.out.println("---------------------华丽的分割线--------------------");
        //prototype
        HelloWorld helloWorld3 = (HelloWorld)context.getBean("helloWorld2");
        System.out.println(helloWorld3); //hello world2
        HelloWorld helloWorld4 = (HelloWorld)context.getBean("helloWorld2");
        helloWorld4.setMessage("new world");
        System.out.println(helloWorld3);    //hello world2
        System.out.println(helloWorld4); //new world
    }
}
