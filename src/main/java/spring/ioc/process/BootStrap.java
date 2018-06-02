package spring.ioc.process;

import common.ApplicationData;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class BootStrap {
    public static void main(String[] args) {
        //AbstractApplicationContext context = new ClassPathXmlApplicationContext(ApplicationData.BEAN_XML_PATH);
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("F:\\home\\sample\\src\\main\\resources\\applicationContext.xml");

    }
}
