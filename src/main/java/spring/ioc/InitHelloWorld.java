package spring.ioc;

import entityDemo.HelloWorld;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before initialization:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after initialization:"+beanName);
        return bean;
        //return new A();
    }

    /*class A extends HelloWorld{
        @Override
        public String toString(){
            return "new A";
        }
    }*/
}
