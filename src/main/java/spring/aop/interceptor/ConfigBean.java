package spring.aop.interceptor;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean(name = "proxyBean")
    public ProxyFactoryBean proxyBean() throws ClassNotFoundException {
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        factoryBean.setProxyInterfaces(new Class[]{TestInterface.class});
        factoryBean.setTargetName("testInterfaceImpl");
        factoryBean.setInterceptorNames(new String[]{ "transactionInterceptor","myMethodInterceptor"});
        return factoryBean;
    }

}
