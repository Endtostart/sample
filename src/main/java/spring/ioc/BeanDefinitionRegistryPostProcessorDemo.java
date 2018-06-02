package spring.ioc;

import common.ApplicationData;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDefinitionRegistryPostProcessorDemo {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(ApplicationData.BEAN_XML_PATH);
        MyBeanDefinitionRegistryPostProcessor beanpp = (MyBeanDefinitionRegistryPostProcessor)context.getBean("myBeanDefinitionRegistryPostProcessor");
        beanpp.say();

    }
}
