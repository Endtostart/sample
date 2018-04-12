package spring.ioc;

import common.ApplicationData;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCustomEvent {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(ApplicationData.BEAN_XML_PATH);

        CustomEventPublisher cep = (CustomEventPublisher)context.getBean("customEventPublisher");
        cep.publish();
        cep.publish();
    }
}
