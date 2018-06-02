package spring;

import common.ApplicationData;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.MyBeanDefinitionRegistryPostProcessor;
import spring.ioc.beans.MyFactoryBean;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(ApplicationData.BEAN_XML_PATH);
        MyFactoryBean myFactoryBean = (MyFactoryBean)context.getBean("myFactoryBean");
        myFactoryBean.say();
    }
}
